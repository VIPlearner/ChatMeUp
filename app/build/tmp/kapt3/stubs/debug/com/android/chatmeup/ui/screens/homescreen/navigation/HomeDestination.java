package com.android.chatmeup.ui.screens.homescreen.navigation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/android/chatmeup/ui/screens/homescreen/navigation/HomeDestination;", "Lcom/android/chatmeup/navigation/CmuNavigationDestination;", "()V", "destination", "", "getDestination", "()Ljava/lang/String;", "route", "getRoute", "shouldPopStack", "", "getShouldPopStack", "()Z", "app_debug"})
public final class HomeDestination implements com.android.chatmeup.navigation.CmuNavigationDestination {
    @org.jetbrains.annotations.NotNull
    public static final com.android.chatmeup.ui.screens.homescreen.navigation.HomeDestination INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String route = "chat_list_route";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String destination = "chat_list_destination";
    private static final boolean shouldPopStack = true;
    
    private HomeDestination() {
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
}