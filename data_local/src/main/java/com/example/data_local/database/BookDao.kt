package com.example.data_local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data_local.database.model.BookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBook(book: BookEntity) : Flow<Unit>

    @Query("SELECT * FROM Books")
    fun getBooks(): List<BookEntity>

    @Query("DELETE FROM Books WHERE title = :title")
    fun deleteBook(title: String) : Flow<Unit>

    @Update
    fun updateBook(book: BookEntity) : Flow<Unit>
}