package com.example.data.datasource

import com.example.domain.model.BookModel
import kotlinx.coroutines.flow.Flow

interface BooksLocalDataSource {
    fun addNewBook(model: BookModel)
    fun getAllBooks() : Flow<List<BookModel>>
    fun deleteBook(title: String)
    fun updateBook(model: BookModel)
}