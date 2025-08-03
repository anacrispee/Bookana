package com.example.feature_explore

sealed class UiState<out T> {
    data class Success<T>(val data: T) : UiState<T>()

    object Loading : UiState<Nothing>()
    object Error : UiState<Nothing>()
    object Empty : UiState<Nothing>()
}