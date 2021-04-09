package com.turkurt656.buildsrc.modules

object CommonModules {

    object Paths {
        const val common = "common"

        const val core = "core"
    }

    // All Presentation base and shared functionality goes here
    val core = module(Paths.common, Paths.core)

}