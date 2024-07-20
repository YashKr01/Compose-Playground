package com.example.composeplayground.domain.usecases

data class UseCases(
    val readOnboardingUseCase: ReadOnboardingUseCase,
    val saveOnboardingUseCase: SaveOnboardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase
)
