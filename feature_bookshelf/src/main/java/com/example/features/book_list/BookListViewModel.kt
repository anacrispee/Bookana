package com.example.features.book_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.BookModel
import com.example.domain.usecase.GetAllBooksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class BookListViewModel : ViewModel(), KoinComponent {
    private val getAllBooksUseCase : GetAllBooksUseCase by inject { parametersOf(viewModelScope) }

    private val _books = MutableStateFlow<List<BookModel>>(emptyList())
    private val _isLoading = MutableStateFlow(false)

    val books: StateFlow<List<BookModel>> = _books
    val isLoading: StateFlow<Boolean> = _isLoading

    private fun getAllBooksUseCase() {

    }
}