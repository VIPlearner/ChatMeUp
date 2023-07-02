package com.android.chatmeup.data.db.firebase_db.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 i2\u00020\u0001:\u0001iB\u0005\u00a2\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0004\u0012\u00020\u00040\rJD\u0010\u000f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0004\u0012\u00020\u00040\rJ6\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0004\u0012\u00020\u00040\rH\u0002JD\u0010\u0012\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00142\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0004\u0012\u00020\u00040\rJD\u0010\u0015\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00142\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0004\u0012\u00020\u00040\rJD\u0010\u0017\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00142\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0004\u0012\u00020\u00040\rJD\u0010\u0018\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00142\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0004\u0012\u00020\u00040\rJD\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00142\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0004\u0012\u00020\u00040\rJJ\u0010\u001a\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000b2\u001e\u0010\f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u001c0\u000e\u0012\u0004\u0012\u00020\u00040\rJD\u0010\u001d\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0004\u0012\u00020\u00040\rJJ\u0010\u001e\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000b2\u001e\u0010\f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u001c0\u000e\u0012\u0004\u0012\u00020\u00040\rJD\u0010\u001f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0004\u0012\u00020\u00040\rJ6\u0010 \u001a\u00020!\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000e\u0012\u0004\u0012\u00020\u00040\rH\u0002J<\u0010\"\u001a\u00020!\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u001e\u0010\f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u001c0\u000e\u0012\u0004\u0012\u00020\u00040\rH\u0002J\u0016\u0010#\u001a\u00020!2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\u0014\u0010\'\u001a\b\u0012\u0004\u0012\u00020&0(2\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020&0(2\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020&0(2\u0006\u0010\u0016\u001a\u00020\tJ\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020&0(2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tJ\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020&0(2\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020&0(2\u0006\u0010\u0016\u001a\u00020\tJ\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020&0(2\u0006\u0010\u0016\u001a\u00020\tJ\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020&0(2\u0006\u0010\u0016\u001a\u00020\tJ\f\u00101\u001a\b\u0012\u0004\u0012\u00020&0(J\u0016\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tJ\u001e\u00105\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u00106\u001a\u000207J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\tH\u0002J\u000e\u0010;\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010<\u001a\u00020\u00042\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tJ\u0016\u0010=\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tJ\u001e\u0010?\u001a\u00020\u00042\u0006\u00103\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tJ\u000e\u0010@\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\tJ\u0016\u0010A\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tJ\u0016\u0010B\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010C\u001a\u00020\tJ\u0016\u0010D\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010E\u001a\u00020\tJ\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020G0(2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010H\u001a\u00020\tJ\u0016\u0010I\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010J\u001a\u00020\tJ\u0016\u0010K\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u00020\u00042\u0006\u0010L\u001a\u00020MJ\u0016\u0010O\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u00103\u001a\u00020\tJ\u0016\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020RJ\u0016\u0010T\u001a\u00020\u00042\u0006\u00103\u001a\u00020\t2\u0006\u0010U\u001a\u00020VJ\u0016\u0010W\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010X\u001a\u00020YJ\u000e\u0010Z\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\\J\u0016\u0010]\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010^\u001a\u00020_J\u0016\u0010`\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u00103\u001a\u00020\tJ\u0016\u0010a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010,\u001a\u00020\tJ\u001e\u0010b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010c\u001a\u00020_J\u0016\u0010d\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010c\u001a\u00020eJ\u0016\u0010f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010g\u001a\u00020\tJ\u001c\u0010h\u001a\b\u0012\u0004\u0012\u00020G0(2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010^\u001a\u00020\t\u00a8\u0006j"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseDataSource;", "", "()V", "attachChatInfoObserver", "", "T", "resultClassName", "Ljava/lang/Class;", "chatID", "", "refObs", "Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseReferenceValueObserver;", "b", "Lkotlin/Function1;", "Lcom/android/chatmeup/data/Result;", "attachChatObserver", "attachChildListenerToBlock", "Lcom/google/firebase/database/ChildEventListener;", "attachMessagesObserver", "messagesID", "Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseReferenceChildObserver;", "attachNewContactsObserver", "userID", "attachNewMessagesObserver", "attachRemoveContactsObserver", "attachRemovedMessagesObserver", "attachUserFriendsObserver", "firebaseReferenceValueObserver", "", "attachUserInfoObserver", "attachUserNotificationsObserver", "attachUserObserver", "attachValueListenerToBlock", "Lcom/google/firebase/database/ValueEventListener;", "attachValueListenerToBlockWithList", "attachValueListenerToTaskCompletion", "src", "Lcom/google/android/gms/tasks/TaskCompletionSource;", "Lcom/google/firebase/database/DataSnapshot;", "loadChatInfoTask", "Lcom/google/android/gms/tasks/Task;", "loadChatTask", "loadFriendsTask", "loadMessageTask", "messageID", "loadMessagesTask", "loadNotificationsTask", "loadUserInfoTask", "loadUserTask", "loadUsersTask", "pushNewContact", "otherUserID", "myUserID", "pushNewMessage", "message", "Lcom/android/chatmeup/data/db/firebase_db/entity/Message;", "refToPath", "Lcom/google/firebase/database/DatabaseReference;", "path", "removeChat", "removeContact", "removeFriend", "friendID", "removeMessage", "removeMessages", "removeNewMessages", "removeNotification", "notificationID", "removeSentRequest", "sentRequestID", "updateDisplayName", "Ljava/lang/Void;", "displayName", "updateFCMToken", "token", "updateLastMessage", "chat", "Lcom/android/chatmeup/data/db/firebase_db/entity/Chat;", "updateNewChat", "updateNewContacts", "updateNewFriend", "myUser", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserFriend;", "otherUser", "updateNewNotification", "userNotification", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserNotification;", "updateNewSentRequest", "userRequest", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserRequest;", "updateNewUser", "user", "Lcom/android/chatmeup/data/db/firebase_db/entity/User;", "updateOnlineStatus", "status", "", "updateRemovedContacts", "updateRemovedMessages", "updateSeenMessage", "value", "updateUnreadMessages", "", "updateUserProfileImageUrl", "url", "updateUserStatus", "Companion", "app_debug"})
public final class FirebaseDataSource {
    @org.jetbrains.annotations.NotNull
    public static final com.android.chatmeup.data.db.firebase_db.remote.FirebaseDataSource.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static final com.google.firebase.database.FirebaseDatabase dbInstance = null;
    
