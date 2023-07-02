package com.android.chatmeup.ui.screens.loginscreen;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 @2\u00020\u0001:\u0003@ABB\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010 \u001a\u00020!H\u0007J(\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0)H\u0002J\"\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0018\u0010.\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010/\u001a\u00020\u000bH\u0002JJ\u00100\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u000bH\u0002J@\u00108\u001a\u00020#2\u0006\u00107\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010\'2\u0006\u0010$\u001a\u00020%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0)H\u0002J\u000e\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<J\u0010\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020\u000bH\u0003J\u0010\u0010?\u001a\u00020!2\u0006\u0010>\u001a\u00020\u000bH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006C"}, d2 = {"Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel;", "Lcom/android/chatmeup/ui/DefaultViewModel;", "cmuDataStoreRepository", "Lcom/android/chatmeup/data/datastore/CmuDataStoreRepository;", "chatMeUpDatabase", "Lcom/android/chatmeup/data/db/room_db/ChatMeUpDatabase;", "appTaskManager", "Lcom/android/chatmeup/AppTaskManager;", "(Lcom/android/chatmeup/data/datastore/CmuDataStoreRepository;Lcom/android/chatmeup/data/db/room_db/ChatMeUpDatabase;Lcom/android/chatmeup/AppTaskManager;)V", "_loadingMsg", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "authRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/AuthRepository;", "dbRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/DatabaseRepository;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "loadingMsg", "Lkotlinx/coroutines/flow/StateFlow;", "getLoadingMsg", "()Lkotlinx/coroutines/flow/StateFlow;", "loginCredentials", "loginEventStatus", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginStatus;", "getLoginEventStatus", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "myUserID", "storageRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/StorageRepository;", "tag", "token", "getLoginCredentials", "Lkotlinx/coroutines/Job;", "loadAllData", "", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "onDataLoaded", "Lkotlin/Function0;", "loadChat", "otherUserID", "roomChat", "Lcom/android/chatmeup/data/db/room_db/entity/RoomChat;", "loadMessages", "chatID", "loadProfileImage", "userID", "profileImageUrl", "displayName", "status", "isMine", "", "email", "login", "password", "onEventTriggered", "event", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents;", "saveLoginCredentials", "value", "saveUserId", "Companion", "Factory", "LoginEvents", "app_debug"})
public final class LoginScreenViewModel extends com.android.chatmeup.ui.DefaultViewModel {
    private final com.android.chatmeup.data.datastore.CmuDataStoreRepository cmuDataStoreRepository = null;
    private final com.android.chatmeup.data.db.room_db.ChatMeUpDatabase chatMeUpDatabase = null;
    private final com.android.chatmeup.AppTaskManager appTaskManager = null;
    private final java.lang.String tag = "LoginScreenViewModel";
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.ui.screens.loginscreen.LoginStatus> loginEventStatus = null;
    private final com.android.chatmeup.data.db.firebase_db.repository.AuthRepository authRepository = null;
    private final com.android.chatmeup.data.db.firebase_db.repository.DatabaseRepository dbRepository = null;
    private final com.android.chatmeup.data.db.firebase_db.repository.StorageRepository storageRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> loginCredentials = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _loadingMsg = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> loadingMsg = null;
    private java.lang.String myUserID;
    private java.lang.String token = "";
    private final kotlinx.coroutines.CoroutineScope ioScope = null;
    @org.jetbrains.annotations.NotNull
    public static final com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.Companion Companion = null;
    
    @javax.inject.Inject
    public LoginScreenViewModel(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.datastore.CmuDataStoreRepository cmuDataStoreRepository, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.ChatMeUpDatabase chatMeUpDatabase, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.AppTaskManager appTaskManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.ui.screens.loginscreen.LoginStatus> getLoginEventStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getLoadingMsg() {
        return null;
    }
    
    public final void onEventTriggered(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents event) {
    }
    
    private final kotlinx.coroutines.Job saveUserId(java.lang.String value) {
        return null;
    }
    
    private final void loadMessages(android.content.Context context, java.lang.String chatID) {
    }
    
    private final void loadChat(android.content.Context context, java.lang.String otherUserID, com.android.chatmeup.data.db.room_db.entity.RoomChat roomChat) {
    }
    
    private final void loadAllData(android.content.Context context, android.app.Activity activity, kotlin.jvm.functions.Function0<kotlin.Unit> onDataLoaded) {
    }
    
    private final void loadProfileImage(android.content.Context context, android.app.Activity activity, java.lang.String userID, java.lang.String profileImageUrl, java.lang.String displayName, java.lang.String status, boolean isMine, java.lang.String email) {
    }
    
    @androidx.annotation.WorkerThread
    private final kotlinx.coroutines.Job saveLoginCredentials(java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.annotation.WorkerThread
    public final kotlinx.coroutines.Job getLoginCredentials() {
        return null;
    }
    
    private final void login(java.lang.String email, java.lang.String password, java.lang.String token, android.app.Activity activity, android.content.Context context, kotlin.jvm.functions.Function0<kotlin.Unit> onDataLoaded) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents;", "", "()V", "DoneEvent", "ErrorEvent", "ErrorLoadingData", "InitLoginEvent", "LoadAllData", "LoadingEvent", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents$DoneEvent;", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents$ErrorEvent;", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents$ErrorLoadingData;", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents$InitLoginEvent;", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents$LoadAllData;", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents$LoadingEvent;", "app_debug"})
    public static abstract class LoginEvents {
        
        private LoginEvents() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents$InitLoginEvent;", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents;", "()V", "app_debug"})
        public static final class InitLoginEvent extends com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents.InitLoginEvent INSTANCE = null;
            
            private InitLoginEvent() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003JC\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012\u00a8\u0006#"}, d2 = {"Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents$LoadingEvent;", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents;", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "email", "", "password", "onDataLoaded", "Lkotlin/Function0;", "", "(Landroid/app/Activity;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getActivity", "()Landroid/app/Activity;", "getContext", "()Landroid/content/Context;", "getEmail", "()Ljava/lang/String;", "getOnDataLoaded", "()Lkotlin/jvm/functions/Function0;", "getPassword", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class LoadingEvent extends com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents {
            @org.jetbrains.annotations.Nullable
            private final android.app.Activity activity = null;
            @org.jetbrains.annotations.NotNull
            private final android.content.Context context = null;
            @org.jetbrains.annotations.NotNull
            private final java.lang.String email = null;
            @org.jetbrains.annotations.NotNull
            private final java.lang.String password = null;
            @org.jetbrains.annotations.NotNull
            private final kotlin.jvm.functions.Function0<kotlin.Unit> onDataLoaded = null;
            
            @org.jetbrains.annotations.NotNull
            public final com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents.LoadingEvent copy(@org.jetbrains.annotations.Nullable
            android.app.Activity activity, @org.jetbrains.annotations.NotNull
            android.content.Context context, @org.jetbrains.annotations.NotNull
            java.lang.String email, @org.jetbrains.annotations.NotNull
            java.lang.String password, @org.jetbrains.annotations.NotNull
            kotlin.jvm.functions.Function0<kotlin.Unit> onDataLoaded) {
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
            
            public LoadingEvent(@org.jetbrains.annotations.Nullable
            android.app.Activity activity, @org.jetbrains.annotations.NotNull
            android.content.Context context, @org.jetbrains.annotations.NotNull
            java.lang.String email, @org.jetbrains.annotations.NotNull
            java.lang.String password, @org.jetbrains.annotations.NotNull
            kotlin.jvm.functions.Function0<kotlin.Unit> onDataLoaded) {
                super();
            }
            
            @org.jetbrains.annotations.Nullable
            public final android.app.Activity component1() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable
            public final android.app.Activity getActivity() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.content.Context component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.content.Context getContext() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component3() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getEmail() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component4() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getPassword() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final kotlin.jvm.functions.Function0<kotlin.Unit> component5() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnDataLoaded() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents$ErrorEvent;", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents;", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "errorMsg", "", "(Landroid/app/Activity;Landroid/content/Context;Ljava/lang/String;)V", "getActivity", "()Landroid/app/Activity;", "getContext", "()Landroid/content/Context;", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class ErrorEvent extends com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents {
            @org.jetbrains.annotations.Nullable
            private final android.app.Activity activity = null;
            @org.jetbrains.annotations.NotNull
            private final android.content.Context context = null;
            @org.jetbrains.annotations.Nullable
            private final java.lang.String errorMsg = null;
            
            @org.jetbrains.annotations.NotNull
            public final com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents.ErrorEvent copy(@org.jetbrains.annotations.Nullable
            android.app.Activity activity, @org.jetbrains.annotations.NotNull
            android.content.Context context, @org.jetbrains.annotations.Nullable
            java.lang.String errorMsg) {
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
            
            public ErrorEvent(@org.jetbrains.annotations.Nullable
            android.app.Activity activity, @org.jetbrains.annotations.NotNull
            android.content.Context context, @org.jetbrains.annotations.Nullable
            java.lang.String errorMsg) {
                super();
            }
            
            @org.jetbrains.annotations.Nullable
            public final android.app.Activity component1() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable
            public final android.app.Activity getActivity() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.content.Context component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.content.Context getContext() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable
            public final java.lang.String component3() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable
            public final java.lang.String getErrorMsg() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents$DoneEvent;", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents;", "myUserId", "", "(Ljava/lang/String;)V", "getMyUserId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class DoneEvent extends com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents {
            @org.jetbrains.annotations.NotNull
            private final java.lang.String myUserId = null;
            
            @org.jetbrains.annotations.NotNull
            public final com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents.DoneEvent copy(@org.jetbrains.annotations.NotNull
            java.lang.String myUserId) {
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
            
            public DoneEvent(@org.jetbrains.annotations.NotNull
            java.lang.String myUserId) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getMyUserId() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents$LoadAllData;", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "onDataLoaded", "Lkotlin/Function0;", "", "(Landroid/content/Context;Landroid/app/Activity;Lkotlin/jvm/functions/Function0;)V", "getActivity", "()Landroid/app/Activity;", "getContext", "()Landroid/content/Context;", "getOnDataLoaded", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class LoadAllData extends com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents {
            @org.jetbrains.annotations.NotNull
            private final android.content.Context context = null;
            @org.jetbrains.annotations.Nullable
            private final android.app.Activity activity = null;
            @org.jetbrains.annotations.NotNull
            private final kotlin.jvm.functions.Function0<kotlin.Unit> onDataLoaded = null;
            
            @org.jetbrains.annotations.NotNull
            public final com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents.LoadAllData copy(@org.jetbrains.annotations.NotNull
            android.content.Context context, @org.jetbrains.annotations.Nullable
            android.app.Activity activity, @org.jetbrains.annotations.NotNull
            kotlin.jvm.functions.Function0<kotlin.Unit> onDataLoaded) {
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
            
            public LoadAllData(@org.jetbrains.annotations.NotNull
            android.content.Context context, @org.jetbrains.annotations.Nullable
            android.app.Activity activity, @org.jetbrains.annotations.NotNull
            kotlin.jvm.functions.Function0<kotlin.Unit> onDataLoaded) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.content.Context component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.content.Context getContext() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable
            public final android.app.Activity component2() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable
            public final android.app.Activity getActivity() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final kotlin.jvm.functions.Function0<kotlin.Unit> component3() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final kotlin.jvm.functions.Function0<kotlin.Unit> getOnDataLoaded() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents$ErrorLoadingData;", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$LoginEvents;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "errorMsg", "", "(Landroid/content/Context;Landroid/app/Activity;Ljava/lang/String;)V", "getActivity", "()Landroid/app/Activity;", "getContext", "()Landroid/content/Context;", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class ErrorLoadingData extends com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents {
            @org.jetbrains.annotations.NotNull
            private final android.content.Context context = null;
            @org.jetbrains.annotations.Nullable
            private final android.app.Activity activity = null;
            @org.jetbrains.annotations.Nullable
            private final java.lang.String errorMsg = null;
            
            @org.jetbrains.annotations.NotNull
            public final com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.LoginEvents.ErrorLoadingData copy(@org.jetbrains.annotations.NotNull
            android.content.Context context, @org.jetbrains.annotations.Nullable
            android.app.Activity activity, @org.jetbrains.annotations.Nullable
            java.lang.String errorMsg) {
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
            
            public ErrorLoadingData(@org.jetbrains.annotations.NotNull
            android.content.Context context, @org.jetbrains.annotations.Nullable
            android.app.Activity activity, @org.jetbrains.annotations.Nullable
            java.lang.String errorMsg) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.content.Context component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.content.Context getContext() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable
            public final android.app.Activity component2() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable
            public final android.app.Activity getActivity() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable
            public final java.lang.String component3() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable
            public final java.lang.String getErrorMsg() {
                return null;
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$Factory;", "", "create", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel;", "cmuDataStoreRepository", "Lcom/android/chatmeup/data/datastore/CmuDataStoreRepository;", "app_debug"})
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull
        public abstract com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel create(@org.jetbrains.annotations.NotNull
        com.android.chatmeup.data.datastore.CmuDataStoreRepository cmuDataStoreRepository);
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$Companion;", "", "()V", "provideFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "assistedFactory", "Lcom/android/chatmeup/ui/screens/loginscreen/LoginScreenViewModel$Factory;", "cmuDataStoreRepository", "Lcom/android/chatmeup/data/datastore/CmuDataStoreRepository;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.lifecycle.ViewModelProvider.Factory provideFactory(@org.jetbrains.annotations.NotNull
        com.android.chatmeup.ui.screens.loginscreen.LoginScreenViewModel.Factory assistedFactory, @org.jetbrains.annotations.NotNull
        com.android.chatmeup.data.datastore.CmuDataStoreRepository cmuDataStoreRepository) {
            return null;
        }
    }
}