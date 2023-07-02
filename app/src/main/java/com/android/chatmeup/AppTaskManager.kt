package com.android.chatmeup

import android.content.Context
import android.net.Uri
import com.android.chatmeup.data.Result
import com.android.chatmeup.data.db.firebase_db.entity.Chat
import com.android.chatmeup.data.db.firebase_db.entity.Message
import com.android.chatmeup.data.db.firebase_db.entity.UserFriend
import com.android.chatmeup.data.db.firebase_db.entity.UserInfo
import com.android.chatmeup.data.db.firebase_db.repository.DatabaseRepository
import com.android.chatmeup.data.db.firebase_db.repository.StorageRepository
import com.android.chatmeup.data.db.room_db.ChatMeUpDatabase
import com.android.chatmeup.data.db.room_db.data.MessageType
import com.android.chatmeup.data.db.room_db.entity.RoomChat
import com.android.chatmeup.data.db.room_db.entity.RoomContact
import com.android.chatmeup.data.db.room_db.entity.RoomMessage
import com.android.chatmeup.util.convertTwoUserIDs
import com.android.chatmeup.util.firebaseMessageToRoomMessage
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.LinkedList
import java.util.Queue
import javax.inject.Inject

class AppTaskManager @Inject constructor(private val chatMeUpDatabase: ChatMeUpDatabase) {
    private val tag = AppTaskManager::class.java.simpleName
    private var taskInProgressState: Boolean = false
    val taskInProgress: Boolean
        get() = taskInProgressState

    private var downloadTaskInProgressState: Boolean = false
    val downloadTaskInProgress: Boolean
        get() = downloadTaskInProgressState

    private var uploadTaskInProgressState: Boolean = false
    val uploadTaskInProgress: Boolean
        get() = uploadTaskInProgressState

    private val taskQueue: LinkedList<Task> = LinkedList()
    private val downloadTaskQueue: Queue<DownloadTask> = LinkedList()
    private val uploadTaskQueue: Queue<UploadTask> = LinkedList()
    private val dbRepository: DatabaseRepository = DatabaseRepository()
    private val storageRepository: StorageRepository = StorageRepository()
    private val ioScope = CoroutineScope(Dispatchers.IO + Job())

    fun addTaskToQueue(task: Task){
//        Timber.tag(tag).d("Task Added $task")
        if(taskInProgressState){
            taskQueue.add(task)
            return
        }
        performTask(task)
    }

    fun addDownloadTask(
        context: Context,
        downloadTask: DownloadTask,
        listener: FileDownloadListener? = null,
    ){
        if(downloadTaskInProgressState){
            downloadTaskQueue.add(downloadTask)
            return
        }
        performDownloadTask(context, downloadTask, listener)
    }

    private fun addUploadTask(context: Context, uploadTask: UploadTask){
        if(uploadTaskInProgressState){
            uploadTaskQueue.add(uploadTask)
            return
        }
        performUploadTask(context, uploadTask)
    }

    private fun onTaskCompleted(){
        taskInProgressState = false
        taskQueue.poll()?.let{
            performTask(it)
        }
    }

    private fun onDownloadTaskCompleted(
        context: Context,
        downloadTask: DownloadTask,
        isSuccessful: Boolean = true
    ){
        downloadTaskInProgressState = false
        if(downloadTask.shouldRetry && !isSuccessful){
            performDownloadTask(context, downloadTask)
            return
        }
        downloadTask.onDone?.invoke()
        downloadTaskQueue.poll()?.let{
            performDownloadTask(context, it)
        }
    }

    private fun onUploadTaskCompleted(context: Context){
        uploadTaskInProgressState = false
        uploadTaskQueue.poll()?.let{
            performUploadTask(context, it)
        }
    }

