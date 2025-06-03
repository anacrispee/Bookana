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
    val books: StateFlow<List<BookModel>> = _books

    fun searchBooksByName(
        name: String = "Harry Potter"
    ) {
        searchBooksByNameUseCases(
            params = name,
            onSuccess = {
                _books.value = it
            },
            onError = {
            }
        )
    }
}