package com.turkurt656.buildsrc.modules

object FeatureModules {

    object Paths {
        const val feature = "feature"

        const val splash = "splash"
        const val stocks = "stocks"
    }

    val splash = module(Paths.feature, Paths.splash)
    val stocks = module(Paths.feature, Paths.stocks)

}