package com.turkurt656.buildsrc.deps

object DataStoreDeps {

    object Versions {
        const val dataStore = "1.0.0-alpha06"
    }

    val core = dependency("androidx.datastore:datastore-core", Versions.dataStore)
    val android = dependency("androidx.datastore:datastore", Versions.dataStore)
    val corePreferences = dependency("androidx.datastore:datastore-preferences-core", Versions.dataStore)
    val androidPreferences = dependency("androidx.datastore:datastore-preferences", Versions.dataStore)

}