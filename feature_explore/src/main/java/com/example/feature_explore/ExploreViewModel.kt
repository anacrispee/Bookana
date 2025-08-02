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

    private val _books = MutableStateFlow<List<BookModel>>(emptyList())
    private val _isLoading = MutableStateFlow(false)

    val books: StateFlow<List<BookModel>> = _books
    val isLoading: StateFlow<Boolean> = _isLoading

    fun searchBooksByName(
        name: String = "Harry Potter"
    ) {
        if (books.value.isEmpty().not()) return

        _isLoading.value = true
        searchBooksByNameUseCases(
            params = name,
            onSuccess = {
                _isLoading.value = false
                _books.value = it
            },
            onError = {
                _isLoading.value = false
            }
        )
    }
}