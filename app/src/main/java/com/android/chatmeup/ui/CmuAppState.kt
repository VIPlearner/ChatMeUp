/*
 * Copyright (c) 2022. Nomba Financial Services
 *
 * author: Victor Shoaga
 * email: victor.shoaga@nomba.com
 * github: @inventvictor
 *
 */

package com.android.chatmeup.ui

import android.app.Activity
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.chatmeup.CmuApplication
import com.android.chatmeup.navigation.CmuNavigationDestination

@Composable
fun rememberChatMeUpAppState(
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current,
    activity: Activity? = (LocalContext.current.applicationContext as CmuApplication).getCurrentActivity(),
) = remember(navController) {
    CmuAppState(navController, context, activity)
}

@Stable
class CmuAppState(
    val navController: NavHostController,
    private val context: Context,
    private val activity: Activity?
) {

    val appStateContext: Context = context
    val appStateActivity: Activity? = activity

    /**
     * UI logic for navigating to a particular destination in the app. The NavigationOptions to
     * navigate with are based on the type of destination, which could be a top level destination or
     * just a regular destination.
     *
     * @param from: Representation of an entry in the back stack of a [androidx.navigation.NavController]
     * @param destination: The [CmuNavigationDestination] the app needs to navigate to.
     * @param route: [String] Optional route to navigate to in case the destination contains arguments.
     */
    fun navigate(from: NavBackStackEntry, destination: CmuNavigationDestination, route: String? = null) {
        if (destination.shouldPopStack) {
            if (from.lifecycleIsResumed()) {
                navController.navigate(route ?: destination.route) {
                    popUpTo(0)
                }
            }
        } else {
            if (from.lifecycleIsResumed()) {
                navController.navigate(route ?: destination.route)
            }
        }
    }

    fun navigateBack() {
        navController.popBackStack()
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.getLifecycle().currentState == Lifecycle.State.RESUMED

