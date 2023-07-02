package com.android.chatmeup.data.db.firebase_db.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\b\u0012$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f`\b\u0012$\b\u0002\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e`\b\u0012$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u0012$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u0012$\b\u0002\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e`\b\u00a2\u0006\u0002\u0010\u0012J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J%\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u00c6\u0003J%\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\bH\u00c6\u0003J%\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f`\bH\u00c6\u0003J%\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e`\bH\u00c6\u0003J%\u0010,\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u00c6\u0003J%\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u00c6\u0003J%\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e`\bH\u00c6\u0003J\u009d\u0002\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b2$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\b2$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f`\b2$\b\u0002\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e`\b2$\b\u0002\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b2$\b\u0002\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b2$\b\u0002\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e`\bH\u00c6\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u000204H\u00d6\u0001J\t\u00105\u001a\u00020\u0006H\u00d6\u0001R:\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR:\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R:\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e`\b8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R:\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\b8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R:\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R:\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e`\b8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R:\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f`\b8\u0007@\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016\u00a8\u00066"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/entity/User;", "", "info", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserInfo;", "friends", "Ljava/util/HashMap;", "", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserFriend;", "Lkotlin/collections/HashMap;", "notifications", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserNotification;", "sentRequests", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserRequest;", "newMessages", "Lcom/android/chatmeup/data/db/firebase_db/entity/Message;", "newContacts", "removedContacts", "removedMessages", "(Lcom/android/chatmeup/data/db/firebase_db/entity/UserInfo;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getFriends", "()Ljava/util/HashMap;", "setFriends", "(Ljava/util/HashMap;)V", "getInfo", "()Lcom/android/chatmeup/data/db/firebase_db/entity/UserInfo;", "setInfo", "(Lcom/android/chatmeup/data/db/firebase_db/entity/UserInfo;)V", "getNewContacts", "setNewContacts", "getNewMessages", "setNewMessages", "getNotifications", "setNotifications", "getRemovedContacts", "setRemovedContacts", "getRemovedMessages", "setRemovedMessages", "getSentRequests", "setSentRequests", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class User {
    @org.jetbrains.annotations.NotNull
    private com.android.chatmeup.data.db.firebase_db.entity.UserInfo info;
    @org.jetbrains.annotations.NotNull
    private java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> friends;
    @org.jetbrains.annotations.NotNull
    private java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserNotification> notifications;
    @org.jetbrains.annotations.NotNull
    private java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserRequest> sentRequests;
    @org.jetbrains.annotations.NotNull
    private java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.Message> newMessages;
    @org.jetbrains.annotations.NotNull
    private java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> newContacts;
    @org.jetbrains.annotations.NotNull
    private java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> removedContacts;
    @org.jetbrains.annotations.NotNull
    private java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.Message> removedMessages;
    
    @org.jetbrains.annotations.NotNull
    public final com.android.chatmeup.data.db.firebase_db.entity.User copy(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.UserInfo info, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> friends, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserNotification> notifications, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserRequest> sentRequests, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.Message> newMessages, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> newContacts, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> removedContacts, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.Message> removedMessages) {
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
    
    public User() {
        super();
    }
    
    public User(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.UserInfo info, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> friends, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserNotification> notifications, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserRequest> sentRequests, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.Message> newMessages, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> newContacts, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> removedContacts, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.Message> removedMessages) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.android.chatmeup.data.db.firebase_db.entity.UserInfo component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "info")
    public final com.android.chatmeup.data.db.firebase_db.entity.UserInfo getInfo() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "info")
    public final void setInfo(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.UserInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "friends")
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> getFriends() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "friends")
    public final void setFriends(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserNotification> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "notifications")
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserNotification> getNotifications() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "notifications")
    public final void setNotifications(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserNotification> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserRequest> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "sentRequests")
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserRequest> getSentRequests() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "sentRequests")
    public final void setSentRequests(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserRequest> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.Message> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "newMessages")
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.Message> getNewMessages() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "newMessages")
    public final void setNewMessages(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.Message> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "newContacts")
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> getNewContacts() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "newContacts")
    public final void setNewContacts(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "removedContacts")
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> getRemovedContacts() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "removedContacts")
    public final void setRemovedContacts(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.UserFriend> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.Message> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @com.google.firebase.database.PropertyName(value = "removedMessages")
    public final java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.Message> getRemovedMessages() {
        return null;
    }
    
    @com.google.firebase.database.PropertyName(value = "removedMessages")
    public final void setRemovedMessages(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.db.firebase_db.entity.Message> p0) {
    }
}