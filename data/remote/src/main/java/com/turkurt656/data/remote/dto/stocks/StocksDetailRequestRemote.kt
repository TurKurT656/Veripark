package com.turkurt656.data.remote.dto.stocks

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StocksDetailRequestRemote(
    @field:Json(name = "id")
    val id: String
)