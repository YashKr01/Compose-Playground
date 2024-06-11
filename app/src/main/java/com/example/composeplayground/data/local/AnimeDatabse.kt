package com.example.composeplayground.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composeplayground.data.local.dao.HeroDao
import com.example.composeplayground.domain.model.Hero

@Database(entities = [Hero::class], version = 1)
abstract class AnimeDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

}