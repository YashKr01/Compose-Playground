package com.example.composeplayground.domain.usecases

import com.example.composeplayground.data.repository.Repository

class SaveOnboardingUseCase(private val repository: Repository) {

    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnboardingState(completed)
    }

}