package com.example.data_remote.model

import com.google.gson.annotations.SerializedName

data class GenericResponse<T>(
    @SerializedName("kind") val numFound: String? = null,
    @SerializedName("totalItems") val totalItems: Int? = null,
    @SerializedName("items") val result: T? = null
)