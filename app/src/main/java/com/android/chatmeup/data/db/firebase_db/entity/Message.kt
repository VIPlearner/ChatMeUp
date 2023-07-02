package com.android.chatmeup.data.db.firebase_db.entity

import com.google.firebase.database.PropertyName
import java.util.*


data class Message(
    @get:PropertyName("senderID") @set:PropertyName("senderID") var senderID: String = "",
    @get:PropertyName("receiverID") @set:PropertyName("receiverID") var receiverID: String = "",
    @get:PropertyName("imageUrl") @set:PropertyName("imageUrl") var imageUrl: String = "",
    @get:PropertyName("messageType") @set:PropertyName("messageType") var messageType: String = "TEXT",
    @get:PropertyName("thumbnailUrl") @set:PropertyName("thumbnailUrl") var thumbnailUrl: String = "",
    @get:PropertyName("text") @set:PropertyName("text") var text: String = "",
    @get:PropertyName("epochTimeMs") @set:PropertyName("epochTimeMs") var epochTimeMs: Long = Date().time,
    @get:PropertyName("seen") @set:PropertyName("seen") var seen: Boolean = false,
    @get:PropertyName("messageID") @set:PropertyName("messageID") var messageID: String = ""
)