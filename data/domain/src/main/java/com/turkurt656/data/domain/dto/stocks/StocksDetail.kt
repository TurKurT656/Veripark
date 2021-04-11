package com.turkurt656.data.domain.dto.stocks


data class StocksDetail(
    val isDown: Boolean,
    val bid: Double,
    val change: Double,
    val count: Long,
    val difference: Double,
    val offer: Double,
    val highest: Double,
    val lowest: Double,
    val maximum: Double,
    val minimum: Double,
    val price: Double,
    val volume: Double,
    val symbol: String,
    val graphicData: List<GraphicData>,
)

data class GraphicData(
    val day: Int,
    val value: Double,
)