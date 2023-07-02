package com.android.chatmeup.util

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesUtil {
    private const val PACKAGE_NAME = "com.android.chatmeup"

    private const val LOGIN_CREDENTIALS = "login_credentials"

    private const val USER_ID = "user_id"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE)
    }

    fun getUserID(context: Context): String {
        return getPrefs(context).getString(USER_ID, null) ?: ""
    }

    fun saveUserID(context: Context, userID: String) {
        getPrefs(context).edit().putString(USER_ID, userID).apply()
    }

    fun removeUserID(context: Context) {
        getPrefs(context).edit().remove(USER_ID).apply()
    }

    fun getLoginCredentials(context: Context): String? {
        return getPrefs(context).getString(LOGIN_CREDENTIALS, null)
    }

    fun saveLoginCredentials(context: Context, userID: String) {
        getPrefs(context).edit().putString(LOGIN_CREDENTIALS, userID).apply()
    }

    fun removeLoginCredentials(context: Context) {
        getPrefs(context).edit().remove(LOGIN_CREDENTIALS).apply()
    }
}