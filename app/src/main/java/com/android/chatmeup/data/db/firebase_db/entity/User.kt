package com.android.chatmeup.data.db.firebase_db.entity

import com.google.firebase.database.PropertyName


data class User(
    @get:PropertyName("info") @set:PropertyName("info") var info: UserInfo = UserInfo(),
    @get:PropertyName("friends") @set:PropertyName("friends") var friends: HashMap<String, UserFriend> = HashMap(),
    @get:PropertyName("notifications") @set:PropertyName("notifications") var notifications: HashMap<String, UserNotification> = HashMap(),
    @get:PropertyName("sentRequests") @set:PropertyName("sentRequests") var sentRequests: HashMap<String, UserRequest> = HashMap(),
    @get:PropertyName("newMessages") @set:PropertyName("newMessages") var newMessages: HashMap<String, Message> = HashMap(),
    @get:PropertyName("newContacts") @set:PropertyName("newContacts") var newContacts: HashMap<String, UserFriend> = HashMap(),
    @get:PropertyName("removedContacts") @set:PropertyName("removedContacts") var removedContacts: HashMap<String, UserFriend> = HashMap(),
    @get:PropertyName("removedMessages") @set:PropertyName("removedMessages") var removedMessages: HashMap<String, Message> = HashMap(),
    )

data class UserFriend(
    @get:PropertyName("userID") @set:PropertyName("userID") var userID: String = ""
)

data class UserInfo(
    @get:PropertyName("id") @set:PropertyName("id") var id: String = "",
    @get:PropertyName("email") @set:PropertyName("email") var email: String = "",
    @get:PropertyName("displayName") @set:PropertyName("displayName") var displayName: String = "",
    @get:PropertyName("fcmToken") @set:PropertyName("fcmToken") var fcmToken: String = "",
    @get:PropertyName("aboutStr") @set:PropertyName("aboutStr") var aboutStr: String = "No status",
    @get:PropertyName("profileImageUrl") @set:PropertyName("profileImageUrl") var profileImageUrl: String = "",
    @get:PropertyName("online") @set:PropertyName("online") var online: Boolean = false
)

data class UserNotification(
    @get:PropertyName("userID") @set:PropertyName("userID") var userID: String = ""
)

data class UserRequest(
    @get:PropertyName("userID") @set:PropertyName("userID") var userID: String = ""
)

