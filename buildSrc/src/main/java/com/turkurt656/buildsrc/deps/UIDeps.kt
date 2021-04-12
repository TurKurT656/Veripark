package com.turkurt656.buildsrc.deps

object UIDeps {

    object Versions {
        const val material = "1.2.1"
        const val chart = "3.1.0"
    }

    val material = dependency("com.google.android.material:material", Versions.material)
    val chart = dependency("com.github.PhilJay:MPAndroidChart", Versions.chart)

}