package com.example.data_remote.datasource

import com.example.data.datasource.BooksRemoteDataSource
import com.example.data_remote.mapper.SearchBookMapper
import com.example.data_remote.services.BooksService
import com.example.data_remote.utils.RequestWrapper
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BooksRemoteDataSourceImpl(
    private val webService: BooksService
) : BooksRemoteDataSource, KoinComponent {

    private val requestWrapper: RequestWrapper by inject()

    override fun searchBook(query: String) = flow {
        emit(
            SearchBookMapper.toDomain(
                requestWrapper.wrapperGenericResponse {
                    webService.searchBook(query)
                }
            )
        )
    }
}