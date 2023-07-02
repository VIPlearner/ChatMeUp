package com.android.chatmeup.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0016H\u0004R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\nX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/android/chatmeup/ui/DefaultViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "dataLoading", "Landroidx/lifecycle/LiveData;", "Lcom/android/chatmeup/data/Event;", "", "getDataLoading", "()Landroidx/lifecycle/LiveData;", "mDataLoading", "Landroidx/lifecycle/MutableLiveData;", "mSnackBarText", "", "getMSnackBarText", "()Landroidx/lifecycle/MutableLiveData;", "snackBarText", "getSnackBarText", "onResult", "", "T", "mutableLiveData", "result", "Lcom/android/chatmeup/data/Result;", "app_debug"})
public abstract class DefaultViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.android.chatmeup.data.Event<java.lang.String>> mSnackBarText = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.android.chatmeup.data.Event<java.lang.String>> snackBarText = null;
    private final androidx.lifecycle.MutableLiveData<com.android.chatmeup.data.Event<java.lang.Boolean>> mDataLoading = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.android.chatmeup.data.Event<java.lang.Boolean>> dataLoading = null;
    
    public DefaultViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    protected final androidx.lifecycle.MutableLiveData<com.android.chatmeup.data.Event<java.lang.String>> getMSnackBarText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.android.chatmeup.data.Event<java.lang.String>> getSnackBarText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.android.chatmeup.data.Event<java.lang.Boolean>> getDataLoading() {
        return null;
    }
    
    protected final <T extends java.lang.Object>void onResult(@org.jetbrains.annotations.Nullable
    androidx.lifecycle.MutableLiveData<T> mutableLiveData, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.Result<? extends T> result) {
    }
}