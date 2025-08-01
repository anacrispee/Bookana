package com.example.data_local.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Books")
data class BookEntity(
    @PrimaryKey val title: String? = null,
    @ColumnInfo(name = "subtitle") val subtitle: String? = null,
    @ColumnInfo(name = "authors") val authors: String? = null,
    @ColumnInfo(name = "image") val image: String? = null,
    @ColumnInfo(name = "currentPage") val currentPage: Int? = null,
    @ColumnInfo(name = "totalPages") val totalPages: Int? = null
)