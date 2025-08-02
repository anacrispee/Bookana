package com.example.di

import com.example.data.datasource.BooksLocalDataSource
import com.example.data_local.datasource.BooksLocalDataSourceImpl
import org.koin.dsl.module

val dataLocalModule = module {
    single<BooksLocalDataSource> { BooksLocalDataSourceImpl(get()) }
}