package com.android.chatmeup.data.db.room_db;

import java.lang.System;

@androidx.room.Database(entities = {com.android.chatmeup.data.db.room_db.entity.RoomChat.class, com.android.chatmeup.data.db.room_db.entity.RoomMessage.class, com.android.chatmeup.data.db.room_db.entity.RoomContact.class}, version = 2)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/android/chatmeup/data/db/room_db/ChatMeUpDatabase;", "Landroidx/room/RoomDatabase;", "()V", "chatDao", "Lcom/android/chatmeup/data/db/room_db/dao/ChatDao;", "getChatDao", "()Lcom/android/chatmeup/data/db/room_db/dao/ChatDao;", "contactDao", "Lcom/android/chatmeup/data/db/room_db/dao/ContactDao;", "getContactDao", "()Lcom/android/chatmeup/data/db/room_db/dao/ContactDao;", "messageDao", "Lcom/android/chatmeup/data/db/room_db/dao/MessageDao;", "getMessageDao", "()Lcom/android/chatmeup/data/db/room_db/dao/MessageDao;", "app_debug"})
public abstract class ChatMeUpDatabase extends androidx.room.RoomDatabase {
    
    public ChatMeUpDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.android.chatmeup.data.db.room_db.dao.ChatDao getChatDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.android.chatmeup.data.db.room_db.dao.MessageDao getMessageDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.android.chatmeup.data.db.room_db.dao.ContactDao getContactDao();
}