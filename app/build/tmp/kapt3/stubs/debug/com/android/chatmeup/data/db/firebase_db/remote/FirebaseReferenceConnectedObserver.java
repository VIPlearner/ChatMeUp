package com.android.chatmeup.data.db.firebase_db.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/android/chatmeup/data/db/firebase_db/remote/FirebaseReferenceConnectedObserver;", "", "()V", "dbRef", "Lcom/google/firebase/database/DatabaseReference;", "userRef", "valueEventListener", "Lcom/google/firebase/database/ValueEventListener;", "clear", "", "getEventListener", "userID", "", "start", "app_debug"})
public final class FirebaseReferenceConnectedObserver {
    private com.google.firebase.database.ValueEventListener valueEventListener;
    private com.google.firebase.database.DatabaseReference dbRef;
    private com.google.firebase.database.DatabaseReference userRef;
    
    public FirebaseReferenceConnectedObserver() {
        super();
    }
    
    public final void start(@org.jetbrains.annotations.NotNull
    java.lang.String userID) {
    }
    
    private final com.google.firebase.database.ValueEventListener getEventListener(java.lang.String userID) {
        return null;
    }
    
    public final void clear() {
    }
}