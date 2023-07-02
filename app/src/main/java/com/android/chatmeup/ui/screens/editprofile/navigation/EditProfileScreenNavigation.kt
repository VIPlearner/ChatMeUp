package com.chatmeup.features.edit_profile.navigation

import android.app.Activity
import android.content.Context
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.android.chatmeup.navigation.CmuNavigationDestination
import com.android.chatmeup.ui.screens.editprofile.EditProfileScreen

object EditProfileDestination : CmuNavigationDestination {
    override val route = "edit_profile_route"
    override val destination = "edit_profile_destination"
    override val shouldPopStack = false
}

fun NavGraphBuilder.editProfileGraph(
    context: Context,
    activity: Activity?,
    onBackClick: () -> Unit,
) {
    composable(
        route = com.chatmeup.features.edit_profile.navigation.EditProfileDestination.route
    ) { navBackStackEntry ->
        EditProfileScreen(
            context = context,
            activity = activity,
            onBackClick = onBackClick
        )
    }
}