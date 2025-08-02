package com.example.di

import com.example.domain.usecase.SearchBooksByNameUseCases
import com.example.domain.usecase.core.ThreadContextProvider
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module {
    single {
        ThreadContextProvider()
    }

    factory { (scope: CoroutineScope) ->
        SearchBooksByNameUseCases(
            scope = scope,
            repository = get()
        )
    }
}