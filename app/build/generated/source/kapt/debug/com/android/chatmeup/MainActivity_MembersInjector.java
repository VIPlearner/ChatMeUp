package com.android.chatmeup;

import com.android.chatmeup.data.datastore.CmuDataStoreRepository;
import com.android.chatmeup.data.db.room_db.ChatMeUpDatabase;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider;

  private final Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider;

  private final Provider<AppTaskManager> appTaskManagerProvider;

  public MainActivity_MembersInjector(
      Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider,
      Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider,
      Provider<AppTaskManager> appTaskManagerProvider) {
    this.cmuDataStoreRepositoryProvider = cmuDataStoreRepositoryProvider;
    this.chatMeUpDatabaseProvider = chatMeUpDatabaseProvider;
    this.appTaskManagerProvider = appTaskManagerProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider,
      Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider,
      Provider<AppTaskManager> appTaskManagerProvider) {
    return new MainActivity_MembersInjector(cmuDataStoreRepositoryProvider, chatMeUpDatabaseProvider, appTaskManagerProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectCmuDataStoreRepository(instance, cmuDataStoreRepositoryProvider.get());
    injectChatMeUpDatabase(instance, chatMeUpDatabaseProvider.get());
    injectAppTaskManager(instance, appTaskManagerProvider.get());
  }

  @InjectedFieldSignature("com.android.chatmeup.MainActivity.cmuDataStoreRepository")
  public static void injectCmuDataStoreRepository(MainActivity instance,
      CmuDataStoreRepository cmuDataStoreRepository) {
    instance.cmuDataStoreRepository = cmuDataStoreRepository;
  }

  @InjectedFieldSignature("com.android.chatmeup.MainActivity.chatMeUpDatabase")
  public static void injectChatMeUpDatabase(MainActivity instance,
      ChatMeUpDatabase chatMeUpDatabase) {
    instance.chatMeUpDatabase = chatMeUpDatabase;
  }

  @InjectedFieldSignature("com.android.chatmeup.MainActivity.appTaskManager")
  public static void injectAppTaskManager(MainActivity instance, AppTaskManager appTaskManager) {
    instance.appTaskManager = appTaskManager;
  }
}
