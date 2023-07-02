package com.android.chatmeup.ui.screens.homescreen.viewmodel

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.annotation.WorkerThread
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.android.chatmeup.AppTaskManager
import com.android.chatmeup.data.Result
import com.android.chatmeup.data.datastore.CmuDataStoreRepository
import com.android.chatmeup.data.db.firebase_db.entity.User
import com.android.chatmeup.data.db.firebase_db.entity.UserInfo
import com.android.chatmeup.data.db.firebase_db.entity.UserNotification
import com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver
import com.android.chatmeup.data.db.firebase_db.repository.AuthRepository
import com.android.chatmeup.data.db.firebase_db.repository.DatabaseRepository
import com.android.chatmeup.data.db.room_db.ChatMeUpDatabase
import com.android.chatmeup.data.db.room_db.entity.RoomChat
import com.android.chatmeup.data.db.room_db.entity.RoomContact
import com.android.chatmeup.data.model.ChatWithUserInfo
import com.android.chatmeup.ui.DefaultViewModel
import com.android.chatmeup.ui.cmutoast.CmuToast
import com.android.chatmeup.ui.cmutoast.CmuToastDuration
import com.android.chatmeup.ui.cmutoast.CmuToastStyle
import com.android.chatmeup.util.addNewItem
import com.android.chatmeup.util.removeItem
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
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

enum class HomeEventState{
    INIT,
    LOADING,
    SUCCESS,
    ERROR
}

enum class AddContactEventState{
    DO_NOTHING,
    LOADING,
    ERROR,
    SUCCESS
}

