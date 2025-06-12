package com.example.data.datasource

import com.example.domain.model.BookModel
import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {
    fun addNewBook(model: BookModel) : Flow<Unit>
    fun getAllBooks(): Flow<List<BookModel>>
    fun deleteBook(title: String) : Flow<Unit>
    fun updateBook(model: BookModel) : Flow<Unit>
}