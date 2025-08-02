package com.example.di

import androidx.room.Room
import com.example.data_local.database.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "books-database"
        ).build()
    }

    single { get<AppDatabase>().bookDao() }
}