class HomeViewModel @AssistedInject constructor(
    @Assisted("myUserId") var myUserId: String,
    private val cmuDataStoreRepository: CmuDataStoreRepository,
    private val chatMeUpDatabase: ChatMeUpDatabase,
    val appTaskManager: AppTaskManager,
): DefaultViewModel() {
    private val tag = "HomeViewModel"
    val homeEventState = MutableStateFlow(HomeEventState.INIT)

    private val _addContactEventState = MutableStateFlow(AddContactEventState.DO_NOTHING)
    val addContactEventState = _addContactEventState.asStateFlow()

    private val authRepository: AuthRepository = AuthRepository()
    private val dbRepository: DatabaseRepository = DatabaseRepository()
    private val firebaseReferenceObserverList = ArrayList<FirebaseReferenceValueObserver>()

    private val _updatedUserNotification = MutableLiveData<UserInfo>()
    private val _updatedChatWithUserInfo = MutableLiveData<ChatWithUserInfo>()

    private val _myContact = chatMeUpDatabase.contactDao.getContactFlow(myUserId)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), RoomContact(""))
    private val _chatsList = chatMeUpDatabase.chatDao.getChatsOrderedByTime()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), listOf())
    private val _viewState = MutableStateFlow(HomeViewState())


    val notificationListWithUserInfo = MediatorLiveData<MutableList<UserInfo>>()
    val ioScope = CoroutineScope(Dispatchers.IO + Job())

    val viewState = combine(_viewState, _myContact, _chatsList){viewState, myContact, chatsList->
        try{
            viewState.copy(
                myContact = myContact,
                chatsList = chatsList
            )
        }catch (e: NullPointerException){
            Timber.tag(tag).e("viewState not updated error $e")
            viewState
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HomeViewState())

    init {
        myUserId = Firebase.auth.currentUser?.uid ?: ""
        this.notificationListWithUserInfo.addSource(_updatedUserNotification) { newNotification ->
            this.notificationListWithUserInfo.addNewItem(newNotification)
        }
        loadAndObserveNotifications()
    }

    override fun onCleared() {
        super.onCleared()
        firebaseReferenceObserverList.forEach { it.clear() }
    }


    private fun loadUserID() = viewModelScope.launch {
        cmuDataStoreRepository.getUserId().collect{
            myUserId = it
        }
    }

//    private fun getChatItems(){
//        viewModelScope.launch {
//            chatMeUpDatabase.chatDao.getChatsOrderedByTime().collectLatest {_chatsList ->
//                _viewState.value = _viewState.value.copy(
//                    chatsList = _chatsList
//                )
//            }
//        }
//    }
//
//    private fun loadAndObserveMyInfo() {
////        viewModelScope.launch {
////            chatMeUpDatabase.contactDao.getContactFlow(myUserId).collectLatest {_myContact ->
////                _viewState.value = _viewState.value.copy(
////                    myContact = _myContact
////                )
////            }
////        }
//    }

    private fun updateNotification(otherUserInfo: UserInfo, removeOnly: Boolean) {
        val userNotification = this.notificationListWithUserInfo.value?.find {
            it.id == otherUserInfo.id
        }

        if (userNotification != null) {
            if (!removeOnly) {
               appTaskManager.addTaskToQueue(AppTaskManager.Task.AddNewContact(
                   userNotification.id
               ))
            }
            dbRepository.removeNotification(myUserId, otherUserInfo.id)
            dbRepository.removeSentRequest(otherUserInfo.id, myUserId)

//            usersInfoList.removeItem(otherUserInfo)
            this.notificationListWithUserInfo.removeItem(userNotification)
        }
    }

    fun acceptNotificationPressed(userInfo: UserInfo) {
        updateNotification(userInfo, false)
    }

    fun declineNotificationPressed(userInfo: UserInfo) {
        updateNotification(userInfo, true)
    }

    private fun loadUserInfo(userNotification: UserNotification) {
        dbRepository.loadUserInfo(userNotification.userID) { result: Result<UserInfo> ->
            onResult(_updatedUserNotification, result)
        }
    }

    private fun loadAndObserveNotifications(){
        Timber.tag(tag).d("uidnotifica is $myUserId")
        val observer = FirebaseReferenceValueObserver()
        firebaseReferenceObserverList.add(observer)
        dbRepository.loadAndObserveUserNotifications(myUserId, observer){result ->
            if (result is Result.Success) {
                result.data?.forEach { loadUserInfo(it) }
            }
        }
    }

    fun onAddContactEventTriggered(
        event: AddContactEvents,
        context: Context,
        activity: Activity?,
        errorMsg: String = "",
        email: String = "",
    ){
        when(event){
            AddContactEvents.DoNothing -> {
                _addContactEventState.value = AddContactEventState.DO_NOTHING
            }
            AddContactEvents.Loading -> {
                _addContactEventState.value = AddContactEventState.LOADING
                sendFriendRequest(context, activity, email)
            }
            AddContactEvents.Success -> {
                _addContactEventState.value = AddContactEventState.SUCCESS
                Handler(Looper.getMainLooper()).postDelayed({
                    CmuToast.createFancyToast(
                        context,
                        activity,
                        "Add Contact",
                        "Request Sent",
                        CmuToastStyle.SUCCESS,
                        CmuToastDuration.SHORT
                    )
                }, 200)
                onAddContactEventTriggered(
                    event = AddContactEvents.DoNothing,
                    context, activity, errorMsg = "User does not have a ChatMeUp Account"
                )
            }
            AddContactEvents.Error -> {
                _addContactEventState.value = AddContactEventState.ERROR
                Handler(Looper.getMainLooper()).postDelayed({
                    CmuToast.createFancyToast(
                        context,
                        activity,
                        "Add Contact",
                        errorMsg,
                        CmuToastStyle.ERROR,
                        CmuToastDuration.SHORT
                    )
                }, 200)
                onAddContactEventTriggered(
                    event = AddContactEvents.DoNothing,
                    context, activity
                )
            }
        }
    }


    @WorkerThread
    private fun sendFriendRequest(
        context: Context,
        activity: Activity?,
        email: String
    ){
        var uid = ""
        dbRepository.loadUsers { result: Result<MutableList<User>> ->
            onResult(null, result)
            if (result is Result.Success) {
                ioScope.launch{
                    result.data?.forEach {
                        if (it.info.email == email) {
                            uid = it.info.id
                            return@forEach
                        }
                    }
                    if (uid.isBlank()) {
                        onAddContactEventTriggered(
                            AddContactEvents.Error,
                            context, activity,
                            errorMsg = "User does not have a ChatMeUp Account"
                        )
                    } else if (chatMeUpDatabase.contactDao.contactExists(uid)) {
                        onAddContactEventTriggered(
                            AddContactEvents.Error,
                            context, activity,
                            errorMsg = "You already have this contact saved"
                        )
                    } else if (notificationListWithUserInfo.value?.find { it.id == uid } != null) {
                        notificationListWithUserInfo.value?.find { it.id == uid }
                            ?.let { acceptNotificationPressed(it) }
                        onAddContactEventTriggered(
                            AddContactEvents.Success,
                            context, activity
                        )
                    } else {
                        dbRepository.updateNewNotification(uid, UserNotification(myUserId))
                        onAddContactEventTriggered(
                            AddContactEvents.Success,
                            context, activity
                        )
                    }
                }
            }
            else if(result is Result.Error){
                result.msg?.let {
                    onAddContactEventTriggered(
                        AddContactEvents.Error,
                        context, activity,
                        errorMsg = it
                    )
                }
            }
        }
    }

    fun logout(context: Context){
        authRepository.logoutUser()
        ioScope.launch {
            for (contact in chatMeUpDatabase.contactDao.getContacts()){
                chatMeUpDatabase.contactDao.deleteContact(contact)
                File(context.filesDir, contact.localProfilePhotoPath).delete()
            }
            for(chat in chatMeUpDatabase.chatDao.getAllChats()){
                chatMeUpDatabase.chatDao.deleteChat(chat)
                File(context.filesDir, chat.profilePhotoPath).delete()
            }
            for (message in chatMeUpDatabase.messageDao.getAllMessages()){
                chatMeUpDatabase.messageDao.deleteMessage(message)
                message.localThumbnailPath?.let { File(context.filesDir, it).delete() }
                message.localFilePath?.let{ File(context.filesDir, it)}
            }

        }
    }

    data class HomeViewState(
        val myContact: RoomContact = RoomContact(""),
        val chatsList: List<RoomChat> = emptyList()
    )
    sealed class HomeEvents(){
        object ChatListEvent: HomeEvents()
        object ContactListEvent: HomeEvents()
        object MoreEvent: HomeEvents()
    }

    sealed class AddContactEvents(){
        object DoNothing: AddContactEvents()
        object Loading: AddContactEvents()
        object Success: AddContactEvents()
        object Error: AddContactEvents()

    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("myUserId") myUserId: String,
            ): HomeViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            myUserId: String
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return assistedFactory.create(
                    myUserId = myUserId
                ) as T
            }
        }
    }
}