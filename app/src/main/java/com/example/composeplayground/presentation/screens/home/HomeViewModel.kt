package com.example.composeplayground.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.example.composeplayground.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: UseCases
) : ViewModel() {

    val getAllHeroes = useCases.getAllHeroesUseCase()

}