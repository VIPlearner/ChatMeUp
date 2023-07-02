package com.android.chatmeup.ui.screens.chat.viewmodel

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.android.chatmeup.AppTaskManager
import com.android.chatmeup.data.DownloadState
import com.android.chatmeup.data.Result
import com.android.chatmeup.data.datastore.CmuDataStoreRepository
import com.android.chatmeup.data.db.firebase_db.entity.Chat
import com.android.chatmeup.data.db.firebase_db.entity.ChatInfo
import com.android.chatmeup.data.db.firebase_db.entity.Message
import com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver
import com.android.chatmeup.data.db.firebase_db.repository.DatabaseRepository
import com.android.chatmeup.data.db.firebase_db.repository.StorageRepository
import com.android.chatmeup.data.db.room_db.ChatMeUpDatabase
import com.android.chatmeup.data.db.room_db.data.MessageStatus
import com.android.chatmeup.data.db.room_db.data.MessageType
import com.android.chatmeup.data.db.room_db.entity.RoomContact
import com.android.chatmeup.ui.DefaultViewModel
import com.android.chatmeup.ui.cmutoast.CmuToast
import com.android.chatmeup.ui.cmutoast.CmuToastDuration
import com.android.chatmeup.ui.cmutoast.CmuToastStyle
import com.android.chatmeup.ui.screens.chat.data.ChatState
import com.android.chatmeup.util.convertFileToByteArray
import com.android.chatmeup.util.convertFileToLowQualityThumbnail
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.LinkedList
import java.util.Locale
import java.util.Queue

