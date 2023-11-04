package com.loc.newsapp.data.manager

import android.content.Context
import android.provider.SyncStateContract
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.utils.Constant
import com.loc.newsapp.utils.Constant.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalMangerImpl(
    private val context : Context
):LocalUserManager {
    override  fun readAppEntry(): Flow<Boolean> {
       return context.dataStore.data.map { preferences ->
           preferences[PreferencesKeys.APP_ENTRY]?:false
       }
    }

    override suspend fun saveAppEntry() {
        context.dataStore.edit {settings ->
            settings[PreferencesKeys.APP_ENTRY] = true
        }
    }
}
private val Context.dataStore:DataStore<Preferences> by preferencesDataStore(name=USER_SETTINGS)

private object PreferencesKeys{
    val  APP_ENTRY = booleanPreferencesKey(name = Constant.APP_ENTRY)
}