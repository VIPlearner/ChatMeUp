package com.android.chatmeup.data.datastore;

import android.content.Context;
import com.android.chatmeup.data.db.room_db.ChatMeUpDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DataStoreModule_ProvideChatMeUpDatabaseFactory implements Factory<ChatMeUpDatabase> {
  private final Provider<Context> contextProvider;

  public DataStoreModule_ProvideChatMeUpDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ChatMeUpDatabase get() {
    return provideChatMeUpDatabase(contextProvider.get());
  }

  public static DataStoreModule_ProvideChatMeUpDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new DataStoreModule_ProvideChatMeUpDatabaseFactory(contextProvider);
  }

  public static ChatMeUpDatabase provideChatMeUpDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(DataStoreModule.INSTANCE.provideChatMeUpDatabase(context));
  }
}
