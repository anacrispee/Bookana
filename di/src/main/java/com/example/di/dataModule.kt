package com.example.di
import com.example.data.repository.BooksRemoteRepositoryImpl
import com.example.domain.repository.BooksRemoteRepository
import org.koin.dsl.module

val dataModule = module {
    single<BooksRemoteRepository> { BooksRemoteRepositoryImpl(get()) }
}