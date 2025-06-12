package com.example.di

import androidx.room.Room
import com.example.data_local.database.Database
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            Database::class.java,
            "books-database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    single { get<Database>().BookDao() }
}