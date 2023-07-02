package com.android.chatmeup.ui.screens.registeruserscreen

import android.app.Activity
import android.content.Context
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.chatmeup.navigation.CmuNavigationDestination

object RegisterUserDestination : CmuNavigationDestination {
    override val route = "register_user_route"
    override val destination = "register_user_destination"
    override val shouldPopStack = false
}

fun NavGraphBuilder.registerUserGraph(
    context: Context,
    activity: Activity?,
    onBackClick: () -> Unit,
) {
    composable(
        route = RegisterUserDestination.route
    ) { navBackStackEntry ->
        RegisterUserScreen(
            context = context,
            activity = activity,
            onBackClick = onBackClick
        )
    }
}