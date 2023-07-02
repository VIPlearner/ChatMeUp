package com.android.chatmeup.data.datastore;

import com.android.chatmeup.AppTaskManager;
import com.android.chatmeup.data.db.room_db.ChatMeUpDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DataStoreModule_ProvideAppTaskManagerFactory implements Factory<AppTaskManager> {
  private final Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider;

  public DataStoreModule_ProvideAppTaskManagerFactory(
      Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider) {
    this.chatMeUpDatabaseProvider = chatMeUpDatabaseProvider;
  }

  @Override
  public AppTaskManager get() {
    return provideAppTaskManager(chatMeUpDatabaseProvider.get());
  }

  public static DataStoreModule_ProvideAppTaskManagerFactory create(
      Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider) {
    return new DataStoreModule_ProvideAppTaskManagerFactory(chatMeUpDatabaseProvider);
  }

  public static AppTaskManager provideAppTaskManager(ChatMeUpDatabase chatMeUpDatabase) {
    return Preconditions.checkNotNullFromProvides(DataStoreModule.INSTANCE.provideAppTaskManager(chatMeUpDatabase));
  }
}
