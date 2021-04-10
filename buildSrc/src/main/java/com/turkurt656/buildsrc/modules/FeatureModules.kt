package com.turkurt656.buildsrc.modules

object FeatureModules {

    object Paths {
        const val feature = "feature"

        const val splash = "splash"
    }

    val splash = module(Paths.feature, Paths.splash)

}