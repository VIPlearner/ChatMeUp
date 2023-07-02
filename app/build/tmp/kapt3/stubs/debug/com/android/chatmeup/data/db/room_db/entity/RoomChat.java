package com.android.chatmeup.data.db.room_db.entity;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.android.chatmeup.data.db.room_db.data.MessageTypeEnumConverter.class})
@androidx.room.Entity
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0010J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\tH\u00c6\u0003J\t\u00100\u001a\u00020\u000bH\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003Jm\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00108\u001a\u00020\u0005H\u00d6\u0001J\t\u00109\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0012R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014\u00a8\u0006:"}, d2 = {"Lcom/android/chatmeup/data/db/room_db/entity/RoomChat;", "", "id", "", "no_of_unread_messages", "", "displayName", "lastMessageText", "lastMessageTime", "", "messageType", "Lcom/android/chatmeup/data/db/room_db/data/MessageType;", "lastMessageSenderID", "otherUserId", "profilePhotoPath", "onlineProfilePhotoPath", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLcom/android/chatmeup/data/db/room_db/data/MessageType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "getId", "getLastMessageSenderID", "setLastMessageSenderID", "getLastMessageText", "setLastMessageText", "getLastMessageTime", "()J", "setLastMessageTime", "(J)V", "getMessageType", "()Lcom/android/chatmeup/data/db/room_db/data/MessageType;", "setMessageType", "(Lcom/android/chatmeup/data/db/room_db/data/MessageType;)V", "getNo_of_unread_messages", "()I", "setNo_of_unread_messages", "(I)V", "getOnlineProfilePhotoPath", "getOtherUserId", "getProfilePhotoPath", "setProfilePhotoPath", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class RoomChat {
    @org.jetbrains.annotations.NotNull
    @androidx.room.PrimaryKey(autoGenerate = false)
    private final java.lang.String id = null;
    private int no_of_unread_messages;
    @org.jetbrains.annotations.NotNull
    private java.lang.String displayName;
    @org.jetbrains.annotations.NotNull
    private java.lang.String lastMessageText;
    private long lastMessageTime;
    @org.jetbrains.annotations.NotNull
    private com.android.chatmeup.data.db.room_db.data.MessageType messageType;
    @org.jetbrains.annotations.NotNull
    private java.lang.String lastMessageSenderID;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String otherUserId = null;
    @org.jetbrains.annotations.NotNull
    private java.lang.String profilePhotoPath;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String onlineProfilePhotoPath = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.android.chatmeup.data.db.room_db.entity.RoomChat copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, int no_of_unread_messages, @org.jetbrains.annotations.NotNull
    java.lang.String displayName, @org.jetbrains.annotations.NotNull
    java.lang.String lastMessageText, long lastMessageTime, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.data.MessageType messageType, @org.jetbrains.annotations.NotNull
    java.lang.String lastMessageSenderID, @org.jetbrains.annotations.NotNull
    java.lang.String otherUserId, @org.jetbrains.annotations.NotNull
    java.lang.String profilePhotoPath, @org.jetbrains.annotations.NotNull
    java.lang.String onlineProfilePhotoPath) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public RoomChat(@org.jetbrains.annotations.NotNull
    java.lang.String id, int no_of_unread_messages, @org.jetbrains.annotations.NotNull
    java.lang.String displayName, @org.jetbrains.annotations.NotNull
    java.lang.String lastMessageText, long lastMessageTime, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.data.MessageType messageType, @org.jetbrains.annotations.NotNull
    java.lang.String lastMessageSenderID, @org.jetbrains.annotations.NotNull
    java.lang.String otherUserId, @org.jetbrains.annotations.NotNull
    java.lang.String profilePhotoPath, @org.jetbrains.annotations.NotNull
    java.lang.String onlineProfilePhotoPath) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getNo_of_unread_messages() {
        return 0;
    }
    
    public final void setNo_of_unread_messages(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    public final void setDisplayName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLastMessageText() {
        return null;
    }
    
    public final void setLastMessageText(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long getLastMessageTime() {
        return 0L;
    }
    
    public final void setLastMessageTime(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.android.chatmeup.data.db.room_db.data.MessageType component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.android.chatmeup.data.db.room_db.data.MessageType getMessageType() {
        return null;
    }
    
    public final void setMessageType(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.data.MessageType p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLastMessageSenderID() {
        return null;
    }
    
    public final void setLastMessageSenderID(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOtherUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getProfilePhotoPath() {
        return null;
    }
    
    public final void setProfilePhotoPath(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getOnlineProfilePhotoPath() {
        return null;
    }
}