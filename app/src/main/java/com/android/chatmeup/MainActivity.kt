package com.android.chatmeup

import android.os.Build
import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.compose.rememberNavController
import com.android.chatmeup.data.Result
import com.android.chatmeup.data.datastore.CmuDataStoreRepository
import com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceChildObserver
import com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver
import com.android.chatmeup.data.db.firebase_db.repository.DatabaseRepository
import com.android.chatmeup.data.db.firebase_db.repository.StorageRepository
import com.android.chatmeup.data.db.room_db.ChatMeUpDatabase
import com.android.chatmeup.data.db.room_db.data.MessageType
import com.android.chatmeup.ui.CmuApp
import com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel
import com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel
import com.android.chatmeup.ui.theme.ChatMeUpTheme
import com.android.chatmeup.ui.theme.md_theme_dark_background
import com.android.chatmeup.ui.theme.md_theme_light_background
import com.android.chatmeup.util.firebaseMessageToRoomMessage
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.LinkedList
import java.util.Queue
import javax.inject.Inject
import kotlin.text.Typography.dagger

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val tag = MainActivity::class.java.simpleName
    private lateinit var chatMeUpApp: CmuApplication
    private val dbRepository = DatabaseRepository()
    private val storageRepository = StorageRepository()
    private val newMessagesFbReferenceChildObserver = FirebaseReferenceChildObserver()
    private val newFriendsFbReferenceChildObserver = FirebaseReferenceChildObserver()
    private val removeFriendsFbReferenceChildObserver = FirebaseReferenceChildObserver()
    private val removeMessagesFbReferenceChildObserver = FirebaseReferenceChildObserver()
    private var friendsUserInfoReferenceValueObserverList: MutableList<FirebaseReferenceValueObserver> = mutableListOf()
    private val ioScope = CoroutineScope(Dispatchers.IO + Job())
    private val taskList: Queue<Triple<Any, Boolean, String>> = LinkedList()

    @Inject
    lateinit var cmuDataStoreRepository: CmuDataStoreRepository

    @Inject
    lateinit var chatMeUpDatabase: ChatMeUpDatabase

    @Inject
    lateinit var appTaskManager: AppTaskManager

    @EntryPoint
    @InstallIn(ActivityComponent::class)
    interface ViewModelFactoryProvider {
        fun homeViewModelFactory(): HomeViewModel.Factory
        fun chatViewModelFactory(): ChatViewModel.Factory
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                appTaskManager.taskInProgress
            }
        }
        chatMeUpApp = applicationContext as CmuApplication

        Firebase.auth.currentUser?.let {  dbRepository.updateOnlineStatus(it.uid, true)}
        if(!newMessagesFbReferenceChildObserver.isObserving())loadAndObserveAllNewMessages(newMessagesFbReferenceChildObserver)
        loadAndObserveFriendsUserInfo()

        setContent {
            val systemUiController = rememberSystemUiController()
            //change status bar color anytime we change light mode or dark mode
            val isDarkTheme = isSystemInDarkTheme()
            LaunchedEffect(isSystemInDarkTheme()) {
                systemUiController.setStatusBarColor(
                    color = if(isDarkTheme) md_theme_dark_background else md_theme_light_background,
                    darkIcons = !isDarkTheme
                )
            }
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { view, insets ->
                val bottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
                view.updatePadding(bottom = bottom)
                insets
            }
            val navController = rememberNavController()
            ChatMeUpTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    CmuApp(
                        chatMeUpApp = chatMeUpApp,
                        startObserving = {
                            if(!newMessagesFbReferenceChildObserver.isObserving())loadAndObserveAllNewMessages(newMessagesFbReferenceChildObserver)
                            if(!newFriendsFbReferenceChildObserver.isObserving())loadAndObserveAllNewContacts(newFriendsFbReferenceChildObserver)
                            if(!removeFriendsFbReferenceChildObserver.isObserving())loadAndObserveContactsRemoved(removeFriendsFbReferenceChildObserver)
                            if(!removeMessagesFbReferenceChildObserver.isObserving())loadAndObserveMessagesRemoved(removeMessagesFbReferenceChildObserver)
                        },
                        stopObserving = {
                            newMessagesFbReferenceChildObserver.clear()
                            newFriendsFbReferenceChildObserver.clear()
                            removeFriendsFbReferenceChildObserver.clear()
                            friendsUserInfoReferenceValueObserverList.forEach{it.clear()}
                            friendsUserInfoReferenceValueObserverList.removeIf { true }
                        }
                    )
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        chatMeUpApp.setCurrentActivity(this)
        Firebase.auth.currentUser?.let {  dbRepository.updateOnlineStatus(it.uid, true)}
    }
    override fun onPause() {
        super.onPause()
        chatMeUpApp.setCurrentActivity(this)
        Firebase.auth.currentUser?.let {  dbRepository.updateOnlineStatus(it.uid, false)}
    }

