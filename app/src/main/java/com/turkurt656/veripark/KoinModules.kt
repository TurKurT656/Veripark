package com.turkurt656.veripark

import com.turkurt656.data.remote.di.networkModule
import com.turkurt656.library.core.di.GlobalQualifiers.IS_DEBUG
import org.koin.dsl.module

val appModule = module {

    // Inject BuildConfig fields here
    // Since we want to access them even in pure Kotlin modules

    factory(IS_DEBUG) { BuildConfig.DEBUG }

}

val koinModules = listOf(
    appModule,
    networkModule,
)