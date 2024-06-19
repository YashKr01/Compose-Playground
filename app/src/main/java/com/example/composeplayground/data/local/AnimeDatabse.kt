package com.example.composeplayground.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.composeplayground.data.local.dao.HeroDao
import com.example.composeplayground.data.local.dao.HeroRemoteKeyDao
import com.example.composeplayground.domain.model.Hero
import com.example.composeplayground.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class AnimeDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao

}