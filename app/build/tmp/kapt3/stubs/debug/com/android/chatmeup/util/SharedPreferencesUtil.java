package com.android.chatmeup.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/android/chatmeup/util/SharedPreferencesUtil;", "", "()V", "LOGIN_CREDENTIALS", "", "PACKAGE_NAME", "USER_ID", "getLoginCredentials", "context", "Landroid/content/Context;", "getPrefs", "Landroid/content/SharedPreferences;", "getUserID", "removeLoginCredentials", "", "removeUserID", "saveLoginCredentials", "userID", "saveUserID", "app_debug"})
public final class SharedPreferencesUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.android.chatmeup.util.SharedPreferencesUtil INSTANCE = null;
    private static final java.lang.String PACKAGE_NAME = "com.android.chatmeup";
    private static final java.lang.String LOGIN_CREDENTIALS = "login_credentials";
    private static final java.lang.String USER_ID = "user_id";
    
    private SharedPreferencesUtil() {
        super();
    }
    
    private final android.content.SharedPreferences getPrefs(android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserID(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    public final void saveUserID(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String userID) {
    }
    
    public final void removeUserID(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLoginCredentials(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    public final void saveLoginCredentials(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String userID) {
    }
    
    public final void removeLoginCredentials(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
}