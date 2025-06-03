package com.example.data_remote.model

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("author_name") val author: List<String>? = null,
    @SerializedName("title") val title: String? = null,
)