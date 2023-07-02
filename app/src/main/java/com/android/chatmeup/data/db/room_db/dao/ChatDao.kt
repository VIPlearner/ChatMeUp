package com.android.chatmeup.data.db.room_db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.android.chatmeup.data.db.room_db.entity.RoomChat
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao{
    @Upsert
    fun upsertChat(roomChat: RoomChat)

    @Query("SELECT * FROM roomchat WHERE :chatId = id")
    fun getChat(chatId: String): RoomChat

    @Query("SELECT EXISTS(SELECT * FROM roomchat WHERE :chatID = id)")
    fun chatExists(chatID: String): Boolean

    @Delete
    fun deleteChat(roomChat: RoomChat)

    @Query("SELECT * FROM roomchat ORDER BY lastMessageTime DESC")
    fun getChatsOrderedByTime(): Flow<List<RoomChat>>

    @Query("SELECT * FROM roomchat")
    fun getAllChats(): List<RoomChat>

//    @Query("SELECT * FROM chat WHERE lastMessageText LIKE :searchText ORDER BY lastMessageTime DESC")
//    fun searchChatsOrderedByTime(searchText: String): Flow<List<Chat>>

    @Query("DELETE FROM roomchat")
    fun deleteTable()
}
