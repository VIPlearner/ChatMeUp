package com.android.chatmeup.data.db.firebase_db.repository

import com.android.chatmeup.data.Result
import com.android.chatmeup.data.db.firebase_db.entity.Chat
import com.android.chatmeup.data.db.firebase_db.entity.ChatInfo
import com.android.chatmeup.data.db.firebase_db.entity.Message
import com.android.chatmeup.data.db.firebase_db.entity.User
import com.android.chatmeup.data.db.firebase_db.entity.UserFriend
import com.android.chatmeup.data.db.firebase_db.entity.UserInfo
import com.android.chatmeup.data.db.firebase_db.entity.UserNotification
import com.android.chatmeup.data.db.firebase_db.entity.UserRequest
import com.android.chatmeup.data.db.firebase_db.remote.FirebaseDataSource
import com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceChildObserver
import com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver
import com.android.chatmeup.util.wrapSnapshotToArrayList
import com.android.chatmeup.util.wrapSnapshotToClass


class DatabaseRepository {
    private val firebaseDatabaseService = FirebaseDataSource()

    //region Update
    fun updateUserStatus(userID: String, status: String) {
        firebaseDatabaseService.updateUserStatus(userID, status)
    }

    fun updateOnlineStatus(userID: String, status: Boolean){
        firebaseDatabaseService.updateOnlineStatus(userID, status)
    }


    fun updateFCMToken(userID: String, token: String){
        firebaseDatabaseService.updateFCMToken(userID, token)
    }

    fun updateDisplayName(userID: String, displayName: String){
        firebaseDatabaseService.updateDisplayName(userID, displayName)
    }

    fun updateNewMessage(userID: String, chatID: String, message: Message) {
        firebaseDatabaseService.pushNewMessage(userID, chatID, message)
    }

    fun pushNewContact(otherUserID: String, myUserID: String) {
        firebaseDatabaseService.pushNewContact(otherUserID, myUserID)
    }

    fun removeContact(otherUserID: String, myUserID: String) {
        firebaseDatabaseService.removeContact(otherUserID, myUserID)
    }

    fun updateNewUser(user: User) {
        firebaseDatabaseService.updateNewUser(user)
    }

    fun updateNewFriend(myUser: UserFriend, otherUser: UserFriend) {
        firebaseDatabaseService.updateNewFriend(myUser, otherUser)
    }

    fun updateNewSentRequest(userID: String, userRequest: UserRequest) {
        firebaseDatabaseService.updateNewSentRequest(userID, userRequest)
    }

    fun updateNewNotification(otherUserID: String, userNotification: UserNotification) {
        firebaseDatabaseService.updateNewNotification(otherUserID, userNotification)
    }

    fun updateChatLastMessage(chatID: String, chat: Chat) {
        firebaseDatabaseService.updateLastMessage(chatID, chat)
    }

    fun updateUnreadMessages(chatID: String, value: Int){
        firebaseDatabaseService.updateUnreadMessages(chatID, value)
    }

    fun updateSeenMessage(chatID: String, messageID: String, value: Boolean){
        firebaseDatabaseService.updateSeenMessage(chatID, messageID, value)
    }

    fun updateNewChat(chat: Chat){
        firebaseDatabaseService.updateNewChat(chat)
    }

    fun updateUserProfileImageUrl(userID: String, url: String){
        firebaseDatabaseService.updateUserProfileImageUrl(userID, url)
    }

    //endregion

    //region Remove
    fun removeNotification(userID: String, notificationID: String) {
        firebaseDatabaseService.removeNotification(userID, notificationID)
    }

    fun removeFriend(userID: String, friendID: String) {
        firebaseDatabaseService.removeFriend(userID, friendID)
    }

    fun removeSentRequest(otherUserID: String, myUserID: String) {
        firebaseDatabaseService.removeSentRequest(otherUserID, myUserID)
    }

    fun removeChat(chatID: String) {
        firebaseDatabaseService.removeChat(chatID)
    }

