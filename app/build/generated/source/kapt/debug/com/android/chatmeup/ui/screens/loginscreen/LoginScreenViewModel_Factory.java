package com.android.chatmeup.ui.screens.loginscreen;

import com.android.chatmeup.AppTaskManager;
import com.android.chatmeup.data.datastore.CmuDataStoreRepository;
import com.android.chatmeup.data.db.room_db.ChatMeUpDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class LoginScreenViewModel_Factory implements Factory<LoginScreenViewModel> {
  private final Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider;

  private final Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider;

  private final Provider<AppTaskManager> appTaskManagerProvider;

  public LoginScreenViewModel_Factory(
      Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider,
      Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider,
      Provider<AppTaskManager> appTaskManagerProvider) {
    this.cmuDataStoreRepositoryProvider = cmuDataStoreRepositoryProvider;
    this.chatMeUpDatabaseProvider = chatMeUpDatabaseProvider;
    this.appTaskManagerProvider = appTaskManagerProvider;
  }

  @Override
  public LoginScreenViewModel get() {
    return newInstance(cmuDataStoreRepositoryProvider.get(), chatMeUpDatabaseProvider.get(), appTaskManagerProvider.get());
  }

  public static LoginScreenViewModel_Factory create(
      Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider,
      Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider,
      Provider<AppTaskManager> appTaskManagerProvider) {
    return new LoginScreenViewModel_Factory(cmuDataStoreRepositoryProvider, chatMeUpDatabaseProvider, appTaskManagerProvider);
  }

  public static LoginScreenViewModel newInstance(CmuDataStoreRepository cmuDataStoreRepository,
      ChatMeUpDatabase chatMeUpDatabase, AppTaskManager appTaskManager) {
    return new LoginScreenViewModel(cmuDataStoreRepository, chatMeUpDatabase, appTaskManager);
  }
}
