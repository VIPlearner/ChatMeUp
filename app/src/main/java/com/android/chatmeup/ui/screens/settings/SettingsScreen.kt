package com.android.chatmeup.ui.screens.settings

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.chatmeup.ui.screens.components.CmuTopBar

@Composable
fun SettingsScreen(onBackClick: () -> Unit) {
    Scaffold(topBar = {
        CmuTopBar(
            modifier = Modifier,
            title = "Settings"
        )
    }) {

    }
}

