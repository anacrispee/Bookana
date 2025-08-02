package com.example.data_local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Books")
data class BookEntity(
    @PrimaryKey val title: String,
    @ColumnInfo(name = "subtitle") val subtitle: String? = null,
    @ColumnInfo(name = "author") val author: String? = null,
    @ColumnInfo(name = "image") val image: String? = null,
    @ColumnInfo(name = "currentPage") val currentPage: Int? = null,
    @ColumnInfo(name = "totalPages") val totalPages: Int? = null,
)