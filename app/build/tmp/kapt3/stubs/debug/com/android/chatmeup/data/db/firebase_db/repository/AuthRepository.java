package com.android.chatmeup.data.db.firebase_db.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00060\tJ(\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00060\tJ\u0006\u0010\u000f\u001a\u00020\u0006J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00060\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/repository/AuthRepository;", "", "()V", "firebaseAuthService", "Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseAuthSource;", "createUser", "", "Lcom/fredrikbogg/android_chat_app/data/model/CreateUser;", "b", "Lkotlin/Function1;", "Lcom/android/chatmeup/data/Result;", "Lcom/google/firebase/auth/FirebaseUser;", "loginUser", "login", "Lcom/fredrikbogg/android_chat_app/data/model/Login;", "logoutUser", "observeAuthState", "stateObserver", "Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseAuthStateObserver;", "app_debug"})
public final class AuthRepository {
    private final com.android.chatmeup.data.db.firebase_db.remote.FirebaseAuthSource firebaseAuthService = null;
    
    public AuthRepository() {
        super();
    }
    
    public final void observeAuthState(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.firebase_db.remote.FirebaseAuthStateObserver stateObserver, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends com.google.firebase.auth.FirebaseUser>, kotlin.Unit> b) {
    }
    
    public final void loginUser(@org.jetbrains.annotations.NotNull
    com.fredrikbogg.android_chat_app.data.model.Login login, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends com.google.firebase.auth.FirebaseUser>, kotlin.Unit> b) {
    }
    
    public final void createUser(@org.jetbrains.annotations.NotNull
    com.fredrikbogg.android_chat_app.data.model.CreateUser createUser, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.android.chatmeup.data.Result<? extends com.google.firebase.auth.FirebaseUser>, kotlin.Unit> b) {
    }
    
    public final void logoutUser() {
    }
}