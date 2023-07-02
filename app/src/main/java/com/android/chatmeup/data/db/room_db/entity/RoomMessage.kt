package com.android.chatmeup.data.db.room_db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.android.chatmeup.data.db.room_db.data.MessageStatus
import com.android.chatmeup.data.db.room_db.data.MessageStatusEnumConverter


@Entity
@TypeConverters(MessageStatusEnumConverter::class)
data class RoomMessage(
    @PrimaryKey
    val messageID: String, //chatId + messageId
    val timeStamp: String,
    val messageText: String,
    val messageTime: Long,
    val messageType: String,
    val senderID: String,
    var localThumbnailPath: String? = null,
    val serverThumbnailPath: String? = null,
    var localFilePath: String? = null,
    var serverFilePath: String? = null,
    val messageStatus: MessageStatus,
    val chatID: String,
)