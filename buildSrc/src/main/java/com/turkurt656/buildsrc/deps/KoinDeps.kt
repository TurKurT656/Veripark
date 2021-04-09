package com.turkurt656.buildsrc.deps

object KoinDeps {

    object Versions {
        const val koin = "2.2.1"
    }

    val core = dependency("org.koin:koin-core", Versions.koin)
    val coreExt = dependency("org.koin:koin-core-ext", Versions.koin)
    val android = dependency("org.koin:koin-android", Versions.koin)
    val androidxScope = dependency("org.koin:koin-androidx-scope", Versions.koin)
    val androidxViewModel = dependency("org.koin:koin-androidx-viewmodel", Versions.koin)
    val androidxFragment = dependency("org.koin:koin-androidx-fragment", Versions.koin)
    val androidxWorkManager = dependency("org.koin:koin-androidx-workmanager", Versions.koin)
    val androidxExt = dependency("org.koin:koin-androidx-ext", Versions.koin)

}