//    override fun onStart() {
//        super.onStart()
//        fbReferenceChildObserver.start()
//    }
//    override fun onStop() {
//        super.onStop()
//        fbReferenceChildObserver.clear()
//    }

    private fun loadAndObserveAllNewMessages(observer: FirebaseReferenceChildObserver){
        val ioScope = CoroutineScope(Dispatchers.IO + Job())
        Firebase.auth.uid?.let{myUserId ->
            try{
                dbRepository.loadAndObserveNewMessagesAdded(
                    myUserId,
                    observer
                ) { result ->
                    when (result) {
                        is Result.Error -> {
                            Timber.tag(tag).e("Error loading Message")
                        }

                        Result.Loading -> {}
                        is Result.Progress -> {}
                        is Result.Success -> {
                            result.data?.let {
                                //Update room
                                val message = firebaseMessageToRoomMessage(it)
                                ioScope.launch {
                                    //update message table
                                    chatMeUpDatabase.messageDao.upsertMessage(message)
                                    //update chat LastMessage
                                    if (chatMeUpDatabase.chatDao.chatExists(message.chatID)) {
                                        val chat =
                                            chatMeUpDatabase.chatDao.getChat(message.chatID).apply {
                                                no_of_unread_messages += 1
                                                lastMessageText = message.messageText
                                                lastMessageTime = message.messageTime
                                                messageType = enumValueOf(message.messageType)
                                                lastMessageSenderID = message.senderID
                                            }
                                        chatMeUpDatabase.chatDao.upsertChat(chat)
                                    }
                                }
                                //Delete from Firebase
                                dbRepository.removeNewMessages(myUserId, it.messageID)

                                //download Thumbnail
                                if (message.messageType == MessageType.TEXT_IMAGE.toString()) {
                                    val localFilePath =
                                        "${message.chatID}/${message.messageID}_thumbnail.png"
                                    message.serverThumbnailPath?.let { it1 ->
                                        storageRepository.downloadChatThumbnail(
                                            this.applicationContext,
                                            it1,
                                            localFilePath
                                        ) { thumbnailResult ->
                                            when (thumbnailResult) {
                                                is Result.Error -> {}
                                                Result.Loading -> {}
                                                is Result.Progress -> {}
                                                is Result.Success -> {
                                                    ioScope.launch {
                                                        val message1 =
                                                            chatMeUpDatabase.messageDao.getMessage(
                                                                message.messageID
                                                            )
                                                                .apply {
                                                                    this.localThumbnailPath =
                                                                        localFilePath
                                                                }
                                                        chatMeUpDatabase.messageDao.upsertMessage(
                                                            message1
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }catch(e:Exception){
                Timber.tag(tag).e("Error $e")
            }
        }
    }

    private fun loadAndObserveContactsRemoved(observer: FirebaseReferenceChildObserver){
        Firebase.auth.uid?.let{myUserId ->
            try{
                dbRepository.loadAndObserveContactsRemoved(
                    myUserId,
                    observer
                ) { result ->
                    when (result) {
                        is Result.Error -> {
                            Timber.tag(tag).e("Error loading Message")
                        }

                        Result.Loading -> {}
                        is Result.Progress -> {}
                        is Result.Success -> {
                            result.data?.let {
                                appTaskManager.addTaskToQueue(
                                    AppTaskManager.Task.DeleteContactUsingUserID(it.userID)
                                )
                                appTaskManager.addTaskToQueue(
                                    AppTaskManager.Task.DeleteChatUsingUserID(it.userID)
                                )
                                dbRepository.updateRemovedContacts(myUserId, it.userID)
                            }
                        }
                    }
                }
            }catch(e:Exception){
                Timber.tag(tag).e("Error $e")
            }
        }
    }

    private fun loadAndObserveMessagesRemoved(observer: FirebaseReferenceChildObserver){
        Firebase.auth.uid?.let{myUserId ->
            try{
                dbRepository.loadAndObserveMessagesRemoved(
                    myUserId,
                    observer
                ) { result ->
                    when (result) {
                        is Result.Error -> {
                            Timber.tag(tag).e("Error loading Message")
                        }

                        Result.Loading -> {}
                        is Result.Progress -> {}
                        is Result.Success -> {
                            result.data?.let {
                                appTaskManager.addTaskToQueue(
                                    AppTaskManager.Task.DeleteMessageFromRoomDB(it.messageID)
                                )
                                dbRepository.updateRemovedMessages(myUserId, it.messageID)
                            }
                        }
                    }
                }
            }catch(e:Exception){
                Timber.tag(tag).e("Error $e")
            }
        }
    }

    private fun loadAndObserveAllNewContacts(observer: FirebaseReferenceChildObserver){
        Firebase.auth.uid?.let{myUserId ->
            try{
                dbRepository.loadAndObserveNewContactsAdded(
                    myUserId,
                    observer
                ) { result ->
                    when (result) {
                        is Result.Error -> {
                            Timber.tag(tag).e("Error loading Message")
                        }

                        Result.Loading -> {}
                        is Result.Progress -> {}
                        is Result.Success -> {
                            result.data?.let {
                                appTaskManager.addTaskToQueue(
                                    AppTaskManager.Task.CreateNewContactFromUserID(this, it.userID)
                                )
                                appTaskManager.addTaskToQueue(
                                    AppTaskManager.Task.CreateNewChatFromUserID(this, it.userID)
                                )
                                dbRepository.updateNewContacts(myUserId, it.userID)
                            }
                        }
                    }
                }
            }catch(e:Exception){
                Timber.tag(tag).e("Error $e")
            }
        }
    }

    private fun loadAndObserveFriendsUserInfo(){
        ioScope.launch{
            friendsUserInfoReferenceValueObserverList = mutableListOf()
            val contacts = chatMeUpDatabase.contactDao.getContacts()
            try{
                for (contact in contacts) {
                    val observer = FirebaseReferenceValueObserver()
                    friendsUserInfoReferenceValueObserverList.add(observer)
                    dbRepository.loadAndObserveUserInfo(contact.userID, observer) { result ->
                        when (result) {
                            is Result.Error -> {}
                            Result.Loading -> {}
                            is Result.Progress -> {}
                            is Result.Success -> {
                                result.data?.let {
                                    appTaskManager.addTaskToQueue(
                                        AppTaskManager.Task.UpdateContactUsingUserInfo(
                                            this@MainActivity,
                                            it
                                        )
                                    )
                                }
                            }
                        }
                    }
                }
            }catch (e: Exception){
                Timber.tag(tag).e("Error $e")
            }
        }
    }
}
