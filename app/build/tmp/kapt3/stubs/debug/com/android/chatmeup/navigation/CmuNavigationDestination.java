package com.android.chatmeup.navigation;

import java.lang.System;

/**
 * Interface for describing the ChatMeUp navigation destinations
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/android/chatmeup/navigation/CmuNavigationDestination;", "", "destination", "", "getDestination", "()Ljava/lang/String;", "route", "getRoute", "shouldPopStack", "", "getShouldPopStack", "()Z", "app_debug"})
public abstract interface CmuNavigationDestination {
    
    /**
     * Defines a specific route this destination belongs to.
     * Route is a String that defines the path to your composable.
     * You can think of it as an implicit deep link that leads to a specific destination.
     * Each destination should have a unique route.
     */
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getRoute();
    
    /**
     * Defines a specific destination ID.
     * This is needed when using nested graphs via the navigation DLS, to differentiate a specific
     * destination's route from the route of the entire nested graph it belongs to.
     */
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getDestination();
    
    /**
     * Defines whether the back stack should be cleared before navigating to the route
     */
    public abstract boolean getShouldPopStack();
}