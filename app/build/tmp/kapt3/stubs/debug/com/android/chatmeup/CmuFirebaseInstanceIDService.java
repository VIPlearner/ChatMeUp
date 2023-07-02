package com.android.chatmeup;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/android/chatmeup/CmuFirebaseInstanceIDService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "dbRepository", "Lcom/android/chatmeup/data/db/firebase_db/repository/DatabaseRepository;", "generateNotification", "", "onMessageReceived", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "onMessageSent", "msgId", "", "onNewToken", "token", "onSendError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Companion", "app_debug"})
public final class CmuFirebaseInstanceIDService extends com.google.firebase.messaging.FirebaseMessagingService {
    private final com.android.chatmeup.data.db.firebase_db.repository.DatabaseRepository dbRepository = null;
    @org.jetbrains.annotations.NotNull
    public static final com.android.chatmeup.CmuFirebaseInstanceIDService.Companion Companion = null;
    private static final java.lang.String tag = null;
    
    public CmuFirebaseInstanceIDService() {
        super();
    }
    
    @java.lang.Override
    public void onNewToken(@org.jetbrains.annotations.NotNull
    java.lang.String token) {
    }
    
    @java.lang.Override
    public void onMessageReceived(@org.jetbrains.annotations.NotNull
    com.google.firebase.messaging.RemoteMessage message) {
    }
    
    @java.lang.Override
    public void onMessageSent(@org.jetbrains.annotations.NotNull
    java.lang.String msgId) {
    }
    
    @java.lang.Override
    public void onSendError(@org.jetbrains.annotations.NotNull
    java.lang.String msgId, @org.jetbrains.annotations.NotNull
    java.lang.Exception exception) {
    }
    
    private final void generateNotification() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/android/chatmeup/CmuFirebaseInstanceIDService$Companion;", "", "()V", "tag", "", "kotlin.jvm.PlatformType", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}