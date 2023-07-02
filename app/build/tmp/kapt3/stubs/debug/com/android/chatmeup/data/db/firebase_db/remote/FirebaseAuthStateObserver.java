package com.android.chatmeup.data.db.firebase_db.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseAuthStateObserver;", "", "()V", "authListener", "Lcom/google/firebase/auth/FirebaseAuth$AuthStateListener;", "instance", "Lcom/google/firebase/auth/FirebaseAuth;", "clear", "", "start", "valueEventListener", "app_debug"})
public final class FirebaseAuthStateObserver {
    private com.google.firebase.auth.FirebaseAuth.AuthStateListener authListener;
    private com.google.firebase.auth.FirebaseAuth instance;
    
    public FirebaseAuthStateObserver() {
        super();
    }
    
    public final void start(@org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth.AuthStateListener valueEventListener, @org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth instance) {
    }
    
    public final void clear() {
    }
}