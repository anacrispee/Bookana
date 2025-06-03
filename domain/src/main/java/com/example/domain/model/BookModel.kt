package com.example.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class BookModel(
    val cover: String,
    val title: String,
    val author: List<String>
) : Parcelable

val dummyTest = listOf<BookModel>(
    BookModel(
        cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1586722975i/2767052.jpg",
        title = "Batata frita",
        author = listOf("Cozinheiro")
    )
)

val dummyBooksList = listOf<BookModel>(
    BookModel(
        cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1586722975i/2767052.jpg",
        title = "Jogos Vorazes",
        author = listOf("Suzanne Collins")
    ),
    BookModel(
        cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1546910265i/2.jpg",
        title = "Harry Potter e a Ordem da Fênix",
        author =listOf( "J.K. Rowling")
    ),
    BookModel(
        cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1700522826i/41865.jpg",
        title = "Crepúsculo",
        author = listOf("Stephenie Mayer")
    ),
    BookModel(
        cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1586722975i/2767052.jpg",
        title = "Jogos Vorazes",
        author = listOf("Suzanne Collins")
    ),
    BookModel(
        cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1546910265i/2.jpg",
        title = "Harry Potter e a Ordem da Fênix",
        author = listOf("J.K. Rowling")
    ),
    BookModel(
        cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1700522826i/41865.jpg",
        title = "Crepúsculo",
        author = listOf("Stephenie Mayer")
    ),
    BookModel(
        cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1586722975i/2767052.jpg",
        title = "Jogos Vorazes",
        author = listOf("Suzanne Collins")
    ),
    BookModel(
        cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1546910265i/2.jpg",
        title = "Harry Potter e a Ordem da Fênix",
        author = listOf("J.K. Rowling")
    ),
    BookModel(
        cover = "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1700522826i/41865.jpg",
        title = "Crepúsculo",
        author = listOf("Stephenie Mayer")
    )
)