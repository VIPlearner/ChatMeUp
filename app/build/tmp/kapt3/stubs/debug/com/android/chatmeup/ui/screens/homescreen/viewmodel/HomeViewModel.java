package com.android.chatmeup.ui.screens.homescreen.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 V2\u00020\u0001:\u0005UVWXYB)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0018J\u000e\u0010>\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0018J\b\u0010?\u001a\u00020<H\u0002J\b\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020DH\u0002J\u000e\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020GJ4\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020J2\u0006\u0010F\u001a\u00020G2\b\u0010K\u001a\u0004\u0018\u00010L2\b\b\u0002\u0010M\u001a\u00020\u00032\b\b\u0002\u0010N\u001a\u00020\u0003J\b\u0010O\u001a\u00020<H\u0014J\"\u0010P\u001a\u00020<2\u0006\u0010F\u001a\u00020G2\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010N\u001a\u00020\u0003H\u0003J\u0018\u0010Q\u001a\u00020<2\u0006\u0010R\u001a\u00020\u00182\u0006\u0010S\u001a\u00020TH\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001d\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180504\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001d\u00a8\u0006Z"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel;", "Lcom/android/chatmeup/ui/DefaultViewModel;", "myUserId", "", "cmuDataStoreRepository", "Lcom/android/chatmeup/data/datastore/CmuDataStoreRepository;", "chatMeUpDatabase", "Lcom/android/chatmeup/data/db/room_db/ChatMeUpDatabase;", "appTaskManager", "Lcom/android/chatmeup/AppTaskManager;", "(Ljava/lang/String;Lcom/android/chatmeup/data/datastore/CmuDataStoreRepository;Lcom/android/chatmeup/data/db/room_db/ChatMeUpDatabase;Lcom/android/chatmeup/AppTaskManager;)V", "_addContactEventState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/AddContactEventState;", "_chatsList", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/android/chatmeup/data/db/room_db/entity/RoomChat;", "_myContact", "Lcom/android/chatmeup/data/db/room_db/entity/RoomContact;", "_updatedChatWithUserInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/android/chatmeup/data/model/ChatWithUserInfo;", "_updatedUserNotification", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserInfo;", "_viewState", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$HomeViewState;", "addContactEventState", "getAddContactEventState", "()Lkotlinx/coroutines/flow/StateFlow;", "getAppTaskManager", "()Lcom/android/chatmeup/AppTaskManager;", "authRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/AuthRepository;", "dbRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/DatabaseRepository;", "firebaseReferenceObserverList", "Ljava/util/ArrayList;", "Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseReferenceValueObserver;", "homeEventState", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeEventState;", "getHomeEventState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "getIoScope", "()Lkotlinx/coroutines/CoroutineScope;", "getMyUserId", "()Ljava/lang/String;", "setMyUserId", "(Ljava/lang/String;)V", "notificationListWithUserInfo", "Landroidx/lifecycle/MediatorLiveData;", "", "getNotificationListWithUserInfo", "()Landroidx/lifecycle/MediatorLiveData;", "tag", "viewState", "getViewState", "acceptNotificationPressed", "", "userInfo", "declineNotificationPressed", "loadAndObserveNotifications", "loadUserID", "Lkotlinx/coroutines/Job;", "loadUserInfo", "userNotification", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserNotification;", "logout", "context", "Landroid/content/Context;", "onAddContactEventTriggered", "event", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents;", "activity", "Landroid/app/Activity;", "errorMsg", "email", "onCleared", "sendFriendRequest", "updateNotification", "otherUserInfo", "removeOnly", "", "AddContactEvents", "Companion", "Factory", "HomeEvents", "HomeViewState", "app_debug"})
public final class HomeViewModel extends com.android.chatmeup.ui.DefaultViewModel {
    @org.jetbrains.annotations.NotNull
    private java.lang.String myUserId;
    private final com.android.chatmeup.data.datastore.CmuDataStoreRepository cmuDataStoreRepository = null;
    private final com.android.chatmeup.data.db.room_db.ChatMeUpDatabase chatMeUpDatabase = null;
    @org.jetbrains.annotations.NotNull
    private final com.android.chatmeup.AppTaskManager appTaskManager = null;
    private final java.lang.String tag = "HomeViewModel";
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeEventState> homeEventState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.ui.screens.homescreen.viewmodel.AddContactEventState> _addContactEventState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.ui.screens.homescreen.viewmodel.AddContactEventState> addContactEventState = null;
    private final com.android.chatmeup.data.db.firebase_db.repository.AuthRepository authRepository = null;
    private final com.android.chatmeup.data.db.firebase_db.repository.DatabaseRepository dbRepository = null;
    private final java.util.ArrayList<com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver> firebaseReferenceObserverList = null;
    private final androidx.lifecycle.MutableLiveData<com.android.chatmeup.data.db.firebase_db.entity.UserInfo> _updatedUserNotification = null;
    private final androidx.lifecycle.MutableLiveData<com.android.chatmeup.data.model.ChatWithUserInfo> _updatedChatWithUserInfo = null;
    private final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.data.db.room_db.entity.RoomContact> _myContact = null;
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomChat>> _chatsList = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.HomeViewState> _viewState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MediatorLiveData<java.util.List<com.android.chatmeup.data.db.firebase_db.entity.UserInfo>> notificationListWithUserInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope ioScope = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.HomeViewState> viewState = null;
    @org.jetbrains.annotations.NotNull
    public static final com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.Companion Companion = null;
    
    @dagger.assisted.AssistedInject
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    @dagger.assisted.Assisted(value = "myUserId")
    java.lang.String myUserId, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.datastore.CmuDataStoreRepository cmuDataStoreRepository, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.ChatMeUpDatabase chatMeUpDatabase, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.AppTaskManager appTaskManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMyUserId() {
        return null;
    }
    
