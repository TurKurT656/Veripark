package com.turkurt656.buildsrc.deps

object LifecycleDeps {

    object Versions {
        const val lifecycle = "2.2.0"
        const val liveEvent = "1.2.0"
    }

    val viewModel =  dependency("androidx.lifecycle:lifecycle-viewmodel-ktx", Versions.lifecycle)
    val liveData =  dependency("androidx.lifecycle:lifecycle-livedata-ktx", Versions.lifecycle)
    val commonJava8 =  dependency("androidx.lifecycle:lifecycle-common-java8", Versions.lifecycle)
    val service =  dependency("androidx.lifecycle:lifecycle-service", Versions.lifecycle)
    val process =  dependency("androidx.lifecycle:lifecycle-process", Versions.lifecycle)
    val liveEvent = dependency("com.github.hadilq.liveevent:liveevent", Versions.liveEvent)

}