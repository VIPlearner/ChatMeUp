package com.android.chatmeup.data.datastore;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0001\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/android/chatmeup/data/datastore/DataStoreModule;", "", "()V", "provideAppTaskManager", "Lcom/android/chatmeup/AppTaskManager;", "chatMeUpDatabase", "Lcom/android/chatmeup/data/db/room_db/ChatMeUpDatabase;", "provideChatMeUpDatabase", "context", "Landroid/content/Context;", "provideCmuDataStoreRepository", "Lcom/android/chatmeup/data/datastore/CmuDataStoreRepository;", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "providesPreferencesDataStore", "app_debug"})
@dagger.Module
public final class DataStoreModule {
    @org.jetbrains.annotations.NotNull
    public static final com.android.chatmeup.data.datastore.DataStoreModule INSTANCE = null;
    
    private DataStoreModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> providesPreferencesDataStore(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.android.chatmeup.data.datastore.CmuDataStoreRepository provideCmuDataStoreRepository(@org.jetbrains.annotations.NotNull
    androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> dataStore) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.android.chatmeup.data.db.room_db.ChatMeUpDatabase provideChatMeUpDatabase(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.android.chatmeup.AppTaskManager provideAppTaskManager(@org.jetbrains.annotations.NotNull
    com.android.chatmeup.data.db.room_db.ChatMeUpDatabase chatMeUpDatabase) {
        return null;
    }
}