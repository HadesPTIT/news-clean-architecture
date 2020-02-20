package com.hades.presentation

import android.app.Application
import com.hades.presentation.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Hades on 2/19/2020.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                modules = listOf(
                    appModule,
                    networkModule,
                    repositoryModule,
                    viewModelModule,
                    localModule,
                    useCaseModule
                )
            )
        }
    }

}