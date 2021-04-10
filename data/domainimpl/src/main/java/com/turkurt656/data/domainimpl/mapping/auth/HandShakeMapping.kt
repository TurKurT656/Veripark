package com.turkurt656.data.domainimpl.mapping.auth

import com.turkurt656.data.domain.dto.auth.HandShakeRequest
import com.turkurt656.data.domain.dto.auth.HandShakeResponse
import com.turkurt656.data.remote.dto.auth.HandShakeRequestRemote
import com.turkurt656.data.remote.dto.auth.HandShakeResponseRemote

fun HandShakeRequest.toRemote() =
    HandShakeRequestRemote(deviceId, systemVersion, platform.toString(), deviceModel, manufacturer)

fun HandShakeResponseRemote.toDomain() =
    HandShakeResponse(aesKey, aesIV, authorization, lifeTime)