package com.example.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class BookModel(
    val image: String,
    val name: String,
    val author: String
) : Parcelable

val dummyBooksList = listOf<BookModel>(
    BookModel(
        image = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1586722975i/2767052.jpg",
        name = "Jogos Vorazes",
        author = "Suzanne Collins"
    ),
    BookModel(
        image = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1546910265i/2.jpg",
        name = "Harry Potter e a Ordem da Fênix",
        author = "J.K. Rowling"
    ),
    BookModel(
        image = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1700522826i/41865.jpg",
        name = "Crepúsculo",
        author = "Stephenie Mayer"
    ),
    BookModel(
        image = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1586722975i/2767052.jpg",
        name = "Jogos Vorazes",
        author = "Suzanne Collins"
    ),
    BookModel(
        image = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1546910265i/2.jpg",
        name = "Harry Potter e a Ordem da Fênix",
        author = "J.K. Rowling"
    ),
    BookModel(
        image = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1700522826i/41865.jpg",
        name = "Crepúsculo",
        author = "Stephenie Mayer"
    ),
    BookModel(
        image = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1586722975i/2767052.jpg",
        name = "Jogos Vorazes",
        author = "Suzanne Collins"
    ),
    BookModel(
        image = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1546910265i/2.jpg",
        name = "Harry Potter e a Ordem da Fênix",
        author = "J.K. Rowling"
    ),
    BookModel(
        image = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1700522826i/41865.jpg",
        name = "Crepúsculo",
        author = "Stephenie Mayer"
    )
)