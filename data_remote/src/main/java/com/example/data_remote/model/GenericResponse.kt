package com.example.data_remote.model

import com.google.gson.annotations.SerializedName

data class GenericResponse<T>(
    @SerializedName("numFound") val numFound: Int? = null,
    @SerializedName("q") val query: String? = null,
    @SerializedName("docs") val result: T? = null
)