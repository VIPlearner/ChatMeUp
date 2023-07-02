package com.android.chatmeup.data.db.room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.chatmeup.data.db.room_db.dao.ChatDao
import com.android.chatmeup.data.db.room_db.dao.ContactDao
import com.android.chatmeup.data.db.room_db.dao.MessageDao
import com.android.chatmeup.data.db.room_db.entity.RoomChat
import com.android.chatmeup.data.db.room_db.entity.RoomContact
import com.android.chatmeup.data.db.room_db.entity.RoomMessage

@Database(
    entities = [RoomChat::class, RoomMessage::class, RoomContact::class],
    version = 2
)
abstract class ChatMeUpDatabase: RoomDatabase() {
    abstract val chatDao: ChatDao
    abstract val messageDao: MessageDao
    abstract val contactDao: ContactDao
}