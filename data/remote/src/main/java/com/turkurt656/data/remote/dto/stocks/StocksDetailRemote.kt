package com.turkurt656.data.remote.dto.stocks

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StocksDetailRemote(
    @field:Json(name = "isDown")
    val isDown: Boolean,
    @field:Json(name = "bid")
    val bid: Double,
    @field:Json(name = "channge")
    val change: Double,
    @field:Json(name = "count")
    val count: Double,
    @field:Json(name = "difference")
    val difference: Double,
    @field:Json(name = "offer")
    val offer: Double,
    @field:Json(name = "highest")
    val highest: Double,
    @field:Json(name = "lowest")
    val lowest: Double,
    @field:Json(name = "maximum")
    val maximum: Double,
    @field:Json(name = "minimum")
    val minimum: Double,
    @field:Json(name = "price")
    val price: Double,
    @field:Json(name = "volume")
    val volume: Double,
    @field:Json(name = "symbol")
    val symbol: String,
    @field:Json(name = "graphicData")
    val graphicData: List<GraphicDataRemote>,
)

@JsonClass(generateAdapter = true)
data class GraphicDataRemote(
    @field:Json(name = "day")
    val day: Int,
    @field:Json(name = "value")
    val value: Double,
)