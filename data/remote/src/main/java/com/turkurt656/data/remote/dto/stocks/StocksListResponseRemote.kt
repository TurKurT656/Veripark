package com.turkurt656.data.remote.dto.stocks

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StocksListResponseRemote(
    @field:Json(name = "stocks")
    val stocks: List<StocksRemote>
)

@JsonClass(generateAdapter = true)
data class StocksRemote(
    @field:Json(name = "id")
    val id: Long,
    @field:Json(name = "isDown")
    val isDown: Boolean,
    @field:Json(name = "bid")
    val bid: Double,
    @field:Json(name = "difference")
    val difference: Double,
    @field:Json(name = "offer")
    val offer: Double,
    @field:Json(name = "price")
    val price: Double,
    @field:Json(name = "volume")
    val volume: Double,
    @field:Json(name = "symbol")
    val symbol: String,
)