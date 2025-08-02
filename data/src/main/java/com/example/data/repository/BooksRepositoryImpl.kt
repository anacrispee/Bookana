package com.example.data.repository

import com.example.data.datasource.BooksRemoteDataSource
import com.example.domain.model.BookModel
import com.example.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(
    private val remoteDataSource: BooksRemoteDataSource
) : BooksRepository {

    override fun searchBooks(query: String) : Flow<List<BookModel>> =
        remoteDataSource.searchBook(query)
}