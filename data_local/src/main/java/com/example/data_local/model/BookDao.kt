package com.example.data_local.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BookDao {

    @Insert
    fun addBook(book: BookEntity)

    @Query("SELECT * FROM Books")
    fun getBooks(): List<BookEntity>

    @Query("DELETE FROM Books WHERE title = :title")
    fun deleteBook(title: String)

    @Update
    fun updateBook(book: BookEntity)
}