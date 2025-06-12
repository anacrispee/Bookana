package com.example.data_local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data_local.database.model.BookEntity

@Database(
    entities = [
        BookEntity::class
    ],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract fun BookDao() : BookDao
}