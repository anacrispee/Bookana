package com.example.domain.repository

import com.example.domain.model.BookModel
import kotlinx.coroutines.flow.Flow

interface BooksRemoteRepository {
    fun searchBooks(query: String) : Flow<List<BookModel>>
}