    private fun performTask(task: Task){
        ioScope.launch{
            when (task) {
                is Task.AddNewContact -> {
                    addNewContact(task.userID)
                }
                is Task.CreateNewChatFromUserID -> {
                    createNewChatFromUserID(task.context, task.userID)
                }
                is Task.CreateNewChatFromUserInfo -> {
                    createNewChatFromUserInfo(task.context, task.userInfo)
                }
                is Task.CreateNewContactFromUserID -> {
                    createNewContactFromUserId(task.context, task.userID)
                }
                is Task.CreateNewContactFromUserInfo -> {
                    createNewContactFromUserInfo(task.context, task.userInfo)
                }
                is Task.CreateNewRoomMessageFromFBMessage -> {
                    createNewRoomMessageFromFBMessage(task.context, task.message)
                }
                is Task.DeleteChatUsingChatID -> {
                    deleteChatUsingChatID(task.chatID)
                }
                is Task.DeleteChatUsingUserID -> {
                    deleteChatUsingChatID(task.userID)
                }
                is Task.DeleteContactUsingUserID -> {
                    deleteContactUsingContactID(task.userID)
                }
                is Task.DeleteMessage -> {
                    deleteMessage(task.otherUserID, task.roomMessage)
                }
                is Task.DeleteMessageFromRoomDB -> {
                    deleteMessageFromRoomDB(task.messageID)
                }
                is Task.LoadMessagesUsingChatID ->{
                    loadMessagesUsingChatID(task.context, task.chatID)
                }
                is Task.UpdateAbout -> {
                    updateAbout(task.about)
                }
                is Task.UpdateChatFromUserInfoUsingUserID -> {
                    updateChatFromUserInfoUsingUserID(task.context, task.userID)
                }
                is Task.UpdateChatUsingUserInfo -> {
                    updateChatUsingUserInfo(task.context, task.userInfo)
                }
                is Task.UpdateContactUsingUserID -> {
                    updateContactUsingUserID(task.context,task.userID)
                }
                is Task.UpdateContactUsingUserInfo -> {
                    updateContactUsingUserInfo(task.context, task.userInfo)
                }
                is Task.UpdateDisplayName -> {
                    updateDisplayName(task.displayName)
                }

                is Task.UpdateOnlineStatus -> {
                    updateOnlineStatus(task.isOnline)
                }
                is Task.UpdateRoomChatFromFBChat -> {
                    updateRoomChatFromFBChat(task.chatID)
                }
//                is Task.UpdateRoomMessageFromFBMessage -> {
//                    //TODO the idea of this is supposed to be like an edit message Feature Not implemented yet tho
//                }
            }
        }
    }

    private fun performDownloadTask(
        context: Context,
        downloadTask: DownloadTask,
        listener: FileDownloadListener? = null,
    ){
        Timber.tag(tag).d("Downloading File ${downloadTask.url}")
        ioScope.launch(){
            try{
                storageRepository.downloadImage(
                    downloadTask.url,
                    context,
                    downloadTask.localFilePath
                ) { result ->
                    when (result) {
                        is Result.Error -> {
                            listener?.onFailed()
                            onDownloadTaskCompleted(context, downloadTask, false)
                        }
                        Result.Loading -> {
                            listener?.onLoading()
                        }
                        is Result.Progress -> {
                            listener?.onLoading()
                        }
                        is Result.Success -> {
                            onDownloadTaskCompleted(context, downloadTask)
                            Timber.tag(tag).d("Downloaded File ${downloadTask.url}")
                        }
                    }
                }
            }catch (e: Exception){
                Timber.tag(tag).d("Unable to load file ${downloadTask.url}")
                onDownloadTaskCompleted(context, downloadTask, false)
            }
        }
    }

    private fun performUploadTask(context: Context, uploadTask: UploadTask,){
        ioScope.launch(){
            try{
                storageRepository.uploadFile(
                    uploadTask.localFilePath,
                    uploadTask.uri
                ) { result ->
                    when (result) {
                        is Result.Error -> {
                            // show error
                            onUploadTaskCompleted(context)
                            uploadTask.listener.onFailed()
                        }

                        Result.Loading -> {
                            uploadTask.listener.onLoading()
                        }

                        is Result.Progress -> {
                            uploadTask.listener.onLoading()
                        }

                        is Result.Success -> {
                            onUploadTaskCompleted(context)
                            uploadTask.listener.onCompleted(result.data)
                        }
                    }
                }
            }catch (e: Exception){
                Timber.tag(tag).d("Unable to load file ${uploadTask.localFilePath}")
                onUploadTaskCompleted(context)
                uploadTask.listener.onFailed()
            }
        }
    }

