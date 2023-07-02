package com.android.chatmeup;

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
public final class AppTaskManager_Factory implements Factory<AppTaskManager> {
  private final Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider;

  public AppTaskManager_Factory(Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider) {
    this.chatMeUpDatabaseProvider = chatMeUpDatabaseProvider;
  }

  @Override
  public AppTaskManager get() {
    return newInstance(chatMeUpDatabaseProvider.get());
  }

  public static AppTaskManager_Factory create(Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider) {
    return new AppTaskManager_Factory(chatMeUpDatabaseProvider);
  }

  public static AppTaskManager newInstance(ChatMeUpDatabase chatMeUpDatabase) {
    return new AppTaskManager(chatMeUpDatabase);
  }
}