    fun removeMessages(messagesID: String){
        firebaseDatabaseService.removeMessages(messagesID)
    }

    fun removeMessage(otherUserID: String, chatID: String, messageID: String){
        firebaseDatabaseService.removeMessage(otherUserID, chatID, messageID)
    }

    fun removeNewMessages(userID: String, messageID: String){
        firebaseDatabaseService.removeNewMessages(userID, messageID)
    }

    fun updateNewContacts(userID: String, otherUserID: String){
        firebaseDatabaseService.updateNewContacts(userID, otherUserID)
    }

    fun updateRemovedContacts(userID: String, otherUserID: String){
        firebaseDatabaseService.updateRemovedContacts(userID, otherUserID)
    }

    fun updateRemovedMessages(userID: String, messageID: String){
        firebaseDatabaseService.updateRemovedMessages(userID, messageID)
    }

    //endregion

    //region Load Single

    fun loadUser(userID: String, b: ((Result<User>) -> Unit)) {
        firebaseDatabaseService.loadUserTask(userID).addOnSuccessListener {
            b.invoke(Result.Success(wrapSnapshotToClass(User::class.java, it)))
        }.addOnFailureListener { b.invoke(Result.Error(it.message)) }
    }

    fun loadUserInfo(userID: String, b: ((Result<UserInfo>) -> Unit)) {
        firebaseDatabaseService.loadUserInfoTask(userID).addOnSuccessListener {
            b.invoke(Result.Success(wrapSnapshotToClass(UserInfo::class.java, it)))
        }.addOnFailureListener { b.invoke(Result.Error(it.message)) }
    }

    fun loadChat(chatID: String, b: ((Result<Chat>) -> Unit)) {
        firebaseDatabaseService.loadChatTask(chatID).addOnSuccessListener {
            b.invoke(Result.Success(wrapSnapshotToClass(Chat::class.java, it)))
        }.addOnFailureListener { b.invoke(Result.Error(it.message)) }
    }

    fun loadMessage(chatID: String, messageID: String, b: ((Result<Message>) -> Unit)){
        firebaseDatabaseService.loadMessageTask(chatID, messageID).addOnSuccessListener{
            b.invoke(Result.Success(wrapSnapshotToClass(Message::class.java, it)))
        }.addOnFailureListener { b.invoke(Result.Error(it.message)) }
    }


    fun loadChatInfo(chatID: String, b:((Result<ChatInfo>) -> Unit)){
        firebaseDatabaseService.loadChatInfoTask(chatID).addOnSuccessListener {
            b.invoke(Result.Success(wrapSnapshotToClass(ChatInfo::class.java, it)))
        }.addOnFailureListener { b.invoke(Result.Error(it.message)) }
    }

    //endregion

    //region Load List

    fun loadUsers(b: ((Result<MutableList<User>>) -> Unit)) {
        b.invoke(Result.Loading)
        firebaseDatabaseService.loadUsersTask().addOnSuccessListener {
            val usersList = wrapSnapshotToArrayList(User::class.java, it)
            b.invoke(Result.Success(usersList))
        }.addOnFailureListener { b.invoke(Result.Error(it.message)) }
    }

    fun loadFriends(userID: String, b: ((Result<List<UserFriend>>) -> Unit)) {
        b.invoke(Result.Loading)
        firebaseDatabaseService.loadFriendsTask(userID).addOnSuccessListener {
            val friendsList = wrapSnapshotToArrayList(UserFriend::class.java, it)
            b.invoke(Result.Success(friendsList))
        }.addOnFailureListener { b.invoke(Result.Error(it.message)) }
    }

    fun loadMessages(chatID: String, b: ((Result<List<Message>>) -> Unit)){
        b.invoke(Result.Loading)
        firebaseDatabaseService.loadMessagesTask(chatID).addOnSuccessListener {
            val messagesList = wrapSnapshotToArrayList(Message::class.java, it)
            b.invoke(Result.Success(messagesList))
        }.addOnFailureListener { b.invoke(Result.Error(it.message)) }
    }

