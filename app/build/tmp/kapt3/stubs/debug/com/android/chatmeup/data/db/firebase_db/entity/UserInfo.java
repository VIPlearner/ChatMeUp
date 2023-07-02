package com.android.chatmeup.data.db.firebase_db.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\nH\u00c6\u0003JO\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010&\u001a\u00020\n2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020)H\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0007\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001e\u0010\t\u001a\u00020\n8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\b\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f\u00a8\u0006+"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/entity/UserInfo;", "", "id", "", "email", "displayName", "fcmToken", "aboutStr", "profileImageUrl", "online", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAboutStr", "()Ljava/lang/String;", "setAboutStr", "(Ljava/lang/String;)V", "getDisplayName", "setDisplayName", "getEmail", "setEmail", "getFcmToken", "setFcmToken", "getId", "setId", "getOnline", "()Z", "setOnline", "(Z)V", "getProfileImageUrl", "setProfileImageUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class UserInfo {
    @org.jetbrains.annotations.NotNull
    private java.lang.String id;
    @org.jetbrains.annotations.NotNull
    private java.lang.String email;
    @org.jetbrains.annotations.NotNull
    private java.lang.String displayName;
    @org.jetbrains.annotations.NotNull
    private java.lang.String fcmToken;
    @org.jetbrains.annotations.NotNull
    private java.lang.String aboutStr;
    @org.jetbrains.annotations.NotNull
    private java.lang.String profileImageUrl;
    private boolean online;
    
    @org.jetbrains.annotations.NotNull
    public final com.android.chatmeup.data.db.firebase_db.entity.UserInfo copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String displayName, @org.jetbrains.annotations.NotNull
    java.lang.String fcmToken, @org.jetbrains.annotations.NotNull
    java.lang.String aboutStr, @org.jetbrains.annotations.NotNull
    java.lang.String profileImageUrl, boolean online) {
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
    
    public UserInfo() {
        super();
    }
    
    public UserInfo(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String displayName, @org.jetbrains.annotations.NotNull
    java.lang.String fcmToken, @org.jetbrains.annotations.NotNull
    java.lang.String aboutStr, @org.jetbrains.annotations.NotNull
    java.lang.String profileImageUrl, boolean online) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "id")
    public final java.lang.String getId() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "id")
    public final void setId(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "email")
    public final java.lang.String getEmail() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "email")
    public final void setEmail(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "displayName")
    public final java.lang.String getDisplayName() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "displayName")
    public final void setDisplayName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "fcmToken")
    public final java.lang.String getFcmToken() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "fcmToken")
    public final void setFcmToken(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "aboutStr")
    public final java.lang.String getAboutStr() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "aboutStr")
    public final void setAboutStr(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "profileImageUrl")
    public final java.lang.String getProfileImageUrl() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "profileImageUrl")
    public final void setProfileImageUrl(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final boolean component7() {
        return false;
    }
    
    @com.google.firebase.database.PropertyName(value = "online")
    public final boolean getOnline() {
        return false;
    }
    
    @com.google.firebase.database.PropertyName(value = "online")
    public final void setOnline(boolean p0) {
    }
}