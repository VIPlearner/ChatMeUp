package com.android.chatmeup.data.db.room_db.data

import androidx.room.TypeConverter

enum class MessageStatus {
    UNSENT,
    SENT,
    DELIVERED,
    READ
}

class MessageStatusEnumConverter {
    @TypeConverter
    fun fromEnum(value: MessageStatus): String {
        return value.name
    }

    @TypeConverter
    fun toEnum(value: String): MessageStatus {
        return enumValueOf(value)
    }
}