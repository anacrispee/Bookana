package com.example.di

import com.example.domain.usecase.AddNewBookUseCase
import com.example.domain.usecase.DeleteBookUseCase
import com.example.domain.usecase.GetAllBooksUseCase
import com.example.domain.usecase.SearchBooksByNameUseCases
import com.example.domain.usecase.UpdateBookUseCase
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

    factory { (scope: CoroutineScope) ->
        AddNewBookUseCase(
            scope = scope,
            repository = get()
        )
    }

    factory { (scope: CoroutineScope) ->
        DeleteBookUseCase(
            scope = scope,
            repository = get()
        )
    }

    factory { (scope: CoroutineScope) ->
        GetAllBooksUseCase(
            scope = scope,
            repository = get()
        )
    }


    factory { (scope: CoroutineScope) ->
        UpdateBookUseCase(
            scope = scope,
            repository = get()
        )
    }
}