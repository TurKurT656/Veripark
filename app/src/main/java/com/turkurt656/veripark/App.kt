package com.turkurt656.veripark

import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.util.*

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        // Init Koin
        startKoin {
            androidContext(this@App)
            modules(koinModules)
        }

    }

}