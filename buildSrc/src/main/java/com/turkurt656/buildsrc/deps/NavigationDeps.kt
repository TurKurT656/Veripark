package com.turkurt656.buildsrc.deps

object NavigationDeps {

    object Versions {
        const val navigation = "2.3.1"
    }

    val fragmentKtx = dependency("androidx.navigation:navigation-fragment-ktx", Versions.navigation)
    val uiKtx =  dependency("androidx.navigation:navigation-ui-ktx", Versions.navigation)

}