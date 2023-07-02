package com.android.chatmeup.data.datastore;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
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
public final class CmuDataStoreRepositoryImpl_Factory implements Factory<CmuDataStoreRepositoryImpl> {
  private final Provider<DataStore<Preferences>> prefsDataStoreProvider;

  public CmuDataStoreRepositoryImpl_Factory(
      Provider<DataStore<Preferences>> prefsDataStoreProvider) {
    this.prefsDataStoreProvider = prefsDataStoreProvider;
  }

  @Override
  public CmuDataStoreRepositoryImpl get() {
    return newInstance(prefsDataStoreProvider.get());
  }

  public static CmuDataStoreRepositoryImpl_Factory create(
      Provider<DataStore<Preferences>> prefsDataStoreProvider) {
    return new CmuDataStoreRepositoryImpl_Factory(prefsDataStoreProvider);
  }

  public static CmuDataStoreRepositoryImpl newInstance(DataStore<Preferences> prefsDataStore) {
    return new CmuDataStoreRepositoryImpl(prefsDataStore);
  }
}
