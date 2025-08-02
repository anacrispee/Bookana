package com.example.data.repository

import com.example.data.datasource.BooksLocalDataSource
import com.example.data.datasource.BooksRemoteDataSource
import com.example.domain.model.BookModel
import com.example.domain.repository.BooksRepository
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(
    private val remoteDataSource: BooksRemoteDataSource,
    private val localDataSource: BooksLocalDataSource
) : BooksRepository {

    override fun searchBooks(query: String) : Flow<List<BookModel>> =
        remoteDataSource.searchBook(query)

    override fun addNewBook(model: BookModel) =
        localDataSource.addNewBook(model)

    override fun getAllBooks(): Flow<List<BookModel>> =
        localDataSource.getAllBooks()

    override fun deleteBook(title: String) : Unit = localDataSource.deleteBook(title)

    override fun updateBook(model: BookModel) : Unit = localDataSource.updateBook(model)
}