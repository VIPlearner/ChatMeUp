package com.android.chatmeup.ui.screens.homescreen.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeViewModel_Factory_Impl implements HomeViewModel.Factory {
  private final HomeViewModel_Factory delegateFactory;

  HomeViewModel_Factory_Impl(HomeViewModel_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public HomeViewModel create(String myUserId) {
    return delegateFactory.get(myUserId);
  }

  public static Provider<HomeViewModel.Factory> create(HomeViewModel_Factory delegateFactory) {
    return InstanceFactory.create(new HomeViewModel_Factory_Impl(delegateFactory));
  }
}
