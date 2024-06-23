package com.example.composeplayground.data.repository

import com.example.composeplayground.domain.repository.DataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStore: DataStore
) {

    suspend fun saveOnboardingState(completed: Boolean) {
        dataStore.saveOnboardingState(completed)
    }

    fun readOnboardingState(): Flow<Boolean> {
        return dataStore.readOnboardingState()
    }

}