package com.example.data_remote.mapper

import com.example.data_remote.model.BookResponse
import com.example.data_remote.utils.DataRemoteMapper
import com.example.domain.model.BookModel
import com.example.domain.model.InformationModel
import com.example.domain.utils.removeUrlScheme

object SearchBookMapper : DataRemoteMapper<List<BookResponse>, List<BookModel>>() {
    override fun toDomain(data: List<BookResponse>): List<BookModel> {
        return data.map { book ->
            val imageUrl = book.information?.imageLinks?.thumbnail?.removeUrlScheme()
            BookModel(
                information = InformationModel(
                    title = book.information?.title,
                    authors = book.information?.authors,
                    cover = imageUrl,
                    pageCount = book.information?.pageCount
                )
            )
        }
    }
}