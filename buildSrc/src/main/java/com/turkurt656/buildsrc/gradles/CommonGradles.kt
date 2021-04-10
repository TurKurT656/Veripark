package com.turkurt656.buildsrc.gradles

object CommonGradles {

    val kotlin = gradle("common.kotlin.gradle")
    val android = gradle("common.android.gradle")
    val androidLibrary = gradle("common.android.library.gradle")
    val feature = gradle("common.android.feature.gradle")

}