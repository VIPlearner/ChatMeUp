package com.android.chatmeup.util

import com.android.chatmeup.data.db.firebase_db.entity.Message
import com.android.chatmeup.data.db.room_db.data.MessageStatus

fun firebaseMessageToRoomMessage(message: Message): com.android.chatmeup.data.db.room_db.entity.RoomMessage{
    val chatID = convertTwoUserIDs(message.senderID, message.receiverID)
    return com.android.chatmeup.data.db.room_db.entity.RoomMessage(
        chatID = convertTwoUserIDs(message.senderID, message.receiverID),
        messageStatus = MessageStatus.DELIVERED,
        messageID = message.messageID,
        messageTime = message.epochTimeMs,
        messageText = message.text,
        senderID = message.senderID,
        serverFilePath = message.imageUrl,
        messageType = message.messageType,
        timeStamp = message.messageID,
        serverThumbnailPath = message.thumbnailUrl,
    )
}