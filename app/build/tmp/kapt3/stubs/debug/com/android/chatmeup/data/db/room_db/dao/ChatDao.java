package com.android.chatmeup.data.db.room_db.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'J\b\u0010\n\u001a\u00020\u0007H\'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH\'J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0005H\'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f0\u0010H\'J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'\u00a8\u0006\u0012"}, d2 = {"Lcom/android/chatmeup/data/db/room_db/dao/ChatDao;", "", "chatExists", "", "chatID", "", "deleteChat", "", "roomChat", "Lcom/android/chatmeup/data/db/room_db/entity/RoomChat;", "deleteTable", "getAllChats", "", "getChat", "chatId", "getChatsOrderedByTime", "Lkotlinx/coroutines/flow/Flow;", "upsertChat", "app_debug"})
public abstract interface ChatDao {
    
    @androidx.room.Upsert
    public abstract void upsertChat(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.entity.RoomChat roomChat);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM roomchat WHERE :chatId = id")
    public abstract com.android.chatmeup.data.db.room_db.entity.RoomChat getChat(@org.jetbrains.annotations.NotNull
    java.lang.String chatId);
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT * FROM roomchat WHERE :chatID = id)")
    public abstract boolean chatExists(@org.jetbrains.annotations.NotNull
    java.lang.String chatID);
    
    @androidx.room.Delete
    public abstract void deleteChat(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.entity.RoomChat roomChat);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM roomchat ORDER BY lastMessageTime DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomChat>> getChatsOrderedByTime();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM roomchat")
    public abstract java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomChat> getAllChats();
    
    @androidx.room.Query(value = "DELETE FROM roomchat")
    public abstract void deleteTable();
}