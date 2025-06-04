package com.example.data_remote.services

import com.example.data_remote.model.BookResponse
import com.example.data_remote.model.GenericResponse
import com.example.data_remote.utils.Routes.GOOGLE_BOOKS_ROUTE
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksService {

    @GET(GOOGLE_BOOKS_ROUTE)
    suspend fun searchBook(
        @Query("q") query: String
    ) : GenericResponse<List<BookResponse>>
}