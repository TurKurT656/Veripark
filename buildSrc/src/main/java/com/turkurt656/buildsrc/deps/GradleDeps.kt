package com.turkurt656.buildsrc.deps


object GradleDeps {

    object Versions {
        const val androidPlugin = "4.1.1"
        const val buildTools = "30.0.0"
    }

    val androidPlugin = dependency("com.android.tools.build:gradle", Versions.androidPlugin)
    val kotlinPlugin = dependency("org.jetbrains.kotlin:kotlin-gradle-plugin", KotlinDeps.Versions.kotlin)
    val koinPlugin = dependency("org.koin:koin-gradle-plugin", KoinDeps.Versions.koin)
    val safeArgsPlugin = dependency("androidx.navigation:navigation-safe-args-gradle-plugin", NavigationDeps.Versions.navigation)

}