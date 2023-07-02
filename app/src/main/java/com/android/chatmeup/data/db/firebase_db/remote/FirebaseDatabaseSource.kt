package com.android.chatmeup.data.db.firebase_db.remote

import com.android.chatmeup.data.Result
import com.android.chatmeup.data.db.firebase_db.entity.Chat
import com.android.chatmeup.data.db.firebase_db.entity.Message
import com.android.chatmeup.data.db.firebase_db.entity.User
import com.android.chatmeup.data.db.firebase_db.entity.UserFriend
import com.android.chatmeup.data.db.firebase_db.entity.UserNotification
import com.android.chatmeup.data.db.firebase_db.entity.UserRequest
import com.android.chatmeup.util.wrapSnapshotToArrayList
import com.android.chatmeup.util.wrapSnapshotToClass
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.TaskCompletionSource
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirebaseReferenceConnectedObserver {

    private var valueEventListener: ValueEventListener? = null
    private var dbRef: DatabaseReference? = null
    private var userRef: DatabaseReference? = null

    fun start(userID: String) {
        this.userRef = FirebaseDataSource.dbInstance.reference.child("users/$userID/info/online")
        this.valueEventListener = getEventListener(userID)
        this.dbRef = FirebaseDataSource.dbInstance.getReference(".info/connected").apply { addValueEventListener(valueEventListener!!) }
    }

    private fun getEventListener(userID: String): ValueEventListener {
        return (object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val connected = snapshot.getValue(Boolean::class.java) ?: false
                if (connected) {
                    FirebaseDataSource.dbInstance.reference.child("users/$userID/info/online").setValue(true)
                    userRef?.onDisconnect()?.setValue(false)
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    fun clear() {
        valueEventListener?.let { dbRef?.removeEventListener(it) }
        userRef?.setValue(false)
        valueEventListener = null
        dbRef = null
        userRef = null
    }
}

class FirebaseReferenceValueObserver {
    private var valueEventListener: ValueEventListener? = null
    private var dbRef: DatabaseReference? = null
    private var isObserving = false

    fun start(valueEventListener: ValueEventListener, reference: DatabaseReference) {
        isObserving = true
        reference.addValueEventListener(valueEventListener)
        this.valueEventListener = valueEventListener
        this.dbRef = reference
    }

    fun isObserving(): Boolean{
        return isObserving
    }

    fun clear() {
        valueEventListener?.let { dbRef?.removeEventListener(it) }
        valueEventListener = null
        dbRef = null
        isObserving = false
    }
}

class FirebaseReferenceChildObserver {
    private var valueEventListener: ChildEventListener? = null
    private var dbRef: DatabaseReference? = null
    private var isObserving: Boolean = false

    fun start(valueEventListener: ChildEventListener, reference: DatabaseReference) {
        isObserving = true
        reference.addChildEventListener(valueEventListener)
        this.valueEventListener = valueEventListener
        this.dbRef = reference
    }

    fun clear() {
        valueEventListener?.let { dbRef?.removeEventListener(it) }
        isObserving = false
        valueEventListener = null
        dbRef = null
    }

    fun isObserving(): Boolean {
        return isObserving
    }
}

// Task based
class FirebaseDataSource {

    companion object {
        val dbInstance = FirebaseDatabase.getInstance()
    }

    //region Private

    private fun refToPath(path: String): DatabaseReference {
        return dbInstance.reference.child(path)
    }

    private fun attachValueListenerToTaskCompletion(src: TaskCompletionSource<DataSnapshot>): ValueEventListener {
        return (object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) { src.setException(Exception(error.message)) }

            override fun onDataChange(snapshot: DataSnapshot) { src.setResult(snapshot) }
        })
    }

    private fun <T> attachValueListenerToBlock(resultClassName: Class<T>, b: ((Result<T>) -> Unit)): ValueEventListener {
        return (object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) { b.invoke(Result.Error(error.message)) }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (wrapSnapshotToClass(resultClassName, snapshot) == null) {
                    b.invoke(Result.Error(msg = snapshot.key))
                } else {
                    b.invoke(Result.Success(wrapSnapshotToClass(resultClassName, snapshot)))
                }
            }
        })
    }

    private fun <T> attachValueListenerToBlockWithList(resultClassName: Class<T>, b: ((Result<MutableList<T>>) -> Unit)): ValueEventListener {
        return (object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) { b.invoke(Result.Error(error.message)) }
            override fun onDataChange(snapshot: DataSnapshot) {
                b.invoke(Result.Success(wrapSnapshotToArrayList(resultClassName, snapshot)))
            }
        })
    }

    private fun <T> attachChildListenerToBlock(resultClassName: Class<T>, b: ((Result<T>) -> Unit)): ChildEventListener {
        return (object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                b.invoke(Result.Success(wrapSnapshotToClass(resultClassName, snapshot)))
            }

            override fun onCancelled(error: DatabaseError) { b.invoke(Result.Error(error.message)) }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}
        })
    }

    //endregion

    //region Update

    fun updateUserProfileImageUrl(userID: String, url: String) {
        refToPath("users/$userID/info/profileImageUrl").setValue(url)
    }

    fun updateUserStatus(userID: String, status: String): Task<Void> {
        return refToPath("users/$userID/info/status").setValue(status)
    }

    fun updateOnlineStatus(userID: String, status: Boolean){
        refToPath("users/$userID/info/online").setValue(status)
    }

    fun updateFCMToken(userID: String, token: String){
        refToPath("users/$userID/info/fcmToken").setValue(token)
    }

    fun updateDisplayName(userID: String, displayName: String): Task<Void>{
        return refToPath("users/$userID/info/displayName").setValue(displayName)
    }

    fun updateLastMessage(chatID: String, chat: Chat) {
        refToPath("chats/$chatID").setValue(chat)
    }

    fun updateUnreadMessages(chatID: String, value: Int){
        refToPath("chats/$chatID/info/no_of_unread_messages").setValue(value)
    }

    fun updateSeenMessage(chatID: String, messageID: String, value: Boolean){
        refToPath("messages/$chatID/$messageID/seen").setValue(value)
    }

    fun updateNewFriend(myUser: UserFriend, otherUser: UserFriend) {
        refToPath("users/${myUser.userID}/friends/${otherUser.userID}").setValue(otherUser)
        refToPath("users/${otherUser.userID}/friends/${myUser.userID}").setValue(myUser)
    }

    fun updateNewSentRequest(userID: String, userRequest: UserRequest) {
        refToPath("users/${userID}/sentRequests/${userRequest.userID}").setValue(userRequest)
    }

    fun updateNewNotification(otherUserID: String, userNotification: UserNotification) {
        refToPath("users/${otherUserID}/notifications/${userNotification.userID}").setValue(userNotification)
    }

    fun updateNewUser(user: User) {
        refToPath("users/${user.info.id}").setValue(user)
    }

    fun updateNewChat(chat: Chat) {
        refToPath("chats/${chat.info.id}").setValue(chat)
    }

    fun pushNewMessage(userID: String, chatID: String, message: Message) {
        refToPath("messages/$chatID/${message.messageID}").setValue(message)
        refToPath("users/${userID}/newMessages/${message.messageID}").setValue(message)
    }

    fun pushNewContact(otherUserID: String, myUserID: String) {
        refToPath("users/${otherUserID}/newContacts/${myUserID}").setValue(UserFriend(myUserID))
    }

    fun removeContact(otherUserID: String, myUserID: String) {
        refToPath("users/${otherUserID}/removeContacts/${myUserID}").setValue(UserFriend(myUserID))
    }
    //endregion

    //region Remove
    fun removeNotification(userID: String, notificationID: String) {
        refToPath("users/${userID}/notifications/$notificationID").setValue(null)
    }

    fun removeFriend(userID: String, friendID: String) {
        refToPath("users/${userID}/friends/$friendID").setValue(null)
        refToPath("users/${friendID}/friends/$userID").setValue(null)
    }

    fun removeSentRequest(userID: String, sentRequestID: String) {
        refToPath("users/${userID}/sentRequests/$sentRequestID").setValue(null)
    }

    fun removeChat(chatID: String) {
        refToPath("chats/$chatID").setValue(null)
    }

    fun removeMessages(messagesID: String) {
        refToPath("messages/$messagesID").setValue(null)
    }

    fun removeMessage(otherUserID: String, chatID: String, messageID: String) {
        refToPath("messages/$chatID/$messageID").setValue(null)
        refToPath("users/$otherUserID/removeMessages/$messageID").setValue(Message(messageID = messageID))
    }

    fun removeNewMessages(userID: String, messageID: String) {
        refToPath("users/$userID/newMessages/$messageID").setValue(null)
    }

    fun updateRemovedMessages(userID: String, messageID: String) {
        refToPath("users/$userID/removeMessages/$messageID").setValue(null)
    }

    fun updateNewContacts(userID: String, otherUserID: String){
        refToPath("users/$userID/newContacts/$otherUserID").setValue(null)
    }

    fun updateRemovedContacts(userID: String, otherUserID: String){
        refToPath("users/$userID/removedContacts/$otherUserID").setValue(null)
    }

    //endregion

    //region Load
    fun loadUserTask(userID: String): Task<DataSnapshot> {
        val src = TaskCompletionSource<DataSnapshot>()
        val listener = attachValueListenerToTaskCompletion(src)
        refToPath("users/$userID").addListenerForSingleValueEvent(listener)
        return src.task
    }

    fun loadUserInfoTask(userID: String): Task<DataSnapshot> {
        val src = TaskCompletionSource<DataSnapshot>()
        val listener = attachValueListenerToTaskCompletion(src)
        refToPath("users/$userID/info").addListenerForSingleValueEvent(listener)
        return src.task
    }

    fun loadChatInfoTask(chatID: String): Task<DataSnapshot> {
        val src = TaskCompletionSource<DataSnapshot>()
        val listener = attachValueListenerToTaskCompletion(src)
        refToPath("chats/$chatID/info").addListenerForSingleValueEvent(listener)
        return src.task
    }

    fun loadUsersTask(): Task<DataSnapshot> {
        val src = TaskCompletionSource<DataSnapshot>()
        val listener = attachValueListenerToTaskCompletion(src)
        refToPath("users").addListenerForSingleValueEvent(listener)
        return src.task
    }

    fun loadFriendsTask(userID: String): Task<DataSnapshot> {
        val src = TaskCompletionSource<DataSnapshot>()
        val listener = attachValueListenerToTaskCompletion(src)
        refToPath("users/$userID/friends").addListenerForSingleValueEvent(listener)
        return src.task
    }

    fun loadMessagesTask(chatID: String): Task<DataSnapshot> {
        val src = TaskCompletionSource<DataSnapshot>()
        val listener = attachValueListenerToTaskCompletion(src)
        refToPath("messages/$chatID").addListenerForSingleValueEvent(listener)
        return src.task
    }

    fun loadMessageTask(chatID: String, messageID: String): Task<DataSnapshot> {
        val src = TaskCompletionSource<DataSnapshot>()
        val listener = attachValueListenerToTaskCompletion(src)
        refToPath("messages/$chatID/$messageID").addListenerForSingleValueEvent(listener)
        return src.task
    }

    fun loadChatTask(chatID: String): Task<DataSnapshot> {
        val src = TaskCompletionSource<DataSnapshot>()
        val listener = attachValueListenerToTaskCompletion(src)
        refToPath("chats/$chatID").addListenerForSingleValueEvent(listener)
        return src.task
    }

    fun loadNotificationsTask(userID: String): Task<DataSnapshot> {
        val src = TaskCompletionSource<DataSnapshot>()
        val listener = attachValueListenerToTaskCompletion(src)
        refToPath("users/$userID/notifications").addListenerForSingleValueEvent(listener)
        return src.task
    }
    //endregion

    //region Value Observers

    fun <T> attachUserObserver(resultClassName: Class<T>, userID: String, refObs: FirebaseReferenceValueObserver, b: ((Result<T>) -> Unit)) {
        val listener = attachValueListenerToBlock(resultClassName, b)
        refObs.start(listener, refToPath("users/$userID"))
    }

    fun <T> attachUserInfoObserver(resultClassName: Class<T>, userID: String, refObs: FirebaseReferenceValueObserver, b: ((Result<T>) -> Unit)) {
        val listener = attachValueListenerToBlock(resultClassName, b)
        refObs.start(listener, refToPath("users/$userID/info"))
    }

    fun <T> attachUserFriendsObserver(resultClassName: Class<T>, userID: String, firebaseReferenceValueObserver: FirebaseReferenceValueObserver,
                                      b: ((Result<MutableList<T>>) -> Unit)
    ) {
        val listener = attachValueListenerToBlockWithList(resultClassName, b)
        firebaseReferenceValueObserver.start(listener, refToPath("users/$userID/friends"))
    }

    fun <T> attachUserNotificationsObserver(resultClassName: Class<T>, userID: String, firebaseReferenceValueObserver: FirebaseReferenceValueObserver,
                                            b: ((Result<MutableList<T>>) -> Unit)
    ) {
        val listener = attachValueListenerToBlockWithList(resultClassName, b)
        firebaseReferenceValueObserver.start(listener, refToPath("users/$userID/notifications"))
    }

    fun <T> attachMessagesObserver(resultClassName: Class<T>, messagesID: String, refObs: FirebaseReferenceChildObserver, b: ((Result<T>) -> Unit)) {
        val listener = attachChildListenerToBlock(resultClassName, b)
        refObs.start(listener, refToPath("messages/$messagesID"))
    }

    fun <T> attachNewMessagesObserver(resultClassName: Class<T>, userID: String, refObs: FirebaseReferenceChildObserver, b: ((Result<T>) -> Unit)) {
        val listener = attachChildListenerToBlock(resultClassName, b)
        refObs.start(listener, refToPath("users/$userID/newMessages"))
    }

    fun <T> attachNewContactsObserver(resultClassName: Class<T>, userID: String, refObs: FirebaseReferenceChildObserver, b: ((Result<T>) -> Unit)) {
        val listener = attachChildListenerToBlock(resultClassName, b)
        refObs.start(listener, refToPath("users/$userID/newContacts"))
    }

    fun <T> attachRemoveContactsObserver(resultClassName: Class<T>, userID: String, refObs: FirebaseReferenceChildObserver, b: ((Result<T>) -> Unit)) {
        val listener = attachChildListenerToBlock(resultClassName, b)
        refObs.start(listener, refToPath("users/$userID/removeContacts"))
    }

    fun <T> attachRemovedMessagesObserver(resultClassName: Class<T>, userID: String, refObs: FirebaseReferenceChildObserver, b: ((Result<T>) -> Unit)) {
        val listener = attachChildListenerToBlock(resultClassName, b)
        refObs.start(listener, refToPath("users/$userID/removeMessages"))
    }

    fun <T> attachChatObserver(resultClassName: Class<T>, chatID: String, refObs: FirebaseReferenceValueObserver, b: ((Result<T>) -> Unit)) {
        val listener = attachValueListenerToBlock(resultClassName, b)
        refObs.start(listener, refToPath("chats/$chatID"))
    }

    fun <T> attachChatInfoObserver(resultClassName: Class<T>, chatID: String, refObs: FirebaseReferenceValueObserver, b: ((Result<T>) -> Unit)) {
        val listener = attachValueListenerToBlock(resultClassName, b)
        refObs.start(listener, refToPath("chats/$chatID/info"))
    }

    //endregion
}