    fun cancelAllTasks(){
        taskQueue.clear()
    }

    fun cancelTask(task: Task){
        try{ taskQueue.remove(task) }
        catch (e: Exception){
            Timber.tag(tag).e("Unable to remove task error $e")
            //do nothing
        }
    }

    private fun addNewContact(userID: String){
        taskInProgressState = true
        val myUserID = Firebase.auth.uid
        if(myUserID == null){
            onTaskCompleted()
            return
        }
        dbRepository.updateNewFriend(UserFriend(myUserID), UserFriend(userID))
        dbRepository.pushNewContact(userID, myUserID)
        val newChat = Chat().apply {
            info.id = convertTwoUserIDs(myUserID, userID)
            lastMessage = Message(senderID = myUserID, seen = false, text = "Say hello!")
        }
        dbRepository.updateNewChat(newChat)
        dbRepository.loadUserInfo(userID){result ->
            when(result){
                is Result.Error -> {
                    Timber.tag(tag).e("Error while adding new contact ${result.msg}")
                    addNewContact(userID) // try again
                }
                Result.Loading -> {}
                is Result.Progress -> {}
                is Result.Success -> {
                    ioScope.launch {
                        result.data?.let{
                            chatMeUpDatabase.contactDao.upsertContact(
                                RoomContact(
                                    userID = it.id,
                                    displayName = it.displayName,
                                    email = it.email,
                                    aboutStr = it.aboutStr,
                                    isOnline = it.online,
                                    onlinePhotoPath = it.profileImageUrl,
                                    localProfilePhotoPath = "profile_photos/${it.id}.png"
                                )
                            )
                            chatMeUpDatabase.chatDao.upsertChat(
                                RoomChat(
                                    id = convertTwoUserIDs(
                                        myUserID,
                                        it.id
                                    ),
                                    displayName = it.displayName,
                                    profilePhotoPath = "profile_photos/${it.id}.png",
                                    otherUserId = it.id,
                                )
                            )
                        }
                        onTaskCompleted()
                    }
                }
            }
        }
    }
    private fun createNewChatFromUserID(context: Context, userID: String){
        taskInProgressState = true
        val myUserID = Firebase.auth.uid
        if(myUserID == null){
            onTaskCompleted()
            return
        }
        dbRepository.loadUserInfo(userID){result ->
            when(result) {
                is Result.Success ->{
                    result.data?.let {
                        addTaskToQueue(Task.CreateNewChatFromUserInfo(context, it))
                        addTaskToQueue(Task.UpdateRoomChatFromFBChat(convertTwoUserIDs(myUserID, it.id)))
                    }
                    onTaskCompleted()
                }
                is Result.Error -> {
                    //TODO:: Show something
                    createNewChatFromUserID(context, userID)//basically try again
                    Timber.tag(tag).e("Error while creating new chat from userID${result.msg}")
                }
                else -> {}
            }
        }
    }
    private fun createNewChatFromUserInfo(context: Context, userInfo: UserInfo){
        taskInProgressState = true
        val myUserID = Firebase.auth.uid
        if(myUserID == null){
            onTaskCompleted()
            return
        }
        addTaskToQueue(Task.LoadMessagesUsingChatID(context, convertTwoUserIDs(myUserID, userInfo.id)))
        addTaskToQueue(Task.UpdateRoomChatFromFBChat(convertTwoUserIDs(myUserID, userInfo.id)))
        ioScope.launch {
            chatMeUpDatabase.chatDao.upsertChat(
                RoomChat(
                    id = convertTwoUserIDs(
                        myUserID,
                        userInfo.id
                    ),
                    displayName = userInfo.displayName,
                    profilePhotoPath = "profile_photos/${userInfo.id}.png",
                    otherUserId = userInfo.id,
                )
            )
            onTaskCompleted()
        }
    }
    private fun createNewContactFromUserId(context: Context, userID: String){
        taskInProgressState = true
        dbRepository.loadUserInfo(userID){result ->
            when(result) {
                is Result.Success ->{
                    ioScope.launch {
                        result.data?.let{
                            addTaskToQueue(Task.CreateNewContactFromUserInfo(context, it))
                        }
                        onTaskCompleted()
                    }
                }
                is Result.Error -> {
                    //TODO:: Show something
                    Timber.tag(tag).e("Error while creating new contact from userID${result.msg}")
                    createNewContactFromUserId(context,userID)
                }
                else -> {}
            }
        }
    }
    private fun createNewContactFromUserInfo(context: Context, it: UserInfo){
        taskInProgressState = true
        ioScope.launch{
            val contact = RoomContact(
                userID = it.id,
                displayName = it.displayName,
                email = it.email,
                aboutStr = it.aboutStr,
                isOnline = it.online,
                localProfilePhotoPath = "profile_photos/${it.id}.png"
            )
            chatMeUpDatabase.contactDao.upsertContact(contact)
            if(it.profileImageUrl.isNotEmpty()){
                val localFilePath = "profile_photos/${it.id}.png"
                addDownloadTask(
                    context = context,
                    downloadTask = DownloadTask(
                        url = it.profileImageUrl,
                        localFilePath = localFilePath,
                        shouldRetry = true,
                        onDone = {
                            ioScope.launch {
                                chatMeUpDatabase.contactDao.upsertContact(contact.copy(
                                    onlinePhotoPath = it.profileImageUrl
                                ))
                            }
                        }
                    ),
                )
            }
            onTaskCompleted()
        }
    }
    private fun createNewRoomMessageFromFBMessage(context: Context, message: Message){
        taskInProgressState = true
        val chatID = convertTwoUserIDs(message.senderID, message.receiverID)
        val messageID = message.messageID

        ioScope.launch{
            val roomMessage = firebaseMessageToRoomMessage(message)
            chatMeUpDatabase.messageDao.upsertMessage(roomMessage)
            if(message.messageType == MessageType.TEXT_IMAGE.toString()){
                val localFilePath = "${chatID}/${messageID}_thumbnail.png"
                addDownloadTask(
                    context = context,
                    downloadTask = DownloadTask(
                        url = message.thumbnailUrl,
                        localFilePath = localFilePath,
                        shouldRetry = true,
                        onDone = {
                            ioScope.launch{
                                chatMeUpDatabase.messageDao.upsertMessage(roomMessage.copy(localThumbnailPath = localFilePath))
                            }
                        }
                    ),
                )

            }
            onTaskCompleted()
        }
    }
    private fun deleteChatUsingChatID(chatID: String){
        taskInProgressState = true
        dbRepository.removeChat(chatID)
        dbRepository.removeMessages(chatID)
        ioScope.launch {
            try{
                if (!chatMeUpDatabase.chatDao.chatExists(chatID)) {
                    onTaskCompleted()
                    return@launch
                }
            }catch (e: Exception){
                Timber.tag(tag).e("Error $e")
                onTaskCompleted()
                return@launch
            }
            val chat = chatMeUpDatabase.chatDao.getChat(chatID)
            chatMeUpDatabase.chatDao.deleteChat(chat)
        }
        ioScope.launch {
            try{
                if (!chatMeUpDatabase.messageDao.messagesExistsInChat(chatID)) {
                    onTaskCompleted()
                    return@launch
                }
            }catch (e: Exception){
                Timber.tag(tag).e("Error $e")
                onTaskCompleted()
                return@launch
            }
            chatMeUpDatabase.messageDao.getMessagesOrderedByTime(chatID).collect{messageList ->
                ioScope.launch{
                    for (item in messageList) {
                        chatMeUpDatabase.messageDao.deleteMessage(item)
                    }
                    onTaskCompleted()
                }
            }
        }
    }
    private fun deleteChatUsingUserID(userID: String){
        taskInProgressState = true
        val myUserID = Firebase.auth.uid
        if(myUserID == null){
            onTaskCompleted()
            return
        }
        val chatID = convertTwoUserIDs(myUserID, userID)
        addTaskToQueue(Task.DeleteChatUsingChatID(chatID))
        onTaskCompleted()
    }
    private fun deleteContactUsingContactID(userID: String){
        taskInProgressState = true
        val myUserID = Firebase.auth.uid
        if(myUserID == null) {
            onTaskCompleted()
            return
        }
        ioScope.launch {
            dbRepository.removeFriend(myUserID, userID)
            try{
                if (!chatMeUpDatabase.contactDao.contactExists(userID)) {
                    onTaskCompleted()
                    return@launch
                }
            }catch (e:Exception){
                Timber.tag(tag).e("Error $e")
                onTaskCompleted()
                return@launch
            }
            val contact = chatMeUpDatabase.contactDao.getContact(userID)
            chatMeUpDatabase.contactDao.deleteContact(contact)
            dbRepository.removeFriend(myUserID, userID)
            dbRepository.removeContact(userID, myUserID)
            onTaskCompleted()
        }
    }
    private fun deleteMessage(otherUserID: String, roomMessage: RoomMessage){
        taskInProgressState = true
        val myUserID = Firebase.auth.uid
        if(myUserID == null) {
            onTaskCompleted()
            return
        }
        dbRepository.removeMessage(otherUserID,roomMessage.chatID, roomMessage.messageID)
        ioScope.launch {
            chatMeUpDatabase.messageDao.deleteMessage(roomMessage)
            onTaskCompleted()
        }
    }

