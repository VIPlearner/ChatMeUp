package com.android.chatmeup.ui.screens.loginscreen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.chatmeup.data.datastore.CmuDataStoreRepository

@Composable
fun loginScreenViewModelProvider(
    factory: LoginScreenViewModel.Factory,
    cmuDataStoreRepository: CmuDataStoreRepository
): LoginScreenViewModel {
    return viewModel(factory = LoginScreenViewModel.provideFactory(
        factory,
        cmuDataStoreRepository = cmuDataStoreRepository
    ))
}