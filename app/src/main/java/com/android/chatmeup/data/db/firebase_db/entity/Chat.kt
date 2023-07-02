package com.android.chatmeup.data.db.firebase_db.entity

import com.google.firebase.database.PropertyName


data class Chat(
    @get:PropertyName("lastMessage") @set:PropertyName("lastMessage") var lastMessage: Message = Message(),
    @get:PropertyName("info") @set:PropertyName("info") var info: ChatInfo = ChatInfo()
)

data class ChatInfo(
    @get:PropertyName("id") @set:PropertyName("id") var id: String = "",
    @get:PropertyName("no_of_unread_messages") @set:PropertyName("no_of_unread_messages") var no_of_unread_messages: Int = 0,
)