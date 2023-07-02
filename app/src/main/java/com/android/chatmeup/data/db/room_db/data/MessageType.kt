package com.android.chatmeup.data.db.room_db.data

import androidx.room.TypeConverter

enum class MessageType {
    TEXT,
    TEXT_IMAGE,
    TEXT_VIDEO,
}

class MessageTypeEnumConverter {
    @TypeConverter
    fun fromEnum(value: MessageType): String {
        return value.name
    }

    @TypeConverter
    fun toEnum(value: String): MessageType {
        return enumValueOf(value)
    }
}