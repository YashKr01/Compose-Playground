package com.example.composeplayground.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.composeplayground.data.local.AnimeDatabase
import com.example.composeplayground.data.remote.AnimeApi
import com.example.composeplayground.domain.model.Hero
import com.example.composeplayground.domain.model.HeroRemoteKeys
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class AnimeRemoteMediator @Inject constructor(
    private val api: AnimeApi,
    private val database: AnimeDatabase
) : RemoteMediator<Int, Hero>() {

    private val heroDao = database.heroDao()
    private val heroRemoteKeys = database.heroRemoteKeyDao()

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Hero>): MediatorResult {
        return try {
            val response = api.getAllHeroes()
            if (response.heroes.isNotEmpty()) {
                database.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        heroDao.deleteAllHeroes()
                        heroRemoteKeys.deleteAllRemoteKeys()
                    }
                    val prevPage = response.prevPage
                    val nextPage = response.nextPage
                    val keys = response.heroes.map { hero ->
                        HeroRemoteKeys(
                            id = hero.id,
                            prevPage = prevPage,
                            nextPage = nextPage
                        )
                    }
                    heroRemoteKeys.addAllRemoteKeys(keys)
                    heroDao.addHeroes(response.heroes)
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

}