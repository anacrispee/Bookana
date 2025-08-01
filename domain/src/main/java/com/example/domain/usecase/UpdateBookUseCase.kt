package com.example.domain.usecase

import com.example.domain.model.BookModel
import com.example.domain.repository.BooksRepository
import com.example.domain.usecase.core.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class UpdateBookUseCase(
    scope: CoroutineScope,
    private val repository: BooksRepository
) : UseCase<Unit, BookModel>(scope) {

    override fun run(params: BookModel?): Flow<Unit> = when (params) {
        null -> throw RuntimeException("Params must not be null")
        else -> flowOf(repository.updateBook(model = params))
    }
}