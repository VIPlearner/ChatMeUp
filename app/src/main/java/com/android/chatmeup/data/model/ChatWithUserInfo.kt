package com.android.chatmeup.data.model

import com.android.chatmeup.data.db.firebase_db.entity.Chat
import com.android.chatmeup.data.db.firebase_db.entity.UserInfo

data class ChatWithUserInfo(
    var mChat: Chat,
    var mUserInfo: UserInfo
)
