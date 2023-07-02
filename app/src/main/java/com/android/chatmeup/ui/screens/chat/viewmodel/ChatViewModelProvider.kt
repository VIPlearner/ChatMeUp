package com.android.chatmeup.ui.screens.chat.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun chatViewModelProvider(
    chatId: String,
    myUserId: String,
    otherUserId: String,
    factory: ChatViewModel.Factory,
): ChatViewModel {
    return viewModel(factory = ChatViewModel.provideFactory(
        factory,
        chatId = chatId,
        myUserId = myUserId,
        otherUserId = otherUserId
    ))
}