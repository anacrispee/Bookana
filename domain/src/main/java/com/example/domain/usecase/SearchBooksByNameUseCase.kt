package com.example.domain.usecase

import com.example.domain.model.BookModel
import com.example.domain.repository.BooksRemoteRepository
import com.example.domain.usecase.core.UseCase
import kotlinx.coroutines.CoroutineScope

class SearchBooksByNameUseCases(
    scope: CoroutineScope,
    private val repository: BooksRemoteRepository
) : UseCase<List<BookModel>, String>(scope) {

    override fun run(params: String?) = when (params) {
        null -> throw RuntimeException("Params must not be null")
        else -> repository.searchBooks(query = params)
    }
}