package com.example.composeplayground.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStore {

    suspend fun saveOnboardingState(completed: Boolean)

    fun readOnboardingState(): Flow<Boolean>

}