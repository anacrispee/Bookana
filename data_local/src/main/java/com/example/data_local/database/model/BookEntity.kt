package com.example.data_local.database.model

import androidx.room.Entity

@Entity(tableName = "Books")
data class BookEntity(
    val title: String? = null,
    val subtitle: String? = null,
    val authors: List<String>? = null,
    val image: String? = null,
    val currentPage: Int? = null,
    val totalPages: Int? = null
)