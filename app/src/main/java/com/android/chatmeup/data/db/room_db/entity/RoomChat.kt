package com.android.chatmeup.data.db.room_db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.android.chatmeup.data.db.room_db.data.MessageType
import com.android.chatmeup.data.db.room_db.data.MessageTypeEnumConverter

@Entity
@TypeConverters(MessageTypeEnumConverter::class)
data class RoomChat(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    var no_of_unread_messages: Int = 0,
    var displayName: String = "",
    var lastMessageText: String = "",
    var lastMessageTime: Long = 0,
    var messageType: MessageType = MessageType.TEXT,
    var lastMessageSenderID: String = "",
    val otherUserId: String = "",
    var profilePhotoPath: String = "",
    val onlineProfilePhotoPath: String = "",
)