    public FirebaseDataSource() {
        super();
    }
    
    private final com.google.firebase.database.DatabaseReference refToPath(java.lang.String path) {
        return null;
    }
    
    private final com.google.firebase.database.ValueEventListener attachValueListenerToTaskCompletion(com.google.android.gms.tasks.TaskCompletionSource<com.google.firebase.database.DataSnapshot> src) {
        return null;
    }
    
    private final <T extends java.lang.Object>com.google.firebase.database.ValueEventListener attachValueListenerToBlock(java.lang.Class<T> resultClassName, kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends T>, kotlin.Unit> b) {
        return null;
    }
    
    private final <T extends java.lang.Object>com.google.firebase.database.ValueEventListener attachValueListenerToBlockWithList(java.lang.Class<T> resultClassName, kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends java.util.List<T>>, kotlin.Unit> b) {
        return null;
    }
    
    private final <T extends java.lang.Object>com.google.firebase.database.ChildEventListener attachChildListenerToBlock(java.lang.Class<T> resultClassName, kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends T>, kotlin.Unit> b) {
        return null;
    }
    
    public final void updateUserProfileImageUrl(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String url) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<java.lang.Void> updateUserStatus(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String status) {
        return null;
    }
    
    public final void updateOnlineStatus(@org.jetbrains.annotations.NotNull
    java.lang.String userID, boolean status) {
    }
    
    public final void updateFCMToken(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String token) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<java.lang.Void> updateDisplayName(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String displayName) {
        return null;
    }
    
