package com.example.composeplayground.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.composeplayground.utils.Constants.ANIME_PREF
import com.example.composeplayground.utils.Constants.PREFERENCES_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import okio.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = ANIME_PREF)

class DataStoreImpl(context: Context) : com.example.composeplayground.domain.repository.DataStore {

    private object PreferenceKey {
        val onboardingKey = booleanPreferencesKey(name = PREFERENCES_KEY)
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnboardingState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferenceKey.onboardingKey] = completed
        }
    }

    override fun readOnboardingState(): Flow<Boolean> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) emit(emptyPreferences())
                else throw exception
            }
            .map { preferences ->
                val onboardingState = preferences[PreferenceKey.onboardingKey] ?: false
                onboardingState
            }
    }
}