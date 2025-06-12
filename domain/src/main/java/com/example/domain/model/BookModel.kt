package com.example.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class BookModel(
    val information: InformationModel? = null
) : Parcelable

@Keep
@Parcelize
data class InformationModel(
    val title: String? = null,
    val subtitle: String? = null,
    val authors: List<String>? = null,
    val cover: String? = null,
    val pageCount: Int? = null,
    val currentPage: Int? = null
) : Parcelable

val dummyBooksList = listOf(
    BookModel(
        information = InformationModel(
            title = "Jogos Vorazes",
            subtitle = "Vol. 1",
            authors = listOf("Suzanne Collins"),
            cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1586722975i/2767052.jpg"
        )
    ),
    BookModel(
        information = InformationModel(
            title = "Harry Potter e a Ordem da Fênix",
            subtitle = "Vol. 5",
            authors = listOf("J.K. Rowling"),
            cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1546910265i/2.jpg"
        )
    ),
    BookModel(
        information = InformationModel(
            title = "Crepúsculo",
            subtitle = "Saga Crepúsculo",
            authors = listOf("Stephenie Meyer"),
            cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1700522826i/41865.jpg"
        )
    )
)