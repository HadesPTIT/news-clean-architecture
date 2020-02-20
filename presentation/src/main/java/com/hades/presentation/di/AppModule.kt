package com.hades.presentation.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by Hades on 2/20/2020.
 */
val appModule = module {
    single {
        androidApplication().resources
    }
}


