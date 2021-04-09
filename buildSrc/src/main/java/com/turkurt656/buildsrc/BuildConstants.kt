package com.turkurt656.buildsrc

import org.gradle.api.JavaVersion

object BuildConstants {

    const val projectName = "Veripark"

    const val applicationId = "com.turkurt656.veripark"

    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val compileSdkVersion = 30

    val jdkVersion = JavaVersion.VERSION_1_8

    const val versionCode = 1
    const val versionName = "0.1.0"

    const val proguardRules = "proguard-rules.pro"
    const val consumerRules = "consumer-rules.pro"
    const val proguardAndroid = "proguard-android-optimize.txt"

}