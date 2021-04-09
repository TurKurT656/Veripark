package com.turkurt656.buildsrc.modules

object LibraryModules {

    object Paths {
        const val library = "library"

        const val core = "core"
    }

    // All Core functionality must be implemented in here.
    // This is a pure kotlin module and all modules have dependency on this module
    val core = module(Paths.library, Paths.core)

}