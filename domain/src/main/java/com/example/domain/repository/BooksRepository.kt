package com.example.domain.repository

import com.example.domain.model.BookModel
import kotlinx.coroutines.flow.Flow

interface BooksRepository {
    fun searchBooks(query: String) : Flow<List<BookModel>>
    fun addNewBook(model: BookModel) : Flow<Unit>
    fun getAllBooks(): Flow<List<BookModel>>
    fun deleteBook(title: String) : Flow<Unit>
    fun updateBook(model: BookModel) : Flow<Unit>
}