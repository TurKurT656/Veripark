package com.turkurt656.data.domain.dto.auth

import java.util.*

data class HandShakeResponse(
    val aesKey: String,
    val aesIV: String,
    val authorization: String,
    val lifeTime: Date,
)