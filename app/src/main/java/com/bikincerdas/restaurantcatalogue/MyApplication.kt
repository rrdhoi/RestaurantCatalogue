package com.bikincerdas.restaurantcatalogue

import android.app.Application
import com.bikincerdas.core.di.databaseModule
import com.bikincerdas.core.di.networkModule
import com.bikincerdas.core.di.repositoryModule
import com.bikincerdas.restaurantcatalogue.di.useCaseModule
import com.bikincerdas.restaurantcatalogue.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}