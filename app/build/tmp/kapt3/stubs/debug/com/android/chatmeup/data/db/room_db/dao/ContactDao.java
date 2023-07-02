package com.android.chatmeup.data.db.room_db.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'J\b\u0010\n\u001a\u00020\u0007H\'J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000f0\rH\'J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'\u00a8\u0006\u0012"}, d2 = {"Lcom/android/chatmeup/data/db/room_db/dao/ContactDao;", "", "contactExists", "", "userID", "", "deleteContact", "", "roomContact", "Lcom/android/chatmeup/data/db/room_db/entity/RoomContact;", "deleteTable", "getContact", "getContactFlow", "Lkotlinx/coroutines/flow/Flow;", "getContacts", "", "getContactsFlow", "upsertContact", "app_debug"})
public abstract interface ContactDao {
    
    @androidx.room.Upsert
    public abstract void upsertContact(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.entity.RoomContact roomContact);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM roomcontact")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomContact>> getContactsFlow();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM roomcontact")
    public abstract java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomContact> getContacts();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM roomcontact WHERE :userID == userID")
    public abstract kotlinx.coroutines.flow.Flow<com.android.chatmeup.data.db.room_db.entity.RoomContact> getContactFlow(@org.jetbrains.annotations.NotNull
    java.lang.String userID);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM roomcontact WHERE :userID == userID")
    public abstract com.android.chatmeup.data.db.room_db.entity.RoomContact getContact(@org.jetbrains.annotations.NotNull
    java.lang.String userID);
    
    @androidx.room.Query(value = "SELECT EXISTS(SELECT 1 FROM roomcontact WHERE :userID = userID)")
    public abstract boolean contactExists(@org.jetbrains.annotations.NotNull
    java.lang.String userID);
    
    @androidx.room.Delete
    public abstract void deleteContact(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.entity.RoomContact roomContact);
    
    @androidx.room.Query(value = "DELETE FROM roomcontact")
    public abstract void deleteTable();
}