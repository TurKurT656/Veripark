package com.turkurt656.data.local.di

import androidx.datastore.preferences.createDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val APP_DATA_STORE = "app_data_store"

val dataStoreModule = module {

    single {
        androidContext().createDataStore(APP_DATA_STORE)
    }

}