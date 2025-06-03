package com.example.data.repository

import com.example.data.datasource.BooksRemoteDataSource
import com.example.domain.model.BookModel
import com.example.domain.repository.BooksRemoteRepository
import kotlinx.coroutines.flow.Flow

class BooksRemoteRepositoryImpl(
    private val dataSource: BooksRemoteDataSource
) : BooksRemoteRepository {

    override fun searchBooks(query: String) : Flow<List<BookModel>> =
        dataSource.searchBook(query)
}