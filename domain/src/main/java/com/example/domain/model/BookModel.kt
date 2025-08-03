package com.example.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class BookModel(
    val information: InformationModel? = null
) : Parcelable

@Keep
@Parcelize
data class InformationModel(
    val title: String? = null,
    val subtitle: String? = null,
    val authors: List<String>? = null,
    val cover: String? = null,
    val pageCount: Int? = null,
    val currentPage: Int? = null
) : Parcelable