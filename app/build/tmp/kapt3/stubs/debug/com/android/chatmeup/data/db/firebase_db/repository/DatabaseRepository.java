package com.android.chatmeup.data.db.firebase_db.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00132\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\r\u0012\u0004\u0012\u00020\u00060\fJ6\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00160\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00132\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00132\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00132\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00132\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\r\u0012\u0004\u0012\u00020\u00060\fJ6\u0010!\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00160\r\u0012\u0004\u0012\u00020\u00060\fJ(\u0010#\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00060\fJ(\u0010$\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r\u0012\u0004\u0012\u00020\u00060\fJ.\u0010%\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140&0\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\'\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\r\u0012\u0004\u0012\u00020\u00060\fJ.\u0010)\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190&0\r\u0012\u0004\u0012\u00020\u00060\fJ.\u0010*\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00160\r\u0012\u0004\u0012\u00020\u00060\fJ.\u0010+\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00160\r\u0012\u0004\u0012\u00020\u00060\fJ(\u0010,\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\r\u0012\u0004\u0012\u00020\u00060\fJ(\u0010-\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\r\u0012\u0004\u0012\u00020\u00060\fJ&\u0010.\u001a\u00020\u00062\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00160\r\u0012\u0004\u0012\u00020\u00060\fJ\u0016\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bJ\u000e\u00102\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u00103\u001a\u00020\u00062\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bJ\u0016\u00104\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u00105\u001a\u00020\bJ\u001e\u00106\u001a\u00020\u00062\u0006\u00100\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bJ\u000e\u00107\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bJ\u0016\u00108\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bJ\u0016\u00109\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010:\u001a\u00020\bJ\u0016\u0010;\u001a\u00020\u00062\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bJ\u0016\u0010<\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u000eJ\u0016\u0010>\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010?\u001a\u00020\bJ\u0016\u0010@\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bJ\u000e\u0010B\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u000eJ\u0016\u0010C\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u00100\u001a\u00020\bJ\u0016\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u00142\u0006\u0010F\u001a\u00020\u0014J\u001e\u0010G\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u0019J\u0016\u0010I\u001a\u00020\u00062\u0006\u00100\u001a\u00020\b2\u0006\u0010J\u001a\u00020\"J\u0016\u0010K\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u001eJ\u0016\u0010P\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010Q\u001a\u00020RJ\u0016\u0010S\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u00100\u001a\u00020\bJ\u0016\u0010T\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bJ\u001e\u0010U\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010V\u001a\u00020RJ\u0016\u0010W\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010V\u001a\u00020XJ\u0016\u0010Y\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\bJ\u0016\u0010[\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\\"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/repository/DatabaseRepository;", "", "()V", "firebaseDatabaseService", "Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseDataSource;", "loadAndObserveChat", "", "chatID", "", "observer", "Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseReferenceValueObserver;", "b", "Lkotlin/Function1;", "Lcom/android/chatmeup/data/Result;", "Lcom/android/chatmeup/data/db/firebase_db/entity/Chat;", "loadAndObserveChatInfo", "Lcom/android/chatmeup/data/db/firebase_db/entity/ChatInfo;", "loadAndObserveContactsRemoved", "userID", "Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseReferenceChildObserver;", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserFriend;", "loadAndObserveFriends", "", "loadAndObserveMessagesAdded", "messagesID", "Lcom/android/chatmeup/data/db/firebase_db/entity/Message;", "loadAndObserveMessagesRemoved", "loadAndObserveNewContactsAdded", "loadAndObserveNewMessagesAdded", "loadAndObserveUser", "Lcom/android/chatmeup/data/db/firebase_db/entity/User;", "loadAndObserveUserInfo", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserInfo;", "loadAndObserveUserNotifications", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserNotification;", "loadChat", "loadChatInfo", "loadFriends", "", "loadMessage", "messageID", "loadMessages", "loadNewMessages", "loadNotifications", "loadUser", "loadUserInfo", "loadUsers", "pushNewContact", "otherUserID", "myUserID", "removeChat", "removeContact", "removeFriend", "friendID", "removeMessage", "removeMessages", "removeNewMessages", "removeNotification", "notificationID", "removeSentRequest", "updateChatLastMessage", "chat", "updateDisplayName", "displayName", "updateFCMToken", "token", "updateNewChat", "updateNewContacts", "updateNewFriend", "myUser", "otherUser", "updateNewMessage", "message", "updateNewNotification", "userNotification", "updateNewSentRequest", "userRequest", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserRequest;", "updateNewUser", "user", "updateOnlineStatus", "status", "", "updateRemovedContacts", "updateRemovedMessages", "updateSeenMessage", "value", "updateUnreadMessages", "", "updateUserProfileImageUrl", "url", "updateUserStatus", "app_debug"})
public final class DatabaseRepository {
    private final com.android.chatmeup.data.db.firebase_db.remote.FirebaseDataSource firebaseDatabaseService = null;
    
    public DatabaseRepository() {
        super();
    }
    
    public final void updateUserStatus(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String status) {
    }
    
    public final void updateOnlineStatus(@org.jetbrains.annotations.NotNull
    java.lang.String userID, boolean status) {
    }
    
    public final void updateFCMToken(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String token) {
    }
    
    public final void updateDisplayName(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String displayName) {
    }
    
    public final void updateNewMessage(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.Message message) {
    }
    
    public final void pushNewContact(@org.jetbrains.annotations.NotNull
    java.lang.String otherUserID, @org.jetbrains.annotations.NotNull
    java.lang.String myUserID) {
    }
    
    public final void removeContact(@org.jetbrains.annotations.NotNull
    java.lang.String otherUserID, @org.jetbrains.annotations.NotNull
    java.lang.String myUserID) {
    }
    
    public final void updateNewUser(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.User user) {
    }
    
    public final void updateNewFriend(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.UserFriend myUser, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.UserFriend otherUser) {
    }
    
    public final void updateNewSentRequest(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.UserRequest userRequest) {
    }
    
    public final void updateNewNotification(@org.jetbrains.annotations.NotNull
    java.lang.String otherUserID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.UserNotification userNotification) {
    }
    
    public final void updateChatLastMessage(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.Chat chat) {
    }
    
    public final void updateUnreadMessages(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, int value) {
    }
    
    public final void updateSeenMessage(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    java.lang.String messageID, boolean value) {
    }
    
    public final void updateNewChat(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.Chat chat) {
    }
    
    public final void updateUserProfileImageUrl(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String url) {
    }
    
    public final void removeNotification(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String notificationID) {
    }
    
    public final void removeFriend(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String friendID) {
    }
    
    public final void removeSentRequest(@org.jetbrains.annotations.NotNull
    java.lang.String otherUserID, @org.jetbrains.annotations.NotNull
    java.lang.String myUserID) {
    }
    
    public final void removeChat(@org.jetbrains.annotations.NotNull
    java.lang.String chatID) {
    }
    
    public final void removeMessages(@org.jetbrains.annotations.NotNull
    java.lang.String messagesID) {
    }
    
    public final void removeMessage(@org.jetbrains.annotations.NotNull
    java.lang.String otherUserID, @org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    java.lang.String messageID) {
    }
    
    public final void removeNewMessages(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String messageID) {
    }
    
    public final void updateNewContacts(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String otherUserID) {
    }
    
    public final void updateRemovedContacts(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String otherUserID) {
    }
    
    public final void updateRemovedMessages(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String messageID) {
    }
    
    public final void loadUser(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.User>, kotlin.Unit> b) {
    }
    
    public final void loadUserInfo(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.UserInfo>, kotlin.Unit> b) {
    }
    
    public final void loadChat(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.Chat>, kotlin.Unit> b) {
    }
    
    public final void loadMessage(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    java.lang.String messageID, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.Message>, kotlin.Unit> b) {
    }
    
    public final void loadChatInfo(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.ChatInfo>, kotlin.Unit> b) {
    }
    
    public final void loadUsers(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends java.util.List<com.android.chatmeup.data.db.firebase_db.entity.User>>, kotlin.Unit> b) {
    }
    
    public final void loadFriends(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends java.util.List<com.android.chatmeup.data.db.firebase_db.entity.UserFriend>>, kotlin.Unit> b) {
    }
    
    public final void loadMessages(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends java.util.List<com.android.chatmeup.data.db.firebase_db.entity.Message>>, kotlin.Unit> b) {
    }
    
    public final void loadNotifications(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends java.util.List<com.android.chatmeup.data.db.firebase_db.entity.UserNotification>>, kotlin.Unit> b) {
    }
    
    public final void loadNewMessages(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends java.util.List<com.android.chatmeup.data.db.firebase_db.entity.Message>>, kotlin.Unit> b) {
    }
    
    public final void loadAndObserveUser(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver observer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.User>, kotlin.Unit> b) {
    }
    
    public final void loadAndObserveFriends(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver observer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends java.util.List<com.android.chatmeup.data.db.firebase_db.entity.UserFriend>>, kotlin.Unit> b) {
    }
    
    public final void loadAndObserveUserInfo(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver observer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.UserInfo>, kotlin.Unit> b) {
    }
    
    public final void loadAndObserveUserNotifications(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver observer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends java.util.List<com.android.chatmeup.data.db.firebase_db.entity.UserNotification>>, kotlin.Unit> b) {
    }
    
    public final void loadAndObserveMessagesAdded(@org.jetbrains.annotations.NotNull
    java.lang.String messagesID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceChildObserver observer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.Message>, kotlin.Unit> b) {
    }
    
    public final void loadAndObserveNewMessagesAdded(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceChildObserver observer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.Message>, kotlin.Unit> b) {
    }
    
    public final void loadAndObserveNewContactsAdded(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceChildObserver observer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.UserFriend>, kotlin.Unit> b) {
    }
    
    public final void loadAndObserveContactsRemoved(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceChildObserver observer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.UserFriend>, kotlin.Unit> b) {
    }
    
    public final void loadAndObserveMessagesRemoved(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceChildObserver observer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.Message>, kotlin.Unit> b) {
    }
    
    public final void loadAndObserveChat(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver observer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.Chat>, kotlin.Unit> b) {
    }
    
    public final void loadAndObserveChatInfo(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver observer, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<com.android.chatmeup.data.db.firebase_db.entity.ChatInfo>, kotlin.Unit> b) {
    }
}