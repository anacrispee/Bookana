package com.example.data_local.mapper
import com.example.data_local.model.BookEntity
import com.example.domain.model.BookModel
import com.example.domain.model.InformationModel

object BookDaoMapper {
    fun BookModel.toDao() = BookEntity(
        title = information?.title.orEmpty(),
        subtitle = information?.subtitle,
        author = information?.authors?.firstOrNull(),
        image = information?.cover,
        totalPages = information?.pageCount,
        currentPage = information?.currentPage
    )

    fun BookEntity.toDomain() = BookModel(
        information = InformationModel(
            title = title,
            subtitle = subtitle,
            authors = listOf(author.orEmpty()),
            cover = image,
            pageCount = totalPages,
            currentPage = currentPage
        )
    )
}