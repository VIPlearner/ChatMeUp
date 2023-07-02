package com.android.chatmeup.data.db.firebase_db.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\'\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\nH\u00c6\u0003J\t\u0010.\u001a\u00020\fH\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003Jc\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00101\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u000204H\u00d6\u0001J\t\u00105\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\t\u001a\u00020\n8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\r\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001e\u0010\u0006\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\u000b\u001a\u00020\f8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u0002\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001e\u0010\b\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001e\u0010\u0007\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016\u00a8\u00066"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/entity/Message;", "", "senderID", "", "receiverID", "imageUrl", "messageType", "thumbnailUrl", "text", "epochTimeMs", "", "seen", "", "messageID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;)V", "getEpochTimeMs", "()J", "setEpochTimeMs", "(J)V", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "getMessageID", "setMessageID", "getMessageType", "setMessageType", "getReceiverID", "setReceiverID", "getSeen", "()Z", "setSeen", "(Z)V", "getSenderID", "setSenderID", "getText", "setText", "getThumbnailUrl", "setThumbnailUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class Message {
    @org.jetbrains.annotations.NotNull
    private java.lang.String senderID;
    @org.jetbrains.annotations.NotNull
    private java.lang.String receiverID;
    @org.jetbrains.annotations.NotNull
    private java.lang.String imageUrl;
    @org.jetbrains.annotations.NotNull
    private java.lang.String messageType;
    @org.jetbrains.annotations.NotNull
    private java.lang.String thumbnailUrl;
    @org.jetbrains.annotations.NotNull
    private java.lang.String text;
    private long epochTimeMs;
    private boolean seen;
    @org.jetbrains.annotations.NotNull
    private java.lang.String messageID;
    
    @org.jetbrains.annotations.NotNull
    public final com.android.chatmeup.data.db.firebase_db.entity.Message copy(@org.jetbrains.annotations.NotNull
    java.lang.String senderID, @org.jetbrains.annotations.NotNull
    java.lang.String receiverID, @org.jetbrains.annotations.NotNull
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.NotNull
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.NotNull
    java.lang.String text, long epochTimeMs, boolean seen, @org.jetbrains.annotations.NotNull
    java.lang.String messageID) {
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
    
    public Message() {
        super();
    }
    
    public Message(@org.jetbrains.annotations.NotNull
    java.lang.String senderID, @org.jetbrains.annotations.NotNull
    java.lang.String receiverID, @org.jetbrains.annotations.NotNull
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull
    java.lang.String messageType, @org.jetbrains.annotations.NotNull
    java.lang.String thumbnailUrl, @org.jetbrains.annotations.NotNull
    java.lang.String text, long epochTimeMs, boolean seen, @org.jetbrains.annotations.NotNull
    java.lang.String messageID) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "senderID")
    public final java.lang.String getSenderID() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "senderID")
    public final void setSenderID(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "receiverID")
    public final java.lang.String getReceiverID() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "receiverID")
    public final void setReceiverID(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "imageUrl")
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "imageUrl")
    public final void setImageUrl(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "messageType")
    public final java.lang.String getMessageType() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "messageType")
    public final void setMessageType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "thumbnailUrl")
    public final java.lang.String getThumbnailUrl() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "thumbnailUrl")
    public final void setThumbnailUrl(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "text")
    public final java.lang.String getText() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "text")
    public final void setText(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final long component7() {
        return 0L;
    }
    
    @com.google.firebase.database.PropertyName(value = "epochTimeMs")
    public final long getEpochTimeMs() {
        return 0L;
    }
    
    @com.google.firebase.database.PropertyName(value = "epochTimeMs")
    public final void setEpochTimeMs(long p0) {
    }
    
    public final boolean component8() {
        return false;
    }
    
    @com.google.firebase.database.PropertyName(value = "seen")
    public final boolean getSeen() {
        return false;
    }
    
    @com.google.firebase.database.PropertyName(value = "seen")
    public final void setSeen(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "messageID")
    public final java.lang.String getMessageID() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "messageID")
    public final void setMessageID(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
}