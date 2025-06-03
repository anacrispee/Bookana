package com.example.bookana

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.di.dataModule
import com.example.di.dataRemoteModule
import com.example.di.domainModule
import com.example.di.presentationModule
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            modules(
                listOf(
                    dataModule,
                    domainModule,
                    presentationModule,
                    dataRemoteModule
                )
            ).androidContext(applicationContext)
        }
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.setGraph(R.navigation.main_nav_graph)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setupWithNavController(navController)
    }
}