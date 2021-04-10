package com.turkurt656.data.domain.dto.auth

data class HandShakeRequest(
    val deviceId: String,
    val systemVersion: String,
    val platform: Platform,
    val deviceModel: String,
    val manufacturer: String,
)

enum class Platform {
    ANDROID {
        override fun toString() = "Android"
    },
    ANDROID_EMULATOR {
        override fun toString() = "AndroidSimulator"
    }
}