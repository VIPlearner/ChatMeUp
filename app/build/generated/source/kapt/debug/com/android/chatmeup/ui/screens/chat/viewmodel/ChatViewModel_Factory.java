package com.android.chatmeup.ui.screens.chat.viewmodel;

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
public final class ChatViewModel_Factory {
  private final Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider;

  private final Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider;

  private final Provider<AppTaskManager> appTaskManagerProvider;

  public ChatViewModel_Factory(Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider,
      Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider,
      Provider<AppTaskManager> appTaskManagerProvider) {
    this.cmuDataStoreRepositoryProvider = cmuDataStoreRepositoryProvider;
    this.chatMeUpDatabaseProvider = chatMeUpDatabaseProvider;
    this.appTaskManagerProvider = appTaskManagerProvider;
  }

  public ChatViewModel get(String chatID, String myUserID, String otherUserID) {
    return newInstance(chatID, myUserID, otherUserID, cmuDataStoreRepositoryProvider.get(), chatMeUpDatabaseProvider.get(), appTaskManagerProvider.get());
  }

  public static ChatViewModel_Factory create(
      Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider,
      Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider,
      Provider<AppTaskManager> appTaskManagerProvider) {
    return new ChatViewModel_Factory(cmuDataStoreRepositoryProvider, chatMeUpDatabaseProvider, appTaskManagerProvider);
  }

  public static ChatViewModel newInstance(String chatID, String myUserID, String otherUserID,
      CmuDataStoreRepository cmuDataStoreRepository, ChatMeUpDatabase chatMeUpDatabase,
      AppTaskManager appTaskManager) {
    return new ChatViewModel(chatID, myUserID, otherUserID, cmuDataStoreRepository, chatMeUpDatabase, appTaskManager);
  }
}
