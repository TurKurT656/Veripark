package com.turkurt656.data.domain.dto.stocks

data class Stocks(
    val id: Long,
    val isDown: Boolean,
    val bid: Double,
    val difference: Double,
    val offer: Double,
    val price: Double,
    val volume: Double,
    val symbol: String,
)

enum class Period {
    ALL, INCREASING, DECREASING, VOLUME30, VOLUME50, VOLUME100
}