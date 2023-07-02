package com.android.chatmeup.data.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow

object CmuDataStorePreferenceKeys {
    const val CMU_DATASTORE_PREFERENCES = "chatmeup_datastore_prefs"

    val LOGIN_CREDENTIALS = stringPreferencesKey("login_credentials")

    val USER_ID = stringPreferencesKey("user_id")
}