package com.turkurt656.buildsrc.deps

object CoroutinesDeps {

    object Versions {
        const val coroutines = "1.4.1"
    }

    val core = dependency("org.jetbrains.kotlinx:kotlinx-coroutines-core", Versions.coroutines)
    val android = dependency("org.jetbrains.kotlinx:kotlinx-coroutines-android", Versions.coroutines)

}