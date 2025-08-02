package com.example.data_local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data_local.model.BookDao
import com.example.data_local.model.BookEntity

@Database(
    entities = [
        BookEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao() : BookDao
}