class ChatViewModel @AssistedInject constructor(
    @Assisted("chatId") private val chatID: String,
    @Assisted("myUserId") private val myUserID: String,
    @Assisted("otherUserId") private val otherUserID: String,
    private val cmuDataStoreRepository: CmuDataStoreRepository,
    private val chatMeUpDatabase: ChatMeUpDatabase,
    val appTaskManager: AppTaskManager,
) : DefaultViewModel() {
    private val tag = Companion::class.java.simpleName
    private val dbRepository: DatabaseRepository = DatabaseRepository()
    private val storageRepository = StorageRepository()

    private val _otherUser = chatMeUpDatabase.contactDao.getContactFlow(otherUserID).stateIn(viewModelScope, SharingStarted.WhileSubscribed(), RoomContact(otherUserID))
    private val _chatInfo: MutableLiveData<ChatInfo> = MutableLiveData()
    private val _viewState = MutableStateFlow(ChatViewState())
    private val _chatMediaListMap = MutableStateFlow(HashMap<String, DownloadState>())

    private val _downloadQueue = MutableStateFlow<Queue<DownloadQueueData>>(LinkedList())
    private val _downloadInProgress = MutableStateFlow(false)

    private val fbRefUserInfoObserver = FirebaseReferenceValueObserver()
    private val fbRefChatInfoObserver = FirebaseReferenceValueObserver()

    private var messagesList = chatMeUpDatabase.messageDao.getMessagesOrderedByTime(chatID = chatID).stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val newMessageText = MutableStateFlow("")
    val chatInfo: LiveData<ChatInfo> = _chatInfo
    val chatState = MutableStateFlow(ChatState.CHAT)
    val chatMediaListMap = _chatMediaListMap.asStateFlow()
//    val downloadProgress = _downloadProgress.asStateFlow()
    val downloadInProgress = _downloadInProgress.asStateFlow()
    val viewState = combine(_viewState, messagesList, _otherUser){_viewState, messageList, otherUser->
        ioScope.launch{
            for (item in messageList) {
                if (item.messageType == MessageType.TEXT_IMAGE.toString()) {
                    if (!_chatMediaListMap.value.contains(item.messageID)) {
                        if (item.localFilePath?.isNotBlank() == true) _chatMediaListMap.value[item.messageID] =
                            DownloadState.Downloaded
                        else _chatMediaListMap.value[item.messageID] = DownloadState.NotDownloaded
                    }
                }
            }
            checkAndUpdateLastMessageSeen()
        }
        _viewState.copy(roomMessageList = messageList, roomContact = otherUser)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ChatViewState())

    val lazyListState = MutableStateFlow(LazyListState())

    private val ioScope = CoroutineScope(Dispatchers.IO + Job())

    init {
        setupChat()
        loadChatFromDb()
        checkAndUpdateLastMessageSeen()
    }

    override fun onCleared() {
        super.onCleared()
        fbRefUserInfoObserver.clear()
        fbRefChatInfoObserver.clear()
    }

    private fun checkAndUpdateLastMessageSeen() {
        dbRepository.loadChat(chatID) { result: Result<Chat> ->
            if (result is Result.Success && result.data != null) {
                result.data.let {
                    if (!it.lastMessage.seen && it.lastMessage.senderID != myUserID) {
                        it.lastMessage.seen = true
                        it.info.no_of_unread_messages = 0
                        dbRepository.updateChatLastMessage(chatID, it)
                    }
                }
            }
        }
        //update room database
        ioScope.launch{
            if (chatMeUpDatabase.chatDao.chatExists(chatID)) {
                val chat =
                    chatMeUpDatabase.chatDao.getChat(chatID).apply {
                        no_of_unread_messages = 0
                    }
                chatMeUpDatabase.chatDao.upsertChat(chat)
                Timber.tag(tag).d("Unread Messages Updated")
            }
        }
    }


    private fun checkAndUpdateUnreadMessages(message: Message) {
        dbRepository.loadChat(chatID) { result: Result<Chat> ->
            if (result is Result.Success && result.data != null) {
                result.data.let {
                    val chat = it.apply {
                        it.lastMessage = message
                        it.info.no_of_unread_messages++ }
                    dbRepository.updateChatLastMessage(chatID, chat)
                }
            }
        }
    }

    private fun setupChat() {
//        dbRepository.loadAndObserveUserInfo(otherUserID, fbRefUserInfoObserver) { result: Result<UserInfo> ->
//            if (result is Result.Success) {
//                result.data?.let{userInfo ->
//                    ioScope.launch {
//                        val contact = chatMeUpDatabase.contactDao.getContact(otherUserID)
//                        Timber.tag(tag).d("Updating contact ${userInfo.displayName}")
//                        chatMeUpDatabase.contactDao.upsertContact(
//                            contact.apply {
//                                isOnline = userInfo.online
//                                email = userInfo.email
//                                displayName = userInfo.displayName
//                                aboutStr = userInfo.aboutStr
//                            }
//                        )
//                    }
//                }
//            }
//            else if(result is Result.Error){
//                Timber.tag(tag).d("Error Updating contact")
//                ioScope.launch {
//                    val contact = chatMeUpDatabase.contactDao.getContact(otherUserID)
//                    chatMeUpDatabase.contactDao.upsertContact(
//                        contact.apply {
//                            isOnline = false
//                        }
//                    )
//                }
//            }
//        }
        dbRepository.loadAndObserveChatInfo(chatID, fbRefChatInfoObserver){
            onResult(_chatInfo, it)
        }
    }

    private fun loadChatFromDb(){
        ioScope.launch {
            messagesList = chatMeUpDatabase.messageDao.getMessagesOrderedByTime(chatID = chatID).stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
        }
    }

    fun sendMessagePressed(
        context: Context,
        activity: Activity?,
        newPhotoURI: Uri?,
        messageText: String,
    ) {
        ioScope.launch{
            if (newPhotoURI == null) {
                if (newMessageText.value.trim().isEmpty() || newMessageText.value.trim()
                        .isBlank()
                ) return@launch
            }
            val timeStamp: String =
                SimpleDateFormat("yyyyMMdd_HHmmssSSS", Locale.getDefault()).format(Date())
            val messageID = chatID + timeStamp
            val lowQualityThumbnail = convertFileToLowQualityThumbnail(context, newPhotoURI)
            val byteArray = convertFileToByteArray(context, newPhotoURI)
            val messageTime = Date().time
            val localFilePath = "$chatID/$messageID.png"

            //update storage
            byteArray?.let { imageBytes ->
                val file = File(context.filesDir, localFilePath)
                if (!file.parentFile?.exists()!!)
                    file.parentFile?.mkdirs()
                if (file.exists()) {
                    file.delete()
                }
                file.createNewFile()
                val fos = FileOutputStream(file)
                fos.write(imageBytes)
                fos.close()
            }

            lowQualityThumbnail?.let { imageBytes ->
                val file = File(context.filesDir, localFilePath + "_thumbnail")
                if (!file.parentFile?.exists()!!)
                    file.parentFile?.mkdirs()
                if (file.exists()) {
                    file.delete()
                }
                file.createNewFile()
                val fos = FileOutputStream(file)
                fos.write(imageBytes)
                fos.close()
            }

            //update database
            ioScope.launch {
                //update message Table
                val roomMessage = com.android.chatmeup.data.db.room_db.entity.RoomMessage(
                    messageID = messageID,
                    messageText = messageText.trim(),
                    messageTime = messageTime,
                    senderID = myUserID,
                    chatID = chatID,
                    timeStamp = timeStamp,
                    messageStatus = MessageStatus.UNSENT,
                    localFilePath = if (newPhotoURI != null) localFilePath else null,
                    messageType = if (lowQualityThumbnail != null) MessageType.TEXT_IMAGE.toString() else MessageType.TEXT.toString()
                )
                chatMeUpDatabase.messageDao.upsertMessage(roomMessage)
                //update Chat
                if (chatMeUpDatabase.chatDao.chatExists(roomMessage.chatID)) {
                    val chat =
                        chatMeUpDatabase.chatDao.getChat(roomMessage.chatID).apply {
                            lastMessageText = roomMessage.messageText
                            lastMessageTime = roomMessage.messageTime
                            messageType = enumValueOf(roomMessage.messageType)
                        }
                    chatMeUpDatabase.chatDao.upsertChat(chat)
                }

                //scroll to item
                viewModelScope.launch {
                    try{ lazyListState.value.scrollToItem(lazyListState.value.layoutInfo.totalItemsCount - 1) }
                    catch (e: Exception){
                        Timber.tag(tag).d("Unable to scroll to item $e")
                    }
                }

//            val remoteMessage = RemoteMessage.Builder(otherUserID+"@fcm.googleapis.com")
//                .setMessageId(messageID)
//                .addData("messageText" , newMessageText.value!!)
//                .addData("messageTime", messageTime.toString())
//                .addData("notificationType","MESSAGE")
//                .addData("senderID", myUserID)
//                .addData("chatID", chatID)
//
//            if(lowQualityThumbnail != null) {
//                remoteMessage.addData("lowQualityThumbnail", String(lowQualityThumbnail))
//            }
//            //send notification to device
//            Firebase.messaging.send(
//                remoteMessage.build()
//            )
            }

            if (lowQualityThumbnail == null) {
                if (!newMessageText.value.isNullOrBlank()) {
                    val newMsg = Message(
                        messageID = messageID,
                        senderID = myUserID,
                        receiverID = otherUserID,
                        text = messageText.trim(),
                        messageType = "TEXT",
                        epochTimeMs = messageTime
                    )
                    dbRepository.updateNewMessage(otherUserID, chatID, newMsg)
                    checkAndUpdateUnreadMessages(newMsg)
                    newMessageText.value = ""
                }
            } else {
                var thumbnailPath: String? = null
                var fileUrl: String? = null
                val msg = Message(
                    messageID = messageID,
                    senderID = myUserID,
                    receiverID = otherUserID,
                    text = messageText.trim(),
                    messageType = "TEXT_IMAGE",
                    epochTimeMs = messageTime
                )
                newMessageText.value = ""
                byteArray?.let {
                    storageRepository.uploadChatImage(
                        chatID = chatID,
                        byteArray = it,
                    ) { result ->
                        if (result is Result.Success) {
                            fileUrl = result.data.toString()
                            if (fileUrl != null && thumbnailPath != null) {
                                val newMsg = msg.apply {
                                    imageUrl = fileUrl.toString()
                                    thumbnailUrl = thumbnailPath.toString()
                                }
                                dbRepository.updateNewMessage(otherUserID, chatID, newMsg)
                                checkAndUpdateUnreadMessages(newMsg)
                                newMessageText.value = ""
                                //update Database
                                ioScope.launch {
                                    if (chatMeUpDatabase.messageDao.messageExists(messageID)) {
                                        val message =
                                            chatMeUpDatabase.messageDao.getMessage(messageID)
                                        chatMeUpDatabase.messageDao.upsertMessage(
                                            message.apply {
                                                this.serverFilePath = result.data.toString()
                                            }
                                        )
                                    }
                                }
                            }
                        } else if (result is Result.Error) {
                            Handler(Looper.getMainLooper()).postDelayed({
                                CmuToast.createFancyToast(
                                    context,
                                    activity,
                                    "Upload Failed",
                                    "Unable to upload Image",
                                    CmuToastStyle.ERROR,
                                    CmuToastDuration.SHORT
                                )
                            }, 200)
                        }
                    }
                }

                lowQualityThumbnail.let {
                    storageRepository.uploadChatThumbnail(
                        chatID = chatID,
                        byteArray = it,
                    ) { result ->
                        if (result is Result.Success) {
                            thumbnailPath = result.data.toString()
                            if (fileUrl != null && thumbnailPath != null) {
                                val newMsg = msg.apply {
                                    imageUrl = fileUrl.toString()
                                    thumbnailUrl = thumbnailPath.toString()
                                }
                                dbRepository.updateNewMessage(otherUserID, chatID, newMsg)
                                checkAndUpdateUnreadMessages(newMsg)
                                newMessageText.value = ""
                                //update Database
                                ioScope.launch {
                                    if (chatMeUpDatabase.messageDao.messageExists(messageID)) {
                                        val message =
                                            chatMeUpDatabase.messageDao.getMessage(messageID)
                                        chatMeUpDatabase.messageDao.upsertMessage(
                                            message.apply {
                                                this.serverFilePath = result.data.toString()
                                            }
                                        )
                                    }
                                }
                            }
                        } else if (result is Result.Error) {
                            Handler(Looper.getMainLooper()).postDelayed({
                                CmuToast.createFancyToast(
                                    context,
                                    activity,
                                    "Upload Failed",
                                    "Unable to upload Image",
                                    CmuToastStyle.ERROR,
                                    CmuToastDuration.SHORT
                                )
                            }, 200)
                        }
                    }
                }
            }
        }
    }

    fun loadImage(
        context: Context,
        activity: Activity?,
        imageUrl: String,
        messageID: String
    ){
        if(_downloadInProgress.value){
            _downloadQueue.value.add(DownloadQueueData(imageUrl, messageID))
            _chatMediaListMap.value[messageID] = DownloadState.OnQueue
            return
        }
        _downloadInProgress.value = true
//        val messageID = _downloadQueue.value.poll()
        val localFilePath = "${chatID}/$messageID.png"
        val file = File(context.filesDir, localFilePath)
        _chatMediaListMap.value[messageID] = DownloadState.Downloading(0.00)
        storageRepository.downloadChatImage(imageUrl, file){result ->
            when(result){
                is Result.Error -> {
                    Handler(Looper.getMainLooper()).postDelayed({
                        CmuToast.createFancyToast(
                            context,
                            activity,
                            "Download Failed",
                            "Unable to download Image",
                            CmuToastStyle.ERROR,
                            CmuToastDuration.SHORT
                        )
                    }, 200)
                    _chatMediaListMap.value[messageID] = DownloadState.Downloaded
                    _downloadInProgress.value = false
                    _downloadQueue.value.poll()?.let { loadImage(context, activity, it.imageUrl, it.messageID) }//if there's anything on the queue it should download it
                }
                Result.Loading -> {
                    // do nothing for now at least
                    _chatMediaListMap.value[messageID] = DownloadState.Downloading(0.00)
                }
                is Result.Progress -> {
                    _chatMediaListMap.value[messageID] = DownloadState.Downloading(result.double)
                }
                is Result.Success -> {
                    //update database
                    ioScope.launch {
                        val message = chatMeUpDatabase.messageDao.getMessage(messageID)
                        chatMeUpDatabase.messageDao.upsertMessage(message.apply { this.localFilePath = localFilePath })
                    }
                    _downloadInProgress.value = false
                    _chatMediaListMap.value[messageID] = DownloadState.Downloaded
                    _downloadQueue.value.poll()?.let { loadImage(context, activity,it.imageUrl, it.messageID) }//if there's anything on the queue it should download it
                }
            }
        }
    }

    data class ChatViewState(
        var roomMessageList: List<com.android.chatmeup.data.db.room_db.entity.RoomMessage> = emptyList(),
        var roomContact: RoomContact = RoomContact("")
    )

    data class DownloadQueueData(
        val imageUrl: String,
        val messageID: String,
    )

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("chatId") chatId: String,
            @Assisted("myUserId") myUserId: String,
            @Assisted("otherUserId") otherUserId: String,
        ): ChatViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            chatId: String,
            myUserId: String,
            otherUserId: String,

        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return assistedFactory.create(
                    chatId, myUserId, otherUserId
                ) as T
            }
        }
    }
}