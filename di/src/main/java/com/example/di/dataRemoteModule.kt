package com.example.di

import com.example.data.datasource.BooksRemoteDataSource
import com.example.data_remote.datasource.BooksRemoteDataSourceImpl
import com.example.data_remote.services.BooksService
import com.example.data_remote.utils.RequestWrapper
import com.example.data_remote.utils.RequestWrapperImpl
import com.example.data_remote.utils.Routes
import com.example.data_remote.utils.WebServiceFactory
import org.koin.dsl.bind
import org.koin.dsl.module

val dataRemoteModule = module {
    single {
        WebServiceFactory.provideOkHttpClient()
    }

    single {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = Routes.OPEN_LIBRARY_DOMAIN
        ) as BooksService
    }

    single { RequestWrapperImpl() } bind RequestWrapper::class

    single<BooksRemoteDataSource> { BooksRemoteDataSourceImpl(get()) }
}