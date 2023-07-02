/*
 * Copyright (c) 2022. Nomba Financial Services
 *
 * author: Victor Shoaga
 * email: victor.shoaga@nomba.com
 * github: @inventvictor
 *
 */

package com.android.chatmeup.data.datastore

import kotlinx.coroutines.flow.Flow

interface CmuDataStoreRepository {
    suspend fun clearData()

    suspend fun saveLoginCredentials(state: String)
    suspend fun getLoginCredentials(): Flow<String>

    suspend fun saveUserId(state: String)
    suspend fun getUserId(): Flow<String>
}