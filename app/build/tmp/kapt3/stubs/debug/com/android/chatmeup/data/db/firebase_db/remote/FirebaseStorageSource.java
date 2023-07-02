package com.android.chatmeup.data.db.firebase_db.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0012J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseStorageSource;", "", "()V", "downloadChatImage", "Lcom/google/firebase/storage/FileDownloadTask;", "url", "", "file", "Ljava/io/File;", "downloadChatThumbnail", "context", "Landroid/content/Context;", "path", "downloadImage", "refToPath", "Lcom/google/firebase/storage/StorageReference;", "uploadChatImage", "Lcom/google/android/gms/tasks/Task;", "Landroid/net/Uri;", "chatID", "bArr", "", "uploadChatThumbnail", "uploadFile", "uri", "uploadUserImage", "userID", "Companion", "app_debug"})
public final class FirebaseStorageSource {
    @org.jetbrains.annotations.NotNull
    public static final com.android.chatmeup.data.db.firebase_db.remote.FirebaseStorageSource.Companion Companion = null;
    private static final com.google.firebase.storage.FirebaseStorage storageInstance = null;
    
    public FirebaseStorageSource() {
        super();
    }
    
    private final com.google.firebase.storage.StorageReference refToPath(java.lang.String path) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<android.net.Uri> uploadFile(@org.jetbrains.annotations.NotNull
    java.lang.String path, @org.jetbrains.annotations.NotNull
    android.net.Uri uri) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<android.net.Uri> uploadUserImage(@org.jetbrains.annotations.NotNull
    java.lang.String userID, @org.jetbrains.annotations.NotNull
    byte[] bArr) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<android.net.Uri> uploadChatImage(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    byte[] bArr) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<android.net.Uri> uploadChatThumbnail(@org.jetbrains.annotations.NotNull
    java.lang.String chatID, @org.jetbrains.annotations.NotNull
    byte[] bArr) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.firebase.storage.FileDownloadTask downloadChatImage(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    java.io.File file) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.firebase.storage.FileDownloadTask downloadChatThumbnail(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String path) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.firebase.storage.FileDownloadTask downloadImage(@org.jetbrains.annotations.NotNull
    java.lang.String url, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String path) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseStorageSource$Companion;", "", "()V", "storageInstance", "Lcom/google/firebase/storage/FirebaseStorage;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}