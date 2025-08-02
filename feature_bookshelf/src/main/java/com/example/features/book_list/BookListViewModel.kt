package com.example.features.book_list

import androidx.lifecycle.ViewModel
import com.example.domain.model.BookModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.KoinComponent

class BookListViewModel : ViewModel(), KoinComponent {

    private val _books = MutableStateFlow<List<BookModel>>(emptyList())
    private val _isLoading = MutableStateFlow(false)

    val books: StateFlow<List<BookModel>> = _books
    val isLoading: StateFlow<Boolean> = _isLoading

    private fun getAllBooksUseCase() {
    }
}