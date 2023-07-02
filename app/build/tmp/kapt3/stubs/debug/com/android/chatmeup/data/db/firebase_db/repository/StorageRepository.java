package com.android.chatmeup.data.db.firebase_db.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00060\fJ8\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00060\fJ8\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\r\u0012\u0004\u0012\u00020\u00060\fJ0\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00182\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\r\u0012\u0004\u0012\u00020\u00060\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/repository/StorageRepository;", "", "()V", "firebaseStorageService", "Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseStorageSource;", "downloadChatImage", "", "url", "", "file", "Ljava/io/File;", "b", "Lkotlin/Function1;", "Lcom/android/chatmeup/data/Result;", "", "downloadChatThumbnail", "context", "Landroid/content/Context;", "path", "downloadImage", "updateUserProfileImage", "userID", "byteArray", "", "Landroid/net/Uri;", "uploadChatImage", "chatID", "uploadChatThumbnail", "uploadFile", "uri", "app_debug"})
public final class StorageRepository {
    private final com.android.chatmeup.data.db.firebase_db.remote.FirebaseStorageSource firebaseStorageService = null;
    
    public StorageRepository() {
        super();
    }
    
    public final void updateUserProfileImage(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    byte[] byteArray, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends android.net.Uri>, kotlin.Unit> b) {
    }
    
    public final void uploadChatImage(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    byte[] byteArray, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends android.net.Uri>, kotlin.Unit> b) {
    }
    
    public final void uploadFile(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    android.net.Uri uri, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends android.net.Uri>, kotlin.Unit> b) {
    }
    
    public final void uploadChatThumbnail(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    byte[] byteArray, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends android.net.Uri>, kotlin.Unit> b) {
    }
    
    public final void downloadChatImage(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    java.io.File file, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result, kotlin.Unit> b) {
    }
    
    public final void downloadChatThumbnail(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result, kotlin.Unit> b) {
    }
    
    public final void downloadImage(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result, kotlin.Unit> b) {
    }
}