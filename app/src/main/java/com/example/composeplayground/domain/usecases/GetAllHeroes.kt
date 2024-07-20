package com.example.composeplayground.domain.usecases

import androidx.paging.PagingData
import com.example.composeplayground.data.repository.Repository
import com.example.composeplayground.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<PagingData<Hero>> {
        return repository.getAllHeroes()
    }

}