package com.turkurt656.buildsrc.deps

object KotlinDeps {

    object Versions {
        const val kotlin = "1.4.10"
    }

    val kotlin = dependency("org.jetbrains.kotlin:kotlin-stdlib", Versions.kotlin)

}