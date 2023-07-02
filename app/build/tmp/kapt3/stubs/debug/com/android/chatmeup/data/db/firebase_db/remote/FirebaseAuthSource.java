package com.android.chatmeup.data.db.firebase_db.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006H\u0002J(\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\t\u00a8\u0006\u0016"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseAuthSource;", "", "()V", "attachAuthObserver", "Lcom/google/firebase/auth/FirebaseAuth$AuthStateListener;", "b", "Lkotlin/Function1;", "Lcom/android/chatmeup/data/Result;", "Lcom/google/firebase/auth/FirebaseUser;", "", "attachAuthStateObserver", "firebaseAuthStateObserver", "Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseAuthStateObserver;", "createUser", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/auth/AuthResult;", "Lcom/fredrikbogg/android_chat_app/data/model/CreateUser;", "loginWithEmailAndPassword", "login", "Lcom/fredrikbogg/android_chat_app/data/model/Login;", "logout", "Companion", "app_debug"})
public final class FirebaseAuthSource {
    @org.jetbrains.annotations.NotNull
    public static final com.android.chatmeup.data.db.firebase_db.remote.FirebaseAuthSource.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    private static final com.google.firebase.auth.FirebaseAuth authInstance = null;
    
    public FirebaseAuthSource() {
        super();
    }
    
    private final com.google.firebase.auth.FirebaseAuth.AuthStateListener attachAuthObserver(kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends com.google.firebase.auth.FirebaseUser>, kotlin.Unit> b) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult> loginWithEmailAndPassword(@org.jetbrains.annotations.NotNull
    com.fredrikbogg.android_chat_app.data.model.Login login) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult> createUser(@org.jetbrains.annotations.NotNull
    com.fredrikbogg.android_chat_app.data.model.CreateUser createUser) {
        return null;
    }
    
    public final void logout() {
    }
    
    public final void attachAuthStateObserver(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseAuthStateObserver firebaseAuthStateObserver, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends com.google.firebase.auth.FirebaseUser>, kotlin.Unit> b) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseAuthSource$Companion;", "", "()V", "authInstance", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuthInstance", "()Lcom/google/firebase/auth/FirebaseAuth;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.auth.FirebaseAuth getAuthInstance() {
            return null;
        }
    }
}