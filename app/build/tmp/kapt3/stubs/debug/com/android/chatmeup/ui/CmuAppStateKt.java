package com.android.chatmeup.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002\u00a8\u0006\u000b"}, d2 = {"rememberChatMeUpAppState", "Lcom/android/chatmeup/ui/CmuAppState;", "navController", "Landroidx/navigation/NavHostController;", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "lifecycleIsResumed", "", "Landroidx/navigation/NavBackStackEntry;", "app_debug"})
public final class CmuAppStateKt {
    
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    public static final com.android.chatmeup.ui.CmuAppState rememberChatMeUpAppState(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.app.Activity activity) {
        return null;
    }
    
    /**
     * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
     *
     * This is used to de-duplicate navigation events.
     */
    private static final boolean lifecycleIsResumed(androidx.navigation.NavBackStackEntry $this$lifecycleIsResumed) {
        return false;
    }
}