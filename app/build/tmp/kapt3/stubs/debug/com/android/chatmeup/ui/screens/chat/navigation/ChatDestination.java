package com.android.chatmeup.ui.screens.chat.navigation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/android/chatmeup/ui/screens/chat/navigation/ChatDestination;", "Lcom/android/chatmeup/navigation/CmuNavigationDestination;", "()V", "chatDataArg", "", "destination", "getDestination", "()Ljava/lang/String;", "route", "getRoute", "shouldPopStack", "", "getShouldPopStack", "()Z", "createNavigationRoute", "chatArg", "fromNavArgs", "entry", "Landroidx/navigation/NavBackStackEntry;", "app_debug"})
public final class ChatDestination implements com.android.chatmeup.navigation.CmuNavigationDestination {
    @org.jetbrains.annotations.NotNull
    public static final com.android.chatmeup.ui.screens.chat.navigation.ChatDestination INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String chatDataArg = "chatData";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String route = "chat_route/{chatData}";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String destination = "chat_destination";
    private static final boolean shouldPopStack = false;
    
    private ChatDestination() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getDestination() {
        return null;
    }
    
    @java.lang.Override
    public boolean getShouldPopStack() {
        return false;
    }
    
    /**
     * Creates destination route for a chatData that could include special characters
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String createNavigationRoute(@org.jetbrains.annotations.NotNull
    java.lang.String chatArg) {
        return null;
    }
    
    /**
     * Returns the chatData from a [NavBackStackEntry] after a chat_destination navigation call
     */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String fromNavArgs(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavBackStackEntry entry) {
        return null;
    }
}