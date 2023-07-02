package com.android.chatmeup.ui;

import java.lang.System;

@androidx.compose.runtime.Stable
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u0019\u001a\u00020\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/android/chatmeup/ui/CmuAppState;", "", "navController", "Landroidx/navigation/NavHostController;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "(Landroidx/navigation/NavHostController;Landroid/content/Context;Landroid/app/Activity;)V", "appStateActivity", "getAppStateActivity", "()Landroid/app/Activity;", "appStateContext", "getAppStateContext", "()Landroid/content/Context;", "getNavController", "()Landroidx/navigation/NavHostController;", "navigate", "", "from", "Landroidx/navigation/NavBackStackEntry;", "destination", "Lcom/android/chatmeup/navigation/CmuNavigationDestination;", "route", "", "navigateBack", "app_debug"})
public final class CmuAppState {
    @org.jetbrains.annotations.NotNull
    private final androidx.navigation.NavHostController navController = null;
    private final android.content.Context context = null;
    private final android.app.Activity activity = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context appStateContext = null;
    @org.jetbrains.annotations.Nullable
    private final android.app.Activity appStateActivity = null;
    
    public CmuAppState(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.navigation.NavHostController getNavController() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getAppStateContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.app.Activity getAppStateActivity() {
        return null;
    }
    
    /**
     * UI logic for navigating to a particular destination in the app. The NavigationOptions to
     * navigate with are based on the type of destination, which could be a top level destination or
     * just a regular destination.
     *
     * @param from: Representation of an entry in the back stack of a [androidx.navigation.NavController]
     * @param destination: The [CmuNavigationDestination] the app needs to navigate to.
     * @param route: [String] Optional route to navigate to in case the destination contains arguments.
     */
    public final void navigate(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavBackStackEntry from, @org.jetbrains.annotations.NotNull
    com.android.chatmeup.navigation.CmuNavigationDestination destination, @org.jetbrains.annotations.Nullable
    java.lang.String route) {
    }
    
    public final void navigateBack() {
    }
}