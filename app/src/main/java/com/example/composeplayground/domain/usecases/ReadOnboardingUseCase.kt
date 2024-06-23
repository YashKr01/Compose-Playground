package com.example.composeplayground.domain.usecases

import com.example.composeplayground.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnboardingUseCase(private val repository: Repository) {

    operator fun invoke(): Flow<Boolean> {
        return repository.readOnboardingState()
    }

}