    public final void setMyUserId(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.android.chatmeup.AppTaskManager getAppTaskManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeEventState> getHomeEventState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.ui.screens.homescreen.viewmodel.AddContactEventState> getAddContactEventState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MediatorLiveData<java.util.List<com.android.chatmeup.data.db.firebase_db.entity.UserInfo>> getNotificationListWithUserInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CoroutineScope getIoScope() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.HomeViewState> getViewState() {
        return null;
    }
    
    @java.lang.Override
    protected void onCleared() {
    }
    
    private final kotlinx.coroutines.Job loadUserID() {
        return null;
    }
    
    private final void updateNotification(com.android.chatmeup.data.db.firebase_db.entity.UserInfo otherUserInfo, boolean removeOnly) {
    }
    
    public final void acceptNotificationPressed(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.UserInfo userInfo) {
    }
    
    public final void declineNotificationPressed(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.entity.UserInfo userInfo) {
    }
    
    private final void loadUserInfo(com.android.chatmeup.data.db.firebase_db.entity.UserNotification userNotification) {
    }
    
    private final void loadAndObserveNotifications() {
    }
    
    public final void onAddContactEventTriggered(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.AddContactEvents event, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    java.lang.String errorMsg, @org.jetbrains.annotations.NotNull
    java.lang.String email) {
    }
    
    @androidx.annotation.WorkerThread
    private final void sendFriendRequest(android.content.Context context, android.app.Activity activity, java.lang.String email) {
    }
    
    public final void logout(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$HomeViewState;", "", "myContact", "Lcom/android/chatmeup/data/db/room_db/entity/RoomContact;", "chatsList", "", "Lcom/android/chatmeup/data/db/room_db/entity/RoomChat;", "(Lcom/android/chatmeup/data/db/room_db/entity/RoomContact;Ljava/util/List;)V", "getChatsList", "()Ljava/util/List;", "getMyContact", "()Lcom/android/chatmeup/data/db/room_db/entity/RoomContact;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class HomeViewState {
        @org.jetbrains.annotations.NotNull
        private final com.android.chatmeup.data.db.room_db.entity.RoomContact myContact = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomChat> chatsList = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.HomeViewState copy(@org.jetbrains.annotations.NotNull
        com.android.chatmeup.data.db.room_db.entity.RoomContact myContact, @org.jetbrains.annotations.NotNull
        java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomChat> chatsList) {
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
        
        public HomeViewState() {
            super();
        }
        
        public HomeViewState(@org.jetbrains.annotations.NotNull
        com.android.chatmeup.data.db.room_db.entity.RoomContact myContact, @org.jetbrains.annotations.NotNull
        java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomChat> chatsList) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.android.chatmeup.data.db.room_db.entity.RoomContact component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.android.chatmeup.data.db.room_db.entity.RoomContact getMyContact() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomChat> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomChat> getChatsList() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$HomeEvents;", "", "()V", "ChatListEvent", "ContactListEvent", "MoreEvent", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$HomeEvents$ChatListEvent;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$HomeEvents$ContactListEvent;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$HomeEvents$MoreEvent;", "app_debug"})
    public static abstract class HomeEvents {
        
        private HomeEvents() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$HomeEvents$ChatListEvent;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$HomeEvents;", "()V", "app_debug"})
        public static final class ChatListEvent extends com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.HomeEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.HomeEvents.ChatListEvent INSTANCE = null;
            
            private ChatListEvent() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$HomeEvents$ContactListEvent;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$HomeEvents;", "()V", "app_debug"})
        public static final class ContactListEvent extends com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.HomeEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.HomeEvents.ContactListEvent INSTANCE = null;
            
            private ContactListEvent() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$HomeEvents$MoreEvent;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$HomeEvents;", "()V", "app_debug"})
        public static final class MoreEvent extends com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.HomeEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.HomeEvents.MoreEvent INSTANCE = null;
            
            private MoreEvent() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents;", "", "()V", "DoNothing", "Error", "Loading", "Success", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents$DoNothing;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents$Error;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents$Loading;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents$Success;", "app_debug"})
    public static abstract class AddContactEvents {
        
        private AddContactEvents() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents$DoNothing;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents;", "()V", "app_debug"})
        public static final class DoNothing extends com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.AddContactEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.AddContactEvents.DoNothing INSTANCE = null;
            
            private DoNothing() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents$Loading;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents;", "()V", "app_debug"})
        public static final class Loading extends com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.AddContactEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.AddContactEvents.Loading INSTANCE = null;
            
            private Loading() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents$Success;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents;", "()V", "app_debug"})
        public static final class Success extends com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.AddContactEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.AddContactEvents.Success INSTANCE = null;
            
            private Success() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents$Error;", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$AddContactEvents;", "()V", "app_debug"})
        public static final class Error extends com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.AddContactEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.AddContactEvents.Error INSTANCE = null;
            
            private Error() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$Factory;", "", "create", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel;", "myUserId", "", "app_debug"})
    @dagger.assisted.AssistedFactory
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull
        public abstract com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel create(@org.jetbrains.annotations.NotNull
        @dagger.assisted.Assisted(value = "myUserId")
        java.lang.String myUserId);
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$Companion;", "", "()V", "provideFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "assistedFactory", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel$Factory;", "myUserId", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.lifecycle.ViewModelProvider.Factory provideFactory(@org.jetbrains.annotations.NotNull
        com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel.Factory assistedFactory, @org.jetbrains.annotations.NotNull
        java.lang.String myUserId) {
            return null;
        }
    }
}