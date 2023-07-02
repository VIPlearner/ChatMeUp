package com.android.chatmeup.ui.screens.chat.viewmodel;

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
public final class ChatViewModel_Factory_Impl implements ChatViewModel.Factory {
  private final ChatViewModel_Factory delegateFactory;

  ChatViewModel_Factory_Impl(ChatViewModel_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public ChatViewModel create(String chatId, String myUserId, String otherUserId) {
    return delegateFactory.get(chatId, myUserId, otherUserId);
  }

  public static Provider<ChatViewModel.Factory> create(ChatViewModel_Factory delegateFactory) {
    return InstanceFactory.create(new ChatViewModel_Factory_Impl(delegateFactory));
  }
}
