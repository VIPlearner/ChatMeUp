package com.android.chatmeup.ui.screens.chat.views;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u001a4\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\u0084\u0002\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\"\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0\"j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#`$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010&2\u0012\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001aP\u0010)\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010.\u001a\u00020\u0003H\u0007\u001a&\u0010/\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001ad\u00100\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u00132\b\u00103\u001a\u0004\u0018\u00010#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010&2\u0012\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010&H\u0007\u00a8\u00064"}, d2 = {"ChatBottomBar", "", "messageText", "", "viewModel", "Lcom/android/chatmeup/ui/screens/chat/viewmodel/ChatViewModel;", "onAddItemClicked", "Lkotlin/Function0;", "onSendMessagePressed", "ChatListScreen", "onTakePicture", "onUploadFromStorageClicked", "otherUserRoomContact", "Lcom/android/chatmeup/data/db/room_db/entity/RoomContact;", "onBackClicked", "newMessageText", "otherUser", "roomMessageList", "", "Lcom/android/chatmeup/data/db/room_db/entity/RoomMessage;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "userId", "modalBottomSheetState", "Landroidx/compose/material/ModalBottomSheetState;", "currentBottomScreen", "Lcom/android/chatmeup/ui/screens/chat/views/ChatBottomSheetScreen;", "newPhotoUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "chatMediaListMap", "Ljava/util/HashMap;", "Lcom/android/chatmeup/data/DownloadState;", "Lkotlin/collections/HashMap;", "onDeleteMessage", "Lkotlin/Function1;", "onClickViewImage", "onCloseImagePage", "ChatScreen", "factory", "Lcom/android/chatmeup/ui/screens/chat/viewmodel/ChatViewModel$Factory;", "chatId", "otherUserId", "noOfUnreadMessages", "ChatTopBar", "MessageItem", "myUserId", "roomMessage", "downloadState", "app_debug"})
public final class ChatScreenKt {
    
    @androidx.compose.runtime.Composable
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @kotlin.OptIn(markerClass = {androidx.compose.material.ExperimentalMaterialApi.class})
    public static final void ChatScreen(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel.Factory factory, @org.jetbrains.annotations.NotNull
    java.lang.String chatId, @org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String otherUserId, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClicked, @org.jetbrains.annotations.NotNull
    java.lang.String noOfUnreadMessages) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material.ExperimentalMaterialApi.class})
    public static final void ChatListScreen(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onTakePicture, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onUploadFromStorageClicked, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.entity.RoomContact otherUserRoomContact, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClicked, @org.jetbrains.annotations.NotNull
    java.lang.String newMessageText, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel viewModel, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.entity.RoomContact otherUser, @org.jetbrains.annotations.NotNull
    java.util.List<com.android.chatmeup.data.db.room_db.entity.RoomMessage> roomMessageList, @org.jetbrains.annotations.NotNull
    androidx.compose.foundation.lazy.LazyListState lazyListState, @org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    androidx.compose.material.ModalBottomSheetState modalBottomSheetState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddItemClicked, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.chat.views.ChatBottomSheetScreen currentBottomScreen, @org.jetbrains.annotations.Nullable
    android.net.Uri newPhotoUri, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, com.android.chatmeup.data.DownloadState> chatMediaListMap, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.db.room_db.entity.RoomMessage, kotlin.Unit> onDeleteMessage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.net.Uri, kotlin.Unit> onClickViewImage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onCloseImagePage) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    public static final void MessageItem(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel viewModel, @org.jetbrains.annotations.NotNull
    java.lang.String myUserId, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.entity.RoomMessage roomMessage, @org.jetbrains.annotations.Nullable
    com.android.chatmeup.data.DownloadState downloadState, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.db.room_db.entity.RoomMessage, kotlin.Unit> onDeleteMessage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.net.Uri, kotlin.Unit> onClickViewImage) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ChatTopBar(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.entity.RoomContact otherUserRoomContact, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClicked) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ChatBottomBar(@org.jetbrains.annotations.NotNull
    java.lang.String messageText, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddItemClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSendMessagePressed) {
    }
}