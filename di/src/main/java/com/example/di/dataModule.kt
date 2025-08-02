package com.example.di

import com.example.data.repository.BooksRepositoryImpl
import com.example.domain.repository.BooksRepository
import org.koin.dsl.module

val dataModule = module {
    single<BooksRepository> { BooksRepositoryImpl(get()) }
}