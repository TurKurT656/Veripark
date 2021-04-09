package com.turkurt656.buildsrc.deps

object AndroidxDeps {

    object Versions {
        const val coreKtx = "1.3.2"
        const val appCompat = "1.2.0"
        const val constraintLayout = "2.0.4"
        const val fragment = "1.2.5"
    }

    val coreKtx = dependency("androidx.core:core-ktx", Versions.coreKtx)
    val appCompat = dependency("androidx.appcompat:appcompat", Versions.appCompat)
    val constraintLayout = dependency("androidx.constraintlayout:constraintlayout", Versions.constraintLayout)
    val fragmentKtx = dependency("androidx.fragment:fragment-ktx", Versions.fragment)

}