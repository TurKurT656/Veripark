package com.turkurt656.buildsrc.deps

object SerializerDeps {

    object Versions {
        const val moshi = "1.11.0"
    }

    val moshiConverter = dependency("com.squareup.retrofit2:converter-moshi", NetworkDeps.Versions.retrofit)
    val moshi = dependency("com.squareup.moshi:moshi", Versions.moshi)
    val moshiCodeGen = dependency("com.squareup.moshi:moshi-kotlin-codegen", Versions.moshi)
    val moshiAdapters = dependency("com.squareup.moshi:moshi-adapters", Versions.moshi)

}