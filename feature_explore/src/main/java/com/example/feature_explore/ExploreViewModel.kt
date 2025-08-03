package com.example.feature_explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.BookModel
import com.example.domain.usecase.SearchBooksByNameUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class ExploreViewModel : ViewModel(), KoinComponent {
    private val searchBooksByNameUseCases : SearchBooksByNameUseCases by inject { parametersOf(viewModelScope) }

    private val _uiState = MutableStateFlow<UiState<List<BookModel>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<BookModel>>> = _uiState

    fun searchBooksByName(
        name: String = "Harry Potter"
    ) {
        if (uiState.value is UiState.Empty) return
        _uiState.value = UiState.Loading

        searchBooksByNameUseCases(
            params = name,
            onSuccess = { books ->
                _uiState.value = if (books.isEmpty()) UiState.Empty else UiState.Success(books)
            },
            onError = {
                _uiState.value = UiState.Error
            }
        )
    }
}