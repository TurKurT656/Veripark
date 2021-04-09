package com.turkurt656.buildsrc.deps

object AndroidDeps {

    object Versions {
        const val multidex = "1.0.3"
    }

    val multidex = dependency("com.android.support:multidex", Versions.multidex)

}