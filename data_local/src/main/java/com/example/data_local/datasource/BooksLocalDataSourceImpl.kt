package com.example.data_local.datasource

import com.example.data.datasource.BooksLocalDataSource
import com.example.data_local.mapper.BookDaoMapper.toDao
import com.example.data_local.mapper.BookDaoMapper.toDomain
import com.example.data_local.model.BookDao
import com.example.domain.model.BookModel
import kotlinx.coroutines.flow.flow

class BooksLocalDataSourceImpl(
    private val bookDao: BookDao
) : BooksLocalDataSource {

    override fun addNewBook(model: BookModel) =
        bookDao.addBook(model.toDao())

    override fun getAllBooks() = flow {
        emit(
            bookDao.getBooks().map { it.toDomain() }
        )
    }

    override fun deleteBook(title: String) =
        bookDao.deleteBook(title)

    override fun updateBook(model: BookModel) =
        bookDao.updateBook(model.toDao())
}