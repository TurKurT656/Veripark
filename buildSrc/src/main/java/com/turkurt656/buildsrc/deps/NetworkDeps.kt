package com.turkurt656.buildsrc.deps

object NetworkDeps {

    object Versions {
        const val retrofit = "2.9.0"
        const val okhttp3 = "3.12.0"
    }

    val retrofit = dependency("com.squareup.retrofit2:retrofit", Versions.retrofit)
    val okhttp3 = dependency("com.squareup.okhttp3:okhttp", Versions.okhttp3)
    val loggingInterceptor = dependency("com.squareup.okhttp3:logging-interceptor", Versions.okhttp3)

}