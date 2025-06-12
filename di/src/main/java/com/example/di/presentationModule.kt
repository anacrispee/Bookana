package com.example.di

import com.example.feature_explore.ExploreViewModel
import com.example.features.book_list.BookListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { ExploreViewModel() }
    viewModel { BookListViewModel() }
}