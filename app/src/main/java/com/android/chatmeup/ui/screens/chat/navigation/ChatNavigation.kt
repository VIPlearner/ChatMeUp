package com.android.chatmeup.ui.screens.chat.navigation

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.android.chatmeup.navigation.CmuNavigationDestination
import com.android.chatmeup.ui.screens.chat.viewmodel.ChatViewModel
import com.android.chatmeup.ui.screens.chat.views.ChatScreen

object ChatDestination : CmuNavigationDestination {
    const val chatDataArg = "chatData"
    override val route = "chat_route/{$chatDataArg}"
    override val destination = "chat_destination"
    override val shouldPopStack = false

    /**
     * Creates destination route for a chatData that could include special characters
     */
    fun createNavigationRoute(chatArg: String): String {
        val encodedChatData = Uri.encode(chatArg)
        return "chat_route/$encodedChatData"
    }

    /**
     * Returns the chatData from a [NavBackStackEntry] after a chat_destination navigation call
     */
    fun fromNavArgs(entry: NavBackStackEntry): String {
        val encodedId = entry.arguments?.getString(chatDataArg)!!
        return Uri.decode(encodedId)
    }
}
@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.chatGraph(
    context: Context,
    activity: Activity?,
    factory: ChatViewModel.Factory,
    onBackClicked: () -> Unit,
) {
    composable(
        route = ChatDestination.route,
        arguments = listOf(
            navArgument("chatData") {
                type = NavType.StringType
                defaultValue = "<CHAT_ID>%%%<USER_ID>%%%<OTHER_USER_ID>%%%<NO_OD_UNREAD_MESSAGES>"
            },
        )
    ) { backStackEntry ->
        ChatScreen(
            context = context,
            activity = activity,
            factory = factory,
            onBackClicked = onBackClicked,
            chatId = try {
                backStackEntry.arguments?.getString("chatData")?.split("%%%")?.get(0) ?: ""
            } catch (ex: Exception) {
                ""
            },
            userId = try {
                backStackEntry.arguments?.getString("chatData")?.split("%%%")?.get(1) ?: ""
            } catch (ex: Exception) {
                ""
            },
            otherUserId = try {
                backStackEntry.arguments?.getString("chatData")?.split("%%%")?.get(2) ?: ""
            } catch (ex: Exception) {
                ""
            },
            noOfUnreadMessages = try{
                backStackEntry.arguments?.getString("chatData")?.split("%%%")?.get(3) ?: ""
            } catch (ex: Exception) {
                ""
            }
        )
    }
}