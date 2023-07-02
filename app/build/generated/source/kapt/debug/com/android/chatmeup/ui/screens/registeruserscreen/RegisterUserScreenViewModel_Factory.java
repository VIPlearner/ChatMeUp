package com.android.chatmeup.ui.screens.registeruserscreen;

import com.android.chatmeup.data.datastore.CmuDataStoreRepository;
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
public final class RegisterUserScreenViewModel_Factory implements Factory<RegisterUserScreenViewModel> {
  private final Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider;

  public RegisterUserScreenViewModel_Factory(
      Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider) {
    this.cmuDataStoreRepositoryProvider = cmuDataStoreRepositoryProvider;
  }

  @Override
  public RegisterUserScreenViewModel get() {
    return newInstance(cmuDataStoreRepositoryProvider.get());
  }

  public static RegisterUserScreenViewModel_Factory create(
      Provider<CmuDataStoreRepository> cmuDataStoreRepositoryProvider) {
    return new RegisterUserScreenViewModel_Factory(cmuDataStoreRepositoryProvider);
  }

  public static RegisterUserScreenViewModel newInstance(
      CmuDataStoreRepository cmuDataStoreRepository) {
    return new RegisterUserScreenViewModel(cmuDataStoreRepository);
  }
}
