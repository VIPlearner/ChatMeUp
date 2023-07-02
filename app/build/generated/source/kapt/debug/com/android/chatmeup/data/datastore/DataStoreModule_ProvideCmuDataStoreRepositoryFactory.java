package com.android.chatmeup.data.datastore;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
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
public final class DataStoreModule_ProvideCmuDataStoreRepositoryFactory implements Factory<CmuDataStoreRepository> {
  private final Provider<DataStore<Preferences>> dataStoreProvider;

  public DataStoreModule_ProvideCmuDataStoreRepositoryFactory(
      Provider<DataStore<Preferences>> dataStoreProvider) {
    this.dataStoreProvider = dataStoreProvider;
  }

  @Override
  public CmuDataStoreRepository get() {
    return provideCmuDataStoreRepository(dataStoreProvider.get());
  }

  public static DataStoreModule_ProvideCmuDataStoreRepositoryFactory create(
      Provider<DataStore<Preferences>> dataStoreProvider) {
    return new DataStoreModule_ProvideCmuDataStoreRepositoryFactory(dataStoreProvider);
  }

  public static CmuDataStoreRepository provideCmuDataStoreRepository(
      DataStore<Preferences> dataStore) {
    return Preconditions.checkNotNullFromProvides(DataStoreModule.INSTANCE.provideCmuDataStoreRepository(dataStore));
  }
}
