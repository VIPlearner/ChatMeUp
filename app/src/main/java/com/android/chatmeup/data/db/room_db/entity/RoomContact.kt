package com.android.chatmeup.data.db.room_db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomContact(
    @PrimaryKey
    val userID: String,
    var displayName: String = "",
    var email: String = "",
    var aboutStr: String = "",
    var localProfilePhotoPath: String = "",
    var onlinePhotoPath: String = "",
    var isOnline: Boolean = false
)
