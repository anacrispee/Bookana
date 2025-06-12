package com.example.domain.usecase

import com.example.domain.repository.BooksRepository
import com.example.domain.usecase.core.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

class DeleteBookUseCase(
    scope: CoroutineScope,
    private val repository: BooksRepository
) : UseCase<Unit, String>(scope) {

    override fun run(params: String?): Flow<Unit> =
        repository.deleteBook(params.orEmpty())
}