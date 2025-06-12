package com.example.domain.utils

fun String.removeUrlScheme() = this.replace("http://", "https://")

fun String.replaceWithEllipsis(maxLength: Int = 20): String {
    return if (this.length > maxLength) {
        this.take(maxLength) + "..."
    } else this
}