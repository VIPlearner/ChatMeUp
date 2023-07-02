package com.android.chatmeup.data.db.room_db.entity;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.android.chatmeup.data.db.room_db.data.MessageStatusEnumConverter.class})
@androidx.room.Entity
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0011J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u000fH\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0089\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00105\u001a\u000206H\u00d6\u0001J\t\u00107\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0013\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013\u00a8\u00068"}, d2 = {"Lcom/android/chatmeup/data/db/room_db/entity/RoomMessage;", "", "messageID", "", "timeStamp", "messageText", "messageTime", "", "messageType", "senderID", "localThumbnailPath", "serverThumbnailPath", "localFilePath", "serverFilePath", "messageStatus", "Lcom/android/chatmeup/data/db/room_db/data/MessageStatus;", "chatID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/chatmeup/data/db/room_db/data/MessageStatus;Ljava/lang/String;)V", "getChatID", "()Ljava/lang/String;", "getLocalFilePath", "setLocalFilePath", "(Ljava/lang/String;)V", "getLocalThumbnailPath", "setLocalThumbnailPath", "getMessageID", "getMessageStatus", "()Lcom/android/chatmeup/data/db/room_db/data/MessageStatus;", "getMessageText", "getMessageTime", "()J", "getMessageType", "getSenderID", "getServerFilePath", "setServerFilePath", "getServerThumbnailPath", "getTimeStamp", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class RoomMessage {
    @org.jetbrains.annotations.NotNull
    @androidx.room.PrimaryKey
    private final java.lang.String messageID = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String timeStamp = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String messageText = null;
    private final long messageTime = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String messageType = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String senderID = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.String localThumbnailPath;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String serverThumbnailPath = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.String localFilePath;
    @org.jetbrains.annotations.Nullable
    private java.lang.String serverFilePath;
    @org.jetbrains.annotations.NotNull
    private final com.android.chatmeup.data.db.room_db.data.MessageStatus messageStatus = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String chatID = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.android.chatmeup.data.db.room_db.entity.RoomMessage copy(@org.jetbrains.annotations.NotNull
    java.lang.String messageID, @org.jetbrains.annotations.NotNull
    java.lang.String timeStamp, @org.jetbrains.annotations.NotNull
    java.lang.String messageText, long messageTime, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.NotNull
    java.lang.String senderID, @org.jetbrains.annotations.Nullable
    java.lang.String localThumbnailPath, @org.jetbrains.annotations.Nullable
    java.lang.String serverThumbnailPath, @org.jetbrains.annotations.Nullable
    java.lang.String localFilePath, @org.jetbrains.annotations.Nullable
    java.lang.String serverFilePath, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.data.MessageStatus messageStatus, @org.jetbrains.annotations.NotNull
    java.lang.String chatID) {
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
    
    public RoomMessage(@org.jetbrains.annotations.NotNull
    java.lang.String messageID, @org.jetbrains.annotations.NotNull
    java.lang.String timeStamp, @org.jetbrains.annotations.NotNull
    java.lang.String messageText, long messageTime, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.NotNull
    java.lang.String senderID, @org.jetbrains.annotations.Nullable
    java.lang.String localThumbnailPath, @org.jetbrains.annotations.Nullable
    java.lang.String serverThumbnailPath, @org.jetbrains.annotations.Nullable
    java.lang.String localFilePath, @org.jetbrains.annotations.Nullable
    java.lang.String serverFilePath, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.data.MessageStatus messageStatus, @org.jetbrains.annotations.NotNull
    java.lang.String chatID) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMessageID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTimeStamp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMessageText() {
        return null;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long getMessageTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMessageType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSenderID() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLocalThumbnailPath() {
        return null;
    }
    
    public final void setLocalThumbnailPath(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getServerThumbnailPath() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLocalFilePath() {
        return null;
    }
    
    public final void setLocalFilePath(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getServerFilePath() {
        return null;
    }
    
    public final void setServerFilePath(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.android.chatmeup.data.db.room_db.data.MessageStatus component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.android.chatmeup.data.db.room_db.data.MessageStatus getMessageStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getChatID() {
        return null;
    }
}