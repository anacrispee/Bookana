package com.example.data_local.database.datasource

import com.example.data.datasource.BooksLocalDataSource
import com.example.data_local.database.BookDao
import com.example.data_local.database.mapper.BookDaoMapper.toDao
import com.example.data_local.database.mapper.BookDaoMapper.toDomain
import com.example.domain.model.BookModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksLocalDataSourceImpl(
    private val bookDao: BookDao
) : BooksLocalDataSource {

    override fun addNewBook(model: BookModel) : Flow<Unit> =
        bookDao.addBook(model.toDao())

    override fun getAllBooks(): Flow<List<BookModel>> = flow {
        emit(
            bookDao.getBooks().map { it.toDomain() }
        )
    }

    override fun deleteBook(title: String) : Flow<Unit> =
        bookDao.deleteBook(title)

    override fun updateBook(model: BookModel) : Flow<Unit> =
        bookDao.updateBook(model.toDao())
}