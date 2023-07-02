package com.android.chatmeup.ui.screens.homescreen.viewmodel;

import com.android.chatmeup.AppTaskManager;
import com.android.chatmeup.data.datastore.CmuDataStoreRepository;
import com.android.chatmeup.data.db.room_db.ChatMeUpDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeViewModel_Factory {
  private final Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider;

  private final Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider;

  private final Provider<AppTaskManager> appTaskManagerProvider;

  public HomeViewModel_Factory(Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider,
      Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider,
      Provider<AppTaskManager> appTaskManagerProvider) {
    this.cmuDataStoreRepositoryProvider = cmuDataStoreRepositoryProvider;
    this.chatMeUpDatabaseProvider = chatMeUpDatabaseProvider;
    this.appTaskManagerProvider = appTaskManagerProvider;
  }

  public HomeViewModel get(String myUserId) {
    return newInstance(myUserId, cmuDataStoreRepositoryProvider.get(), chatMeUpDatabaseProvider.get(), appTaskManagerProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider,
      Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider,
      Provider<AppTaskManager> appTaskManagerProvider) {
    return new HomeViewModel_Factory(cmuDataStoreRepositoryProvider, chatMeUpDatabaseProvider, appTaskManagerProvider);
  }

  public static HomeViewModel newInstance(String myUserId,
      CmuDataStoreRepository cmuDataStoreRepository, ChatMeUpDatabase chatMeUpDatabase,
      AppTaskManager appTaskManager) {
    return new HomeViewModel(myUserId, cmuDataStoreRepository, chatMeUpDatabase, appTaskManager);
  }
}
