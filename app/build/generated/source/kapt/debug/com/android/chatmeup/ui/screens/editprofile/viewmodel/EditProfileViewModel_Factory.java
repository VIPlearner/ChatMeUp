package com.android.chatmeup.ui.screens.editprofile.viewmodel;

import com.android.chatmeup.AppTaskManager;
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
public final class EditProfileViewModel_Factory implements Factory<EditProfileViewModel> {
  private final Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider;

  private final Provider<AppTaskManager> appTaskManagerProvider;

  public EditProfileViewModel_Factory(Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider,
      Provider<AppTaskManager> appTaskManagerProvider) {
    this.chatMeUpDatabaseProvider = chatMeUpDatabaseProvider;
    this.appTaskManagerProvider = appTaskManagerProvider;
  }

  @Override
  public EditProfileViewModel get() {
    return newInstance(chatMeUpDatabaseProvider.get(), appTaskManagerProvider.get());
  }

  public static EditProfileViewModel_Factory create(
      Provider<ChatMeUpDatabase> chatMeUpDatabaseProvider,
      Provider<AppTaskManager> appTaskManagerProvider) {
    return new EditProfileViewModel_Factory(chatMeUpDatabaseProvider, appTaskManagerProvider);
  }

  public static EditProfileViewModel newInstance(ChatMeUpDatabase chatMeUpDatabase,
      AppTaskManager appTaskManager) {
    return new EditProfileViewModel(chatMeUpDatabase, appTaskManager);
  }
}
