package com.android.chatmeup.data.db.room_db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.android.chatmeup.data.db.room_db.entity.RoomMessage
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao{
    @Upsert
    fun upsertMessage(roomMessage: RoomMessage)

    @Delete
    fun deleteMessage(roomMessage: RoomMessage)

    @Query("SELECT * FROM roommessage WHERE :messageID = messageID")
    fun getMessage(messageID: String): RoomMessage

    @Query("SELECT EXISTS(SELECT * FROM roommessage WHERE :messageID = messageID)")
    fun messageExists(messageID: String): Boolean

    @Query("SELECT EXISTS(SELECT * FROM roommessage WHERE :chatID = chatID ORDER BY messageTime ASC)")
    fun messagesExistsInChat(chatID: String): Boolean

    @Query("SELECT * FROM roommessage WHERE :chatID = chatID ORDER BY messageTime ASC")
    fun getMessagesOrderedByTime(chatID: String): Flow<List<RoomMessage>>

    @Query("SELECT * FROM roommessage")
    fun getAllMessages(): List<RoomMessage>

    @Query("SELECT * FROM roommessage WHERE :chatID = chatID ORDER BY messageTime ASC LIMIT 1")
    fun getLastMessage(chatID: String): Flow<RoomMessage>

    @Query("SELECT * FROM roommessage WHERE messageText LIKE :searchText ORDER BY messageTime DESC")
    fun searchMessagesOrderedByTime(searchText: String): Flow<List<RoomMessage>>

    @Query("DELETE FROM roommessage")
    fun deleteTable()
}
