package com.example.data_remote.mapper

import com.example.data_remote.model.BookResponse
import com.example.data_remote.utils.DataRemoteMapper
import com.example.domain.model.BookModel

object SearchBookMapper : DataRemoteMapper<List<BookResponse>, List<BookModel>> () {
    override fun toDomain(data: List<BookResponse>): List<BookModel> {
        return data.map { book ->
            BookModel(
                author = book.author.orEmpty(),
                title = book.title.orEmpty(),
                cover = ""
            )
        }
    }
}