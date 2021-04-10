package com.turkurt656.data.remote.dto.auth

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class HandShakeResponseRemote(
    @field:Json(name = "aesKey")
    val aesKey: String,
    @field:Json(name = "aesIV")
    val aesIV: String,
    @field:Json(name = "authorization")
    val authorization: String,
    @field:Json(name = "lifeTime")
    val lifeTime: Date,
)