    fun loadNotifications(userID: String, b: ((Result<MutableList<UserNotification>>) -> Unit)) {
        b.invoke(Result.Loading)
        firebaseDatabaseService.loadNotificationsTask(userID).addOnSuccessListener {
            val notificationsList = wrapSnapshotToArrayList(UserNotification::class.java, it)
            b.invoke(Result.Success(notificationsList))
        }.addOnFailureListener { b.invoke(Result.Error(it.message)) }
    }

    fun loadNewMessages(userID: String, b: ((Result<MutableList<Message>>) -> Unit)) {
        b.invoke(Result.Loading)
        firebaseDatabaseService.loadNotificationsTask(userID).addOnSuccessListener {
            val newMessagesList = wrapSnapshotToArrayList(Message::class.java, it)
            b.invoke(Result.Success(newMessagesList))
        }.addOnFailureListener { b.invoke(Result.Error(it.message)) }
    }



    //endregion

    //#region Load and Observe

    fun loadAndObserveUser(userID: String, observer: FirebaseReferenceValueObserver, b: ((Result<User>) -> Unit)) {
        firebaseDatabaseService.attachUserObserver(User::class.java, userID, observer, b)
    }

    fun loadAndObserveFriends(userID: String, observer: FirebaseReferenceValueObserver, b: ((Result<MutableList<UserFriend>>) -> Unit)){
        firebaseDatabaseService.attachUserFriendsObserver(UserFriend::class.java, userID, observer, b)
    }

    fun loadAndObserveUserInfo(userID: String, observer: FirebaseReferenceValueObserver, b: ((Result<UserInfo>) -> Unit)) {
        firebaseDatabaseService.attachUserInfoObserver(UserInfo::class.java, userID, observer, b)
    }

    fun loadAndObserveUserNotifications(userID: String, observer: FirebaseReferenceValueObserver, b: ((Result<MutableList<UserNotification>>) -> Unit)){
        firebaseDatabaseService.attachUserNotificationsObserver(UserNotification::class.java, userID, observer, b)
    }

    fun loadAndObserveMessagesAdded(messagesID: String, observer: FirebaseReferenceChildObserver, b: ((Result<Message>) -> Unit)) {
        firebaseDatabaseService.attachMessagesObserver(Message::class.java, messagesID, observer, b)
    }

    fun loadAndObserveNewMessagesAdded(userID: String, observer: FirebaseReferenceChildObserver, b: ((Result<Message>) -> Unit)) {
        firebaseDatabaseService.attachNewMessagesObserver(Message::class.java, userID, observer, b)
    }

    fun loadAndObserveNewContactsAdded(userID: String, observer: FirebaseReferenceChildObserver, b: ((Result<UserFriend>) -> Unit)) {
        firebaseDatabaseService.attachNewContactsObserver(UserFriend::class.java, userID, observer, b)
    }

    fun loadAndObserveContactsRemoved(userID: String, observer: FirebaseReferenceChildObserver, b: ((Result<UserFriend>) -> Unit)) {
        firebaseDatabaseService.attachRemoveContactsObserver(UserFriend::class.java, userID, observer, b)
    }

    fun loadAndObserveMessagesRemoved(userID: String, observer: FirebaseReferenceChildObserver, b: ((Result<Message>) -> Unit)) {
        firebaseDatabaseService.attachRemovedMessagesObserver(Message::class.java, userID, observer, b)
    }

    fun loadAndObserveChat(chatID: String, observer: FirebaseReferenceValueObserver, b: ((Result<Chat>) -> Unit)) {
        firebaseDatabaseService.attachChatObserver(Chat::class.java, chatID, observer, b)
    }

    fun loadAndObserveChatInfo(chatID: String, observer: FirebaseReferenceValueObserver, b: ((Result<ChatInfo>) -> Unit)) {
        firebaseDatabaseService.attachChatInfoObserver(ChatInfo::class.java, chatID, observer, b)
    }

    //endregion
}

