package com.example.di

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.example.data_local.database.AppDatabase
import com.example.data_local.security.SqlCipherKeyManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SharedPreferences> {
        PreferenceManager.getDefaultSharedPreferences(androidContext())
    }

    single { SqlCipherKeyManager(get()) }

    single {
        val context = androidContext()
        val dbFile = context.getDatabasePath("books-database")

        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            dbFile.absolutePath
        )
            .openHelperFactory(get<SqlCipherKeyManager>().getSupportFactory())
            .build()
    }

    single { get<AppDatabase>().bookDao() }
}