package com.android.chatmeup;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/android/chatmeup/CmuApplication;", "Landroid/app/Application;", "()V", "mCurrentActivity", "Landroid/app/Activity;", "tag", "", "getCurrentActivity", "onCreate", "", "setCurrentActivity", "app_debug"})
@dagger.hilt.android.HiltAndroidApp
public final class CmuApplication extends android.app.Application {
    private final java.lang.String tag = "ChatMeUp Application";
    private android.app.Activity mCurrentActivity;
    
    public CmuApplication() {
        super();
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.app.Activity getCurrentActivity() {
        return null;
    }
    
    public final void setCurrentActivity(@org.jetbrains.annotations.Nullable
    android.app.Activity mCurrentActivity) {
    }
}