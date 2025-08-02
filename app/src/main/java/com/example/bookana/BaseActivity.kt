package com.example.bookana

import android.app.Application
import com.example.di.dataLocalModule
import com.example.di.dataModule
import com.example.di.dataRemoteModule
import com.example.di.databaseModule
import com.example.di.domainModule
import com.example.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BaseActivity : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseActivity)
            modules(
                listOf(
                    dataModule,
                    databaseModule,
                    domainModule,
                    presentationModule,
                    dataLocalModule,
                    dataRemoteModule
                )
            )
        }
    }
}