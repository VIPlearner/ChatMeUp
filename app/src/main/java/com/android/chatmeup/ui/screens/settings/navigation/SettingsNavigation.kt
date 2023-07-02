package com.android.chatmeup.ui.screens.settings.navigation

import android.app.Activity
import android.content.Context
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.chatmeup.navigation.CmuNavigationDestination
import com.android.chatmeup.ui.screens.settings.SettingsScreen

object SettingsDestination : CmuNavigationDestination {
    override val route = "settings_route"
    override val destination = "settings_destination"
    override val shouldPopStack = false
}

fun NavGraphBuilder.settingsGraph(
    context: Context,
    activity: Activity?,
    onBackClick: () -> Unit,
) {
    composable(
        route = SettingsDestination.route
    ) { navBackStackEntry ->
        SettingsScreen(
            onBackClick = onBackClick
        )
    }
}