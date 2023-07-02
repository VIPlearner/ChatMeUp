package com.android.chatmeup.ui.screens.chat.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 V2\u00020\u0001:\u0004UVWXB=\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020CH\u0002J(\u0010H\u001a\u00020C2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003J\b\u0010O\u001a\u00020CH\u0014J*\u0010P\u001a\u00020C2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\u0003J\b\u0010T\u001a\u00020CH\u0002R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0!\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u00120\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00150\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u000e\u0010/\u001a\u000200X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u001a\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000209080\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010*R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010>\u001a\n ?*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010&\u00a8\u0006Y"}, d2 = {"Lcom/android/chatmeup/ui/screens/chat/viewmodel/ChatViewModel;", "Lcom/android/chatmeup/ui/DefaultViewModel;", "chatID", "", "myUserID", "otherUserID", "cmuDataStoreRepository", "Lcom/android/chatmeup/data/datastore/CmuDataStoreRepository;", "chatMeUpDatabase", "Lcom/android/chatmeup/data/db/room_db/ChatMeUpDatabase;", "appTaskManager", "Lcom/android/chatmeup/AppTaskManager;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/chatmeup/data/datastore/CmuDataStoreRepository;Lcom/android/chatmeup/data/db/room_db/ChatMeUpDatabase;Lcom/android/chatmeup/AppTaskManager;)V", "_chatInfo", "Landroidx/lifecycle/MutableLiveData;", "Lcom/android/chatmeup/data/db/firebase_db/entity/ChatInfo;", "_chatMediaListMap", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/util/HashMap;", "Lcom/android/chatmeup/data/DownloadState;", "_downloadInProgress", "", "_downloadQueue", "Ljava/util/Queue;", "Lcom/android/chatmeup/ui/screens/chat/viewmodel/ChatViewModel$DownloadQueueData;", "_otherUser", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/android/chatmeup/data/db/room_db/entity/RoomContact;", "_viewState", "Lcom/android/chatmeup/ui/screens/chat/viewmodel/ChatViewModel$ChatViewState;", "getAppTaskManager", "()Lcom/android/chatmeup/AppTaskManager;", "chatInfo", "Landroidx/lifecycle/LiveData;", "getChatInfo", "()Landroidx/lifecycle/LiveData;", "chatMediaListMap", "getChatMediaListMap", "()Lkotlinx/coroutines/flow/StateFlow;", "chatState", "Lcom/android/chatmeup/ui/screens/chat/data/ChatState;", "getChatState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "dbRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/DatabaseRepository;", "downloadInProgress", "getDownloadInProgress", "fbRefChatInfoObserver", "Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseReferenceValueObserver;", "fbRefUserInfoObserver", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "getLazyListState", "messagesList", "", "Lcom/android/chatmeup/data/db/room_db/entity/RoomMessage;", "newMessageText", "getNewMessageText", "storageRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/StorageRepository;", "tag", "kotlin.jvm.PlatformType", "viewState", "getViewState", "checkAndUpdateLastMessageSeen", "", "checkAndUpdateUnreadMessages", "message", "Lcom/android/chatmeup/data/db/firebase_db/entity/Message;", "loadChatFromDb", "loadImage", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "imageUrl", "messageID", "onCleared", "sendMessagePressed", "newPhotoURI", "Landroid/net/Uri;", "messageText", "setupChat", "ChatViewState", "Companion", "DownloadQueueData", "Factory", "app_debug"})
public final class ChatViewModel extends com.android.chatmeup.ui.DefaultViewModel {
    private final java.lang.String chatID = null;
    private final java.lang.String myUserID = null;
    private final java.lang.String otherUserID = null;
    private final com.android.chatmeup.data.datastore.CmuDataStoreRepository cmuDataStoreRepository = null;
    private final com.android.chatmeup.data.db.room_db.ChatMeUpDatabase chatMeUpDatabase = null;
    @org.jetbrains.annotations.NotNull
    private final com.android.chatmeup.AppTaskManager appTaskManager = null;
    private final java.lang.String tag = null;
    private final com.android.chatmeup.data.db.firebase_db.repository.DatabaseRepository dbRepository = null;
    private final com.android.chatmeup.data.db.firebase_db.repository.StorageRepository storageRepository = null;
    private final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.data.db.room_db.entity.RoomContact> _otherUser = null;
    private final androidx.lifecycle.MutableLiveData<com.android.chatmeup.data.db.firebase_db.entity.ChatInfo> _chatInfo = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel.ChatViewState> _viewState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.HashMap<java.lang.String, com.android.chatmeup.data.DownloadState>> _chatMediaListMap = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Queue<com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel.DownloadQueueData>> _downloadQueue = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _downloadInProgress = null;
    private final com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver fbRefUserInfoObserver = null;
    private final com.android.chatmeup.data.db.firebase_db.remote.FirebaseReferenceValueObserver fbRefChatInfoObserver = null;
    private kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomMessage>> messagesList;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> newMessageText = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.android.chatmeup.data.db.firebase_db.entity.ChatInfo> chatInfo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.ui.screens.chat.data.ChatState> chatState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.HashMap<java.lang.String, com.android.chatmeup.data.DownloadState>> chatMediaListMap = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> downloadInProgress = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel.ChatViewState> viewState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<androidx.compose.foundation.lazy.LazyListState> lazyListState = null;
    private final kotlinx.coroutines.CoroutineScope ioScope = null;
    @org.jetbrains.annotations.NotNull
    public static final com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel.Companion Companion = null;
    
    @dagger.assisted.AssistedInject
    public ChatViewModel(@org.jetbrains.annotations.NotNull
    @dagger.assisted.Assisted(value = "chatId")
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    @dagger.assisted.Assisted(value = "myUserId")
    java.lang.String myUserID, @org.jetbrains.annotations.NotNull
    @dagger.assisted.Assisted(value = "otherUserId")
    java.lang.String otherUserID, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.datastore.CmuDataStoreRepository cmuDataStoreRepository, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.ChatMeUpDatabase chatMeUpDatabase, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.AppTaskManager appTaskManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.android.chatmeup.AppTaskManager getAppTaskManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getNewMessageText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.android.chatmeup.data.db.firebase_db.entity.ChatInfo> getChatInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.ui.screens.chat.data.ChatState> getChatState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.HashMap<java.lang.String, com.android.chatmeup.data.DownloadState>> getChatMediaListMap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getDownloadInProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel.ChatViewState> getViewState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<androidx.compose.foundation.lazy.LazyListState> getLazyListState() {
        return null;
    }
    
    @java.lang.Override
    protected void onCleared() {
    }
    
    private final void checkAndUpdateLastMessageSeen() {
    }
    
    private final void checkAndUpdateUnreadMessages(com.android.chatmeup.data.db.firebase_db.entity.Message message) {
    }
    
    private final void setupChat() {
    }
    
    private final void loadChatFromDb() {
    }
    
    public final void sendMessagePressed(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.Nullable
    android.net.Uri newPhotoURI, @org.jetbrains.annotations.NotNull
    java.lang.String messageText) {
    }
    
    public final void loadImage(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull
    java.lang.String messageID) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J#\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/android/chatmeup/ui/screens/chat/viewmodel/ChatViewModel$ChatViewState;", "", "roomMessageList", "", "Lcom/android/chatmeup/data/db/room_db/entity/RoomMessage;", "roomContact", "Lcom/android/chatmeup/data/db/room_db/entity/RoomContact;", "(Ljava/util/List;Lcom/android/chatmeup/data/db/room_db/entity/RoomContact;)V", "getRoomContact", "()Lcom/android/chatmeup/data/db/room_db/entity/RoomContact;", "setRoomContact", "(Lcom/android/chatmeup/data/db/room_db/entity/RoomContact;)V", "getRoomMessageList", "()Ljava/util/List;", "setRoomMessageList", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class ChatViewState {
        @org.jetbrains.annotations.NotNull
        private java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomMessage> roomMessageList;
        @org.jetbrains.annotations.NotNull
        private com.android.chatmeup.data.db.room_db.entity.RoomContact roomContact;
        
        @org.jetbrains.annotations.NotNull
        public final com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel.ChatViewState copy(@org.jetbrains.annotations.NotNull
        java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomMessage> roomMessageList, @org.jetbrains.annotations.NotNull
        com.android.chatmeup.data.db.room_db.entity.RoomContact roomContact) {
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
        
        public ChatViewState() {
            super();
        }
        
        public ChatViewState(@org.jetbrains.annotations.NotNull
        java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomMessage> roomMessageList, @org.jetbrains.annotations.NotNull
        com.android.chatmeup.data.db.room_db.entity.RoomContact roomContact) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomMessage> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomMessage> getRoomMessageList() {
            return null;
        }
        
        public final void setRoomMessageList(@org.jetbrains.annotations.NotNull
        java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomMessage> p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.android.chatmeup.data.db.room_db.entity.RoomContact component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.android.chatmeup.data.db.room_db.entity.RoomContact getRoomContact() {
            return null;
        }
        
        public final void setRoomContact(@org.jetbrains.annotations.NotNull
        com.android.chatmeup.data.db.room_db.entity.RoomContact p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/android/chatmeup/ui/screens/chat/viewmodel/ChatViewModel$DownloadQueueData;", "", "imageUrl", "", "messageID", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getMessageID", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class DownloadQueueData {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String imageUrl = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String messageID = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel.DownloadQueueData copy(@org.jetbrains.annotations.NotNull
        java.lang.String imageUrl, @org.jetbrains.annotations.NotNull
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
        
        public DownloadQueueData(@org.jetbrains.annotations.NotNull
        java.lang.String imageUrl, @org.jetbrains.annotations.NotNull
        java.lang.String messageID) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getImageUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getMessageID() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/android/chatmeup/ui/screens/chat/viewmodel/ChatViewModel$Factory;", "", "create", "Lcom/android/chatmeup/ui/screens/chat/viewmodel/ChatViewModel;", "chatId", "", "myUserId", "otherUserId", "app_debug"})
    @dagger.assisted.AssistedFactory
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull
        public abstract com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel create(@org.jetbrains.annotations.NotNull
        @dagger.assisted.Assisted(value = "chatId")
        java.lang.String chatId, @org.jetbrains.annotations.NotNull
        @dagger.assisted.Assisted(value = "myUserId")
        java.lang.String myUserId, @org.jetbrains.annotations.NotNull
        @dagger.assisted.Assisted(value = "otherUserId")
        java.lang.String otherUserId);
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b\u00a8\u0006\u000b"}, d2 = {"Lcom/android/chatmeup/ui/screens/chat/viewmodel/ChatViewModel$Companion;", "", "()V", "provideFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "assistedFactory", "Lcom/android/chatmeup/ui/screens/chat/viewmodel/ChatViewModel$Factory;", "chatId", "", "myUserId", "otherUserId", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.lifecycle.ViewModelProvider.Factory provideFactory(@org.jetbrains.annotations.NotNull
        com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel.Factory assistedFactory, @org.jetbrains.annotations.NotNull
        java.lang.String chatId, @org.jetbrains.annotations.NotNull
        java.lang.String myUserId, @org.jetbrains.annotations.NotNull
        java.lang.String otherUserId) {
            return null;
        }
    }
}