package com.example.domain.usecase

import com.example.domain.model.BookModel
import com.example.domain.repository.BooksRepository
import com.example.domain.usecase.core.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class GetAllBooksUseCase(
    scope: CoroutineScope,
    private val repository: BooksRepository
) : UseCase<List<BookModel>, Unit>(scope) {

    override fun run(params: Unit?): Flow<List<BookModel>> =
        repository.getAllBooks()
}