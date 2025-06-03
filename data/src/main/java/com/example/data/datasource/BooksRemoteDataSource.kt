package com.example.data.datasource

import com.example.domain.model.BookModel
import kotlinx.coroutines.flow.Flow

interface BooksRemoteDataSource {
    fun searchBook(query: String) : Flow<List<BookModel>>
}