package com.android.chatmeup.ui.screens.editprofile.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001aJ\u000e\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u001aJ \u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u001e*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/android/chatmeup/ui/screens/editprofile/viewmodel/EditProfileViewModel;", "Lcom/android/chatmeup/ui/DefaultViewModel;", "chatMeUpDatabase", "Lcom/android/chatmeup/data/db/room_db/ChatMeUpDatabase;", "appTaskManager", "Lcom/android/chatmeup/AppTaskManager;", "(Lcom/android/chatmeup/data/db/room_db/ChatMeUpDatabase;Lcom/android/chatmeup/AppTaskManager;)V", "_eventState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/android/chatmeup/ui/screens/editprofile/viewmodel/EditProfileState;", "_isUpdatingProfileImage", "", "dbRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/DatabaseRepository;", "eventState", "Lkotlinx/coroutines/flow/StateFlow;", "getEventState", "()Lkotlinx/coroutines/flow/StateFlow;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "isUpdatingProfileImage", "myRoomContact", "Lcom/android/chatmeup/data/db/room_db/entity/RoomContact;", "getMyRoomContact", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "myUserID", "", "storageRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/StorageRepository;", "tag", "kotlin.jvm.PlatformType", "initialize", "", "updateAbout", "aboutStr", "updateDisplayName", "displayName", "updateProfileImage", "Lkotlinx/coroutines/Job;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "imageUri", "Landroid/net/Uri;", "app_debug"})
public final class EditProfileViewModel extends com.android.chatmeup.ui.DefaultViewModel {
    private final com.android.chatmeup.data.db.room_db.ChatMeUpDatabase chatMeUpDatabase = null;
    private final com.android.chatmeup.AppTaskManager appTaskManager = null;
    private final java.lang.String tag = null;
    private final kotlinx.coroutines.CoroutineScope ioScope = null;
    private final com.android.chatmeup.data.db.firebase_db.repository.DatabaseRepository dbRepository = null;
    private final com.android.chatmeup.data.db.firebase_db.repository.StorageRepository storageRepository = null;
    private final java.lang.String myUserID = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.ui.screens.editprofile.viewmodel.EditProfileState> _eventState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.ui.screens.editprofile.viewmodel.EditProfileState> eventState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isUpdatingProfileImage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isUpdatingProfileImage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.data.db.room_db.entity.RoomContact> myRoomContact = null;
    
    @javax.inject.Inject
    public EditProfileViewModel(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.ChatMeUpDatabase chatMeUpDatabase, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.AppTaskManager appTaskManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.android.chatmeup.ui.screens.editprofile.viewmodel.EditProfileState> getEventState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isUpdatingProfileImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<com.android.chatmeup.data.db.room_db.entity.RoomContact> getMyRoomContact() {
        return null;
    }
    
    public final void initialize() {
    }
    
    public final void updateDisplayName(@org.jetbrains.annotations.NotNull
    java.lang.String displayName) {
    }
    
    public final void updateAbout(@org.jetbrains.annotations.NotNull
    java.lang.String aboutStr) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job updateProfileImage(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity, @org.jetbrains.annotations.NotNull
    android.net.Uri imageUri) {
        return null;
    }
}