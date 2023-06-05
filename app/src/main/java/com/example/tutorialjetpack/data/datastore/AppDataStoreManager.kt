package com.example.tutorialjetpack.data.datastore

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first


private const val APP_DATASTORE = "data_store"

class AppDataStoreManager(val context: Application):AppDataStore {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(APP_DATASTORE)

    override suspend fun setValue(
        key: String,
        value: Long
    ) {
        context.dataStore.edit {
            it[longPreferencesKey(key)] = value
        }
    }

    override suspend fun readValue(
        key: String,
    ): Long? {
        return context.dataStore.data.first()[longPreferencesKey(key)]
    }
}