    private fun deleteMessageFromRoomDB(messageID: String){
        ioScope.launch{
            try {
                if (!chatMeUpDatabase.messageDao.messageExists(messageID)) {
                    onTaskCompleted()
                    return@launch
                }
            } catch (e: Exception) {
                Timber.tag(tag).e("Error $e")
                onTaskCompleted()
                return@launch
            }
            val message = chatMeUpDatabase.messageDao.getMessage(messageID)
            chatMeUpDatabase.messageDao.deleteMessage(message)
            onTaskCompleted()
        }
    }
    private fun loadMessagesUsingChatID(context: Context, chatID: String){
        taskInProgressState = true
        dbRepository.loadMessages(chatID){result ->
            when(result){
                is Result.Error -> {
                    loadMessagesUsingChatID(context, chatID)
                }
                Result.Loading -> {}
                is Result.Progress -> {}
                is Result.Success -> {
                    result.data?.let{messages ->
                        messages.forEach {
                            addTaskToQueue(Task.CreateNewRoomMessageFromFBMessage(context, it))
                        }
                    }
                    onTaskCompleted()
                }
            }
        }
    }
    private fun updateAbout(about: String){
        taskInProgressState = true
        val myUserID = Firebase.auth.uid
        if(myUserID == null) {
            onTaskCompleted()
            return
        }
        dbRepository.updateUserStatus(myUserID, about)
        ioScope.launch {
            try{
                val contact = chatMeUpDatabase.contactDao.getContact(myUserID)
                chatMeUpDatabase.contactDao.upsertContact(contact.copy(aboutStr = about))
                onTaskCompleted()
            }catch (e:Exception){
                Timber.tag(tag).e("Error $e")
                onTaskCompleted()
                return@launch
            }
        }
    }
    private fun updateChatFromUserInfoUsingUserID(context: Context, userID: String){
        taskInProgressState = true
        val myUserID = Firebase.auth.uid
        if(myUserID.isNullOrEmpty()) {
            onTaskCompleted()
            return
        }
        dbRepository.loadUserInfo(userID){result ->
            when(result) {
                is Result.Success ->{
                    ioScope.launch {
                        result.data?.let{
                            taskQueue.add(Task.UpdateChatUsingUserInfo(context,it))
                        }
                        onTaskCompleted()
                    }
                }
                is Result.Error -> {
                    //TODO:: Show something
                    Timber.tag(tag).e("Error while Updating chat from user info using user id${result.msg}")
                    updateChatFromUserInfoUsingUserID(context, userID)
                }
                else -> {}
            }
        }
    }
    private fun updateChatUsingUserInfo(context: Context, it: UserInfo){
        taskInProgressState = true
        val myUserID = Firebase.auth.uid
        if(myUserID.isNullOrEmpty()) {
            onTaskCompleted()
            return
        }
        ioScope.launch {
            try{
                if (chatMeUpDatabase.chatDao.chatExists(convertTwoUserIDs(myUserID, it.id))) {
                    val chat = chatMeUpDatabase.chatDao.getChat(convertTwoUserIDs(myUserID, it.id))
                    chatMeUpDatabase.chatDao.upsertChat(
                        chat.copy(
                            displayName = it.displayName,
                            onlineProfilePhotoPath = it.profileImageUrl
                        )
                    )
                } else {
                    taskQueue.add(Task.CreateNewChatFromUserInfo(context, it))
                }
                onTaskCompleted()
            }catch (e: Exception){
                Timber.tag(tag).e("Error $e")
                onTaskCompleted()
                return@launch
            }
        }
    }
    private fun updateContactUsingUserID(context: Context,userID: String){
        taskInProgressState = true
        dbRepository.loadUserInfo(userID){result ->
            when(result) {
                is Result.Success ->{
                    result.data?.let{ addTaskToQueue(Task.UpdateContactUsingUserInfo(context,it)) }
                    onTaskCompleted()
                }
                is Result.Error -> {
                    //TODO:: Show something
                    Timber.tag(tag).e("Error while updating contact from userID${result.msg}")
                    updateContactUsingUserID(context, userID) // try again
                }
                else -> {}
            }
        }
    }
    private fun updateContactUsingUserInfo(context: Context,it: UserInfo){
        taskInProgressState = true
        ioScope.launch{
            try{
                if (!chatMeUpDatabase.contactDao.contactExists(it.id)) {
                    taskQueue.add(Task.CreateNewContactFromUserInfo(context, it))
                    onTaskCompleted()
                    return@launch
                }
            }catch (e: java.lang.Exception){
                Timber.tag(tag).e("Error $e")
                onTaskCompleted()
                return@launch
            }
            val contact = chatMeUpDatabase.contactDao.getContact(it.id)
            if (contact.onlinePhotoPath != it.profileImageUrl) {
                //add Download Task
                addDownloadTask(
                    context = context,
                    downloadTask = DownloadTask(
                        url = it.profileImageUrl,
                        localFilePath = contact.localProfilePhotoPath,
                        shouldRetry = true,
                        onDone = {
                            ioScope.launch {
                                chatMeUpDatabase.contactDao.upsertContact(
                                    contact.copy(
                                        userID = it.id,
                                        displayName = it.displayName,
                                        email = it.email,
                                        aboutStr = it.aboutStr,
                                        onlinePhotoPath = it.profileImageUrl,
                                        isOnline = it.online
                                    )
                                )
                            }
                        }
                    ),
                    listener = object: FileDownloadListener{
                        override fun onCompleted(path: String) {
                            //save file to
                        }
                        override fun onFailed() {
                        }
                        override fun onLoading(progress: Double?) {
                            //do nothing
                        }

                    },
                )
                onTaskCompleted()
                return@launch
            }
            chatMeUpDatabase.contactDao.upsertContact(
                contact.copy(
                    displayName = it.displayName,
                    email = it.email,
                    aboutStr = it.aboutStr,
                    onlinePhotoPath = it.profileImageUrl,
                    isOnline = it.online
                )
            )
            onTaskCompleted()
        }
    }
    private fun updateDisplayName(displayName: String){
        taskInProgressState = true
        val myUserID = Firebase.auth.uid
        if(myUserID == null) {
            onTaskCompleted()
            return
        }
        dbRepository.updateDisplayName(myUserID, displayName)
        ioScope.launch {
            try{
                val contact = chatMeUpDatabase.contactDao.getContact(myUserID)
                chatMeUpDatabase.contactDao.upsertContact(contact.copy(displayName = displayName))
                onTaskCompleted()
            }catch(e:Exception){
                Timber.tag(tag).e("Error $e")
                onTaskCompleted()
                return@launch
            }
        }
    }
    private fun updateOnlineStatus(isOnline: Boolean){
        taskInProgressState = true
        val myUserID = Firebase.auth.uid
        if(myUserID == null) {
            onTaskCompleted()
            return
        }
        dbRepository.updateOnlineStatus(myUserID, isOnline)
        ioScope.launch {
            try{
                val contact = chatMeUpDatabase.contactDao.getContact(myUserID)
                chatMeUpDatabase.contactDao.upsertContact(contact.copy(isOnline = isOnline))
                onTaskCompleted()
            }
            catch (e: Exception){
                Timber.tag(tag).e("Error $e")
                onTaskCompleted()
                return@launch
            }
        }
    }
    private fun updateRoomChatFromFBChat(chatID: String){
        taskInProgressState = true
        dbRepository.loadChat(chatID){result ->
            if(result is Result.Success){
                result.data?.let{
                    ioScope.launch {
                        try{
                            if (!chatMeUpDatabase.chatDao.chatExists(chatID)) {
                                onTaskCompleted()
                                return@launch
                            }
                            val chat = chatMeUpDatabase.chatDao.getChat(chatID)
                            chatMeUpDatabase.chatDao.upsertChat(
                                chat.copy(
                                    lastMessageSenderID = it.lastMessage.senderID,
                                    lastMessageText = it.lastMessage.text,
                                    lastMessageTime = it.lastMessage.epochTimeMs,
                                    no_of_unread_messages = it.info.no_of_unread_messages,
                                    messageType = enumValueOf(it.lastMessage.messageType)
                                )
                            )
                            onTaskCompleted()
                        }catch (e: Exception){
                            Timber.tag(tag).e("Error $e")
                            onTaskCompleted()
                            return@launch
                        }
                    }
                }
            }
            else if(result is Result.Error){
                updateRoomChatFromFBChat(chatID)
            }
        }
    }

    interface FileUploadListener{
        fun onCompleted(uri: Uri?)
        fun onFailed()
        fun onLoading(progress: Double? = null)
    }

    interface FileDownloadListener{
        fun onCompleted(path: String)
        fun onFailed()
        fun onLoading(progress: Double? = null)
    }

    sealed class Task {
        data class AddNewContact(
            val userID: String,
        ): Task()
        data class CreateNewChatFromUserID(
            val context: Context,
            val userID: String
        ): Task()
        data class CreateNewChatFromUserInfo(
            val context: Context,
            val userInfo: UserInfo
        ): Task()
        data class CreateNewContactFromUserID(
            val context: Context,
            val userID: String
        ): Task()//
        data class CreateNewContactFromUserInfo(
            val context: Context,
            val userInfo: UserInfo
        ): Task()
        data class CreateNewRoomMessageFromFBMessage(
            val context: Context,
            val message: Message
        ): Task()
        data class DeleteChatUsingChatID(
            val chatID: String
        ): Task()
        data class DeleteChatUsingUserID(
            val userID: String
        ): Task()
        data class DeleteContactUsingUserID(
            val userID: String
        ): Task()
        data class DeleteMessage(
            val otherUserID: String,
            val roomMessage: RoomMessage,
        ): Task()
        data class DeleteMessageFromRoomDB(
            val messageID: String
        ): Task()
        data class LoadMessagesUsingChatID(
            val context: Context,
            val chatID: String
        ): Task()
        data class UpdateChatFromUserInfoUsingUserID(
            val context: Context,
            val userID: String
        ): Task()
        data class UpdateChatUsingUserInfo(
            val context: Context,
            val userInfo: UserInfo
        ): Task()
        data class UpdateContactUsingUserID(
            val context: Context,
            val userID: String
        ): Task()
        data class UpdateContactUsingUserInfo(
            val context: Context,
            val userInfo: UserInfo
        ): Task()
        data class UpdateOnlineStatus(
            val isOnline: Boolean,
        ):Task()
        data class UpdateDisplayName(
            val displayName: String
        ): Task()
        data class UpdateAbout(
            val about: String
        ): Task()
//        data class UpdateRoomMessageFromFBMessage(
//            val message: Message
//        ): Task()
        data class UpdateRoomChatFromFBChat(
            val chatID: String
        ): Task()
    }
    data class DownloadTask(
        val url: String,
        val localFilePath: String,
        val shouldRetry: Boolean = false,
        val onDone: (() -> Unit)? = null
    )
    data class UploadTask(
        val localFilePath: String,
        val uri: Uri,
        val listener: FileUploadListener
    )
}