package com.android.chatmeup.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.android.chatmeup.AppTaskManager
import com.android.chatmeup.data.db.room_db.ChatMeUpDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    CmuDataStorePreferenceKeys.CMU_DATASTORE_PREFERENCES
)

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun providesPreferencesDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> =
        context.dataStore

    @Provides
    @Singleton
    fun provideCmuDataStoreRepository(dataStore: DataStore<Preferences>): CmuDataStoreRepository {
        return CmuDataStoreRepositoryImpl(dataStore)
    }

    @Provides
    @Singleton
    fun provideChatMeUpDatabase(
        @ApplicationContext context: Context,
    ): ChatMeUpDatabase {
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "ALTER TABLE message ADD COLUMN senderID String"
                )
            }
        }
        return Room.databaseBuilder(
            context = context,
            klass = ChatMeUpDatabase::class.java,
            name = "ChatMeUp.db"
        ).addMigrations(MIGRATION_1_2).
        build()
    }

    @Provides
    @Singleton
    fun provideAppTaskManager(
        chatMeUpDatabase: ChatMeUpDatabase,
    ): AppTaskManager {
        return AppTaskManager(chatMeUpDatabase)
    }
}