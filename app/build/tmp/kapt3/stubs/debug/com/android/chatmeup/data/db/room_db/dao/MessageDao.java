package com.android.chatmeup.data.db.room_db.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\fH\'J\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\fH\'J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\'J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\n2\u0006\u0010\u0014\u001a\u00020\fH\'J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0016"}, d2 = {"Lcom/android/chatmeup/data/db/room_db/dao/MessageDao;", "", "deleteMessage", "", "roomMessage", "Lcom/android/chatmeup/data/db/room_db/entity/RoomMessage;", "deleteTable", "getAllMessages", "", "getLastMessage", "Lkotlinx/coroutines/flow/Flow;", "chatID", "", "getMessage", "messageID", "getMessagesOrderedByTime", "messageExists", "", "messagesExistsInChat", "searchMessagesOrderedByTime", "searchText", "upsertMessage", "app_debug"})
public abstract interface MessageDao {
    
    @androidx.room.Upsert
    public abstract void upsertMessage(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.entity.RoomMessage roomMessage);
    
    @androidx.room.Delete
    public abstract void deleteMessage(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.entity.RoomMessage roomMessage);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM roommessage WHERE :messageID = messageID")
    public abstract com.android.chatmeup.data.db.room_db.entity.RoomMessage getMessage(@org.jetbrains.annotations.NotNull
    java.lang.String messageID);
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT * FROM roommessage WHERE :messageID = messageID)")
    public abstract boolean messageExists(@org.jetbrains.annotations.NotNull
    java.lang.String messageID);
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT * FROM roommessage WHERE :chatID = chatID ORDER BY messageTime ASC)")
    public abstract boolean messagesExistsInChat(@org.jetbrains.annotations.NotNull
    java.lang.String chatID);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM roommessage WHERE :chatID = chatID ORDER BY messageTime ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomMessage>> getMessagesOrderedByTime(@org.jetbrains.annotations.NotNull
    java.lang.String chatID);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM roommessage")
    public abstract java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomMessage> getAllMessages();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM roommessage WHERE :chatID = chatID ORDER BY messageTime ASC LIMIT 1")
    public abstract kotlinx.coroutines.flow.Flow<com.android.chatmeup.data.db.room_db.entity.RoomMessage> getLastMessage(@org.jetbrains.annotations.NotNull
    java.lang.String chatID);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM roommessage WHERE messageText LIKE :searchText ORDER BY messageTime DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomMessage>> searchMessagesOrderedByTime(@org.jetbrains.annotations.NotNull
    java.lang.String searchText);
    
    @androidx.room.Query(value = "DELETE FROM roommessage")
    public abstract void deleteTable();
}