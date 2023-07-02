package com.android.chatmeup.data.db.room_db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.android.chatmeup.data.db.room_db.entity.RoomContact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Upsert
    fun upsertContact(roomContact: RoomContact)

    @Query("SELECT * FROM roomcontact")
    fun getContactsFlow(): Flow<List<RoomContact>>

    @Query("SELECT * FROM roomcontact")
    fun getContacts(): List<RoomContact>

    @Query("SELECT * FROM roomcontact WHERE :userID == userID")
    fun getContactFlow(userID: String): Flow<RoomContact>

    @Query("SELECT * FROM roomcontact WHERE :userID == userID")
    fun getContact(userID: String): RoomContact
    @Query("SELECT EXISTS(SELECT 1 FROM roomcontact WHERE :userID = userID)")
    fun contactExists(userID: String): Boolean

    @Delete
    fun deleteContact(roomContact: RoomContact)

    @Query("DELETE FROM roomcontact")
    fun deleteTable()
}