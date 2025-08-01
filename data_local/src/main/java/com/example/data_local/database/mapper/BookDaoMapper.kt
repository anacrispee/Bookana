package com.example.data_local.database.mapper

import com.example.data_local.database.model.BookEntity
import com.example.domain.model.BookModel
import com.example.domain.model.InformationModel
import kotlin.collections.firstOrNull

object BookDaoMapper {
    fun BookModel.toDao() = BookEntity(
        title = information?.title,
        subtitle = information?.subtitle,
        authors = information?.authors?.firstOrNull(),
        image = information?.cover,
        totalPages = information?.pageCount,
        currentPage = information?.currentPage
    )

    fun BookEntity.toDomain() = BookModel(
        information = InformationModel(
            title = title,
            subtitle = subtitle,
            authors = listOf(authors.orEmpty()),
            cover = image,
            pageCount = totalPages,
            currentPage = currentPage
        )
    )
}