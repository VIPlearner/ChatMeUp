package com.android.chatmeup.ui.screens.homescreen.components;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007\u001a8\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001af\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\t2\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001a$\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00072\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a,\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00072\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001a\"\u0010&\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0007\u001aM\u0010+\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010,\u001a\u00020\u00072*\b\u0002\u0010-\u001a\u0015\u0012\u0011\b\u0001\u0012\r\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b/0.\"\r\u0012\u0004\u0012\u00020\u00010\u000b\u00a2\u0006\u0002\b/H\u0007\u00a2\u0006\u0002\u00100\u001a\u001e\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0007\u001a\u00a6\u0001\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u0002092\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020<2\u0006\u0010\f\u001a\u00020\r2\u0006\u00102\u001a\u0002032\u000e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\t2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u00a8\u0006>"}, d2 = {"AddContactDialog", "", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "newContactEmail", "", "onNewContactEmailChanged", "Lkotlin/Function1;", "onAddContactClicked", "Lkotlin/Function0;", "addContactEventState", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/AddContactEventState;", "BottomBarItem", "modifier", "Landroidx/compose/ui/Modifier;", "isItem", "", "label", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "onItemClicked", "ChatListItem", "myUserId", "item", "Lcom/android/chatmeup/data/db/room_db/entity/RoomChat;", "onNavigateToChat", "onDeleteChat", "Lkotlin/Function2;", "onProfileImageClicked", "CmuSearchTextField", "searchTextValue", "onSearchTextValueChanged", "ConfirmInfoDialog", "text", "onConfirmLogout", "onDismissLogout", "HomeBottomBar", "scope", "Lkotlinx/coroutines/CoroutineScope;", "pagerState", "Lcom/google/accompanist/pager/PagerState;", "HomeTopBar", "title", "icons", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;[Lkotlin/jvm/functions/Function0;)V", "RequestsList", "viewModel", "Lcom/android/chatmeup/ui/screens/homescreen/viewmodel/HomeViewModel;", "notificationsList", "", "Lcom/android/chatmeup/data/db/firebase_db/entity/UserInfo;", "SheetLayout", "currentScreen", "Lcom/android/chatmeup/ui/screens/homescreen/components/BottomSheetScreen;", "selectedImageTitle", "selectedImageUri", "", "onCloseImage", "app_debug"})
public final class HomeScreenComponentsKt {
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class, androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public static final void ChatListItem(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String myUserId, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.entity.RoomChat item, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigateToChat, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> onDeleteChat, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onProfileImageClicked) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.ui.ExperimentalComposeUiApi.class})
    public static final void CmuSearchTextField(@org.jetbrains.annotations.NotNull
    java.lang.String searchTextValue, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSearchTextValueChanged) {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    public static final void HomeTopBar(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit>... icons) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {com.google.accompanist.pager.ExperimentalPagerApi.class})
    public static final void HomeBottomBar(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull
    com.google.accompanist.pager.PagerState pagerState) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void BottomBarItem(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, boolean isItem, @org.jetbrains.annotations.NotNull
    java.lang.String label, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onItemClicked) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void ConfirmInfoDialog(@org.jetbrains.annotations.NotNull
    java.lang.String text, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onConfirmLogout, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissLogout) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void RequestsList(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel viewModel, @org.jetbrains.annotations.NotNull
    java.util.List<com.android.chatmeup.data.db.firebase_db.entity.UserInfo> notificationsList) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void AddContactDialog(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    java.lang.String newContactEmail, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNewContactEmailChanged, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddContactClicked, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.homescreen.viewmodel.AddContactEventState addContactEventState) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SheetLayout(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.homescreen.components.BottomSheetScreen currentScreen, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    java.lang.String selectedImageTitle, @org.jetbrains.annotations.NotNull
    java.lang.Object selectedImageUri, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.homescreen.viewmodel.AddContactEventState addContactEventState, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel viewModel, @org.jetbrains.annotations.Nullable
    java.util.List<com.android.chatmeup.data.db.firebase_db.entity.UserInfo> notificationsList, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddContactClicked, @org.jetbrains.annotations.NotNull
    java.lang.String newContactEmail, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNewContactEmailChanged, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onCloseImage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onConfirmLogout, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismissLogout) {
    }
}