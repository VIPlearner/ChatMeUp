package com.android.chatmeup.ui.screens.registeruserscreen;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u000256B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJJ\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001a0)H\u0002J\b\u0010*\u001a\u00020+H\u0002Jn\u0010,\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\u0006\u0010-\u001a\u00020.2\b\b\u0002\u0010 \u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u00172\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010\u001f\u001a\u00020\u00172\b\b\u0002\u0010/\u001a\u00020\u00172\b\b\u0002\u00100\u001a\u00020\u00172\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001a0)J\u0016\u00101\u001a\u00020\u001a2\u0006\u0010-\u001a\u0002022\u0006\u0010\"\u001a\u00020#J\u0010\u00103\u001a\u00020+2\u0006\u00104\u001a\u00020\u0017H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel;", "Lcom/android/chatmeup/ui/DefaultViewModel;", "cmuDataStoreRepository", "Lcom/android/chatmeup/data/datastore/CmuDataStoreRepository;", "(Lcom/android/chatmeup/data/datastore/CmuDataStoreRepository;)V", "_profilePictureEventStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/ProfilePictureStatus;", "_registerUserEventStatus", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserStatus;", "authRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/AuthRepository;", "dbRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/DatabaseRepository;", "profilePictureStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getProfilePictureStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "registerUserEventStatus", "getRegisterUserEventStatus", "storageRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/StorageRepository;", "tag", "", "token", "changeUserImage", "", "userID", "byteArray", "", "createUser", "displayName", "email", "password", "imageUri", "Landroid/net/Uri;", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "onRegisterUser", "Lkotlin/Function0;", "loadToken", "Lkotlinx/coroutines/Job;", "onEventTriggered", "event", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents;", "myUserId", "errorMessage", "onProfilePictureEventTriggered", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents;", "saveUserId", "value", "ProfilePictureEvents", "RegisterUserEvents", "app_debug"})
public final class RegisterUserScreenViewModel extends com.android.chatmeup.ui.DefaultViewModel {
    private final com.android.chatmeup.data.datastore.CmuDataStoreRepository cmuDataStoreRepository = null;
    private final java.lang.String tag = "RegisterUserScreenViewModel";
    private final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserStatus> _registerUserEventStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserStatus> registerUserEventStatus = null;
    private java.lang.String token;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.ui.screens.registeruserscreen.ProfilePictureStatus> _profilePictureEventStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.ui.screens.registeruserscreen.ProfilePictureStatus> profilePictureStatus = null;
    private final com.android.chatmeup.data.db.firebase_db.repository.AuthRepository authRepository = null;
    private final com.android.chatmeup.data.db.firebase_db.repository.DatabaseRepository dbRepository = null;
    private final com.android.chatmeup.data.db.firebase_db.repository.StorageRepository storageRepository = null;
    
    @javax.inject.Inject
    public RegisterUserScreenViewModel(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.datastore.CmuDataStoreRepository cmuDataStoreRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserStatus> getRegisterUserEventStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.ui.screens.registeruserscreen.ProfilePictureStatus> getProfilePictureStatus() {
        return null;
    }
    
    public final void onEventTriggered(@org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.RegisterUserEvents event, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.Nullable
    android.net.Uri imageUri, @org.jetbrains.annotations.NotNull
    java.lang.String displayName, @org.jetbrains.annotations.NotNull
    java.lang.String myUserId, @org.jetbrains.annotations.NotNull
    java.lang.String errorMessage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onRegisterUser) {
    }
    
    public final void onProfilePictureEventTriggered(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.ProfilePictureEvents event, @org.jetbrains.annotations.NotNull
    android.net.Uri imageUri) {
    }
    
    public final void changeUserImage(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    byte[] byteArray) {
    }
    
    private final void createUser(java.lang.String displayName, java.lang.String email, java.lang.String password, android.net.Uri imageUri, android.app.Activity activity, android.content.Context context, kotlin.jvm.functions.Function0<kotlin.Unit> onRegisterUser) {
    }
    
    private final kotlinx.coroutines.Job saveUserId(java.lang.String value) {
        return null;
    }
    
    private final kotlinx.coroutines.Job loadToken() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents;", "", "()V", "DoneEvent", "ErrorEvent", "InitRegisterUserEvent", "LoadingEvent", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents$DoneEvent;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents$ErrorEvent;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents$InitRegisterUserEvent;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents$LoadingEvent;", "app_debug"})
    public static abstract class RegisterUserEvents {
        
        private RegisterUserEvents() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents$InitRegisterUserEvent;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents;", "()V", "app_debug"})
        public static final class InitRegisterUserEvent extends com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.RegisterUserEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.RegisterUserEvents.InitRegisterUserEvent INSTANCE = null;
            
            private InitRegisterUserEvent() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents$LoadingEvent;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents;", "()V", "app_debug"})
        public static final class LoadingEvent extends com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.RegisterUserEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.RegisterUserEvents.LoadingEvent INSTANCE = null;
            
            private LoadingEvent() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents$ErrorEvent;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents;", "()V", "app_debug"})
        public static final class ErrorEvent extends com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.RegisterUserEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.RegisterUserEvents.ErrorEvent INSTANCE = null;
            
            private ErrorEvent() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents$DoneEvent;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$RegisterUserEvents;", "()V", "app_debug"})
        public static final class DoneEvent extends com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.RegisterUserEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.RegisterUserEvents.DoneEvent INSTANCE = null;
            
            private DoneEvent() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents;", "", "()V", "DoneEvent", "ErrorEvent", "Init", "LoadingEvent", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents$DoneEvent;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents$ErrorEvent;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents$Init;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents$LoadingEvent;", "app_debug"})
    public static abstract class ProfilePictureEvents {
        
        private ProfilePictureEvents() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents$Init;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents;", "()V", "app_debug"})
        public static final class Init extends com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.ProfilePictureEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.ProfilePictureEvents.Init INSTANCE = null;
            
            private Init() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents$LoadingEvent;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents;", "()V", "app_debug"})
        public static final class LoadingEvent extends com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.ProfilePictureEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.ProfilePictureEvents.LoadingEvent INSTANCE = null;
            
            private LoadingEvent() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents$ErrorEvent;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents;", "()V", "app_debug"})
        public static final class ErrorEvent extends com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.ProfilePictureEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.ProfilePictureEvents.ErrorEvent INSTANCE = null;
            
            private ErrorEvent() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents$DoneEvent;", "Lcom/android/chatmeup/ui/screens/registeruserscreen/RegisterUserScreenViewModel$ProfilePictureEvents;", "()V", "app_debug"})
        public static final class DoneEvent extends com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.ProfilePictureEvents {
            @org.jetbrains.annotations.NotNull
            public static final com.android.chatmeup.ui.screens.registeruserscreen.RegisterUserScreenViewModel.ProfilePictureEvents.DoneEvent INSTANCE = null;
            
            private DoneEvent() {
                super();
            }
        }
    }
}