    public final void updateLastMessage(@org.jetbrains.annotations.NotNull
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
    
    public final void updateNewUser(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.User user) {
    }
    
    public final void updateNewChat(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.Chat chat) {
    }
    
    public final void pushNewMessage(@org.jetbrains.annotations.NotNull
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
    
    public final void removeNotification(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String notificationID) {
    }
    
    public final void removeFriend(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String friendID) {
    }
    
    public final void removeSentRequest(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    java.lang.String sentRequestID) {
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
    
    public final void updateRemovedMessages(@org.jetbrains.annotations.NotNull
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
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<com.google.firebase.database.DataSnapshot> loadUserTask(@org.jetbrains.annotations.NotNull
    java.lang.String userID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<com.google.firebase.database.DataSnapshot> loadUserInfoTask(@org.jetbrains.annotations.NotNull
    java.lang.String userID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<com.google.firebase.database.DataSnapshot> loadChatInfoTask(@org.jetbrains.annotations.NotNull
    java.lang.String chatID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<com.google.firebase.database.DataSnapshot> loadUsersTask() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<com.google.firebase.database.DataSnapshot> loadFriendsTask(@org.jetbrains.annotations.NotNull
    java.lang.String userID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<com.google.firebase.database.DataSnapshot> loadMessagesTask(@org.jetbrains.annotations.NotNull
    java.lang.String chatID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<com.google.firebase.database.DataSnapshot> loadMessageTask(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    java.lang.String messageID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<com.google.firebase.database.DataSnapshot> loadChatTask(@org.jetbrains.annotations.NotNull
    java.lang.String chatID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<com.google.firebase.database.DataSnapshot> loadNotificationsTask(@org.jetbrains.annotations.NotNull
    java.lang.String userID) {
        return null;
    }
    
    public final <T extends java.lang.Object>void attachUserObserver(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> resultClassName, @org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver refObs, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends T>, kotlin.Unit> b) {
    }
    
    public final <T extends java.lang.Object>void attachUserInfoObserver(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> resultClassName, @org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver refObs, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends T>, kotlin.Unit> b) {
    }
    
    public final <T extends java.lang.Object>void attachUserFriendsObserver(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> resultClassName, @org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver firebaseReferenceValueObserver, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends java.util.List<T>>, kotlin.Unit> b) {
    }
    
    public final <T extends java.lang.Object>void attachUserNotificationsObserver(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> resultClassName, @org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver firebaseReferenceValueObserver, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends java.util.List<T>>, kotlin.Unit> b) {
    }
    
    public final <T extends java.lang.Object>void attachMessagesObserver(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> resultClassName, @org.jetbrains.annotations.NotNull
    java.lang.String messagesID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceChildObserver refObs, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends T>, kotlin.Unit> b) {
    }
    
    public final <T extends java.lang.Object>void attachNewMessagesObserver(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> resultClassName, @org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceChildObserver refObs, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends T>, kotlin.Unit> b) {
    }
    
    public final <T extends java.lang.Object>void attachNewContactsObserver(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> resultClassName, @org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceChildObserver refObs, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends T>, kotlin.Unit> b) {
    }
    
    public final <T extends java.lang.Object>void attachRemoveContactsObserver(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> resultClassName, @org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceChildObserver refObs, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends T>, kotlin.Unit> b) {
    }
    
    public final <T extends java.lang.Object>void attachRemovedMessagesObserver(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> resultClassName, @org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceChildObserver refObs, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends T>, kotlin.Unit> b) {
    }
    
    public final <T extends java.lang.Object>void attachChatObserver(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> resultClassName, @org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver refObs, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends T>, kotlin.Unit> b) {
    }
    
    public final <T extends java.lang.Object>void attachChatInfoObserver(@org.jetbrains.annotations.NotNull
    java.lang.Class<T> resultClassName, @org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver refObs, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends T>, kotlin.Unit> b) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseDataSource$Companion;", "", "()V", "dbInstance", "Lcom/google/firebase/database/FirebaseDatabase;", "getDbInstance", "()Lcom/google/firebase/database/FirebaseDatabase;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.FirebaseDatabase getDbInstance() {
            return null;
        }
    }
}