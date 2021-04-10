package com.turkurt656.veripark

import com.turkurt656.data.domainimpl.di.repositoryModule
import com.turkurt656.data.domainimpl.di.useCaseModule
import com.turkurt656.data.local.di.dataStoreModule
import com.turkurt656.data.remote.di.apiModule
import com.turkurt656.data.remote.di.networkModule
import com.turkurt656.feature.splash.di.splashModule
import com.turkurt656.library.core.di.GlobalQualifiers.IS_DEBUG
import org.koin.dsl.module

val appModule = module {

    // Inject BuildConfig fields here
    // Since we want to access them even in pure Kotlin modules

    factory(IS_DEBUG) { BuildConfig.DEBUG }

}

val koinModules = listOf(
    appModule,
    repositoryModule,
    useCaseModule,
    networkModule,
    apiModule,
    dataStoreModule,
    splashModule,
)