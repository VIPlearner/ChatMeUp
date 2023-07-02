package com.android.chatmeup.ui.screens.homescreen.navigation

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.chatmeup.navigation.CmuNavigationDestination
import com.android.chatmeup.ui.screens.homescreen.HomeScreen
import com.android.chatmeup.ui.screens.homescreen.viewmodel.HomeViewModel

object HomeDestination : CmuNavigationDestination {
    override val route = "chat_list_route"
    override val destination = "chat_list_destination"
    override val shouldPopStack = true
}

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.homeGraph(
    context: Context,
    activity: Activity?,
    factory: HomeViewModel.Factory,
    onNavigateToChat: (NavBackStackEntry, String) -> Unit,
    onNavigateToLogin: (NavBackStackEntry) -> Unit,
    onNavigateToSettings: (NavBackStackEntry) -> Unit,
    onNavigateToEditProfile: (NavBackStackEntry) -> Unit
) {
    composable(
        route = HomeDestination.route
    ) { navBackStackEntry ->
        HomeScreen(
            context = context,
            activity = activity,
            factory = factory,
            onNavigateToChat = {
                onNavigateToChat(navBackStackEntry, it)
            },
            onNavigateToLogin = {
                onNavigateToLogin(navBackStackEntry)
            },
            onNavigateToEditProfile = {
                onNavigateToEditProfile(navBackStackEntry)
            },
            onNavigateToSettings = {
                onNavigateToSettings(navBackStackEntry)
            },
        )
    }
}