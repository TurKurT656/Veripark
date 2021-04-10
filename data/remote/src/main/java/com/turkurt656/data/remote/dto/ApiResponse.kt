package com.turkurt656.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(
    @field:Json(name = "status")
    val status: Status,
    // Other fields
)

@JsonClass(generateAdapter = true)
data class Status(
    @field:Json(name = "isSuccess")
    val isSuccess: Boolean,
    @field:Json(name = "error")
    val error: Error,
)

@JsonClass(generateAdapter = true)
data class Error(
    @field:Json(name = "code")
    val code: Int,
    @field:Json(name = "message")
    val message: String,
)