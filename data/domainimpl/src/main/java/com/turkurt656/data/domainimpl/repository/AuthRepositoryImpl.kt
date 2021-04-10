package com.turkurt656.data.domainimpl.repository

import android.os.Build
import com.turkurt656.data.domain.dto.auth.HandShakeRequest
import com.turkurt656.data.domain.dto.auth.HandShakeResponse
import com.turkurt656.data.domain.dto.auth.Platform
import com.turkurt656.data.domain.repository.AuthRepository
import com.turkurt656.data.domain.result.FlowResult
import com.turkurt656.data.domain.token.TokenHolder
import com.turkurt656.data.domainimpl.mapping.auth.toDomain
import com.turkurt656.data.domainimpl.mapping.auth.toRemote
import com.turkurt656.data.domainimpl.result.flowResult
import com.turkurt656.data.remote.api.AuthApi
import java.util.*


class AuthRepositoryImpl(
    private val authApi: AuthApi,
    private val tokenHolder: TokenHolder,
) : AuthRepository {

    private var aesKey: String = ""
    private var aesIV: String = ""

    override fun handShake(): FlowResult<HandShakeResponse> =
        flowResult {
            authApi.handShake(
                HandShakeRequest(
                    UUID.randomUUID().toString(),
                    Build.VERSION.RELEASE,
                    if (isEmulator()) Platform.ANDROID_EMULATOR else Platform.ANDROID,
                    Build.MODEL,
                    Build.MANUFACTURER,
                ).toRemote()
            ).toDomain().also {
                tokenHolder.updateAuthorizationToken(it.authorization)
                aesKey = it.aesKey
                aesIV = it.aesIV
            }
        }

    private fun isEmulator(): Boolean =
        Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || Build.PRODUCT == "google_sdk"
                || Build.HARDWARE.contains("goldfish")
                || Build.HARDWARE.contains("ranchu")

}