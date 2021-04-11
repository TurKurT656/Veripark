package com.turkurt656.data.domainimpl.mapping.stocks

import com.turkurt656.data.domain.dto.stocks.GraphicData
import com.turkurt656.data.domain.dto.stocks.StocksDetail
import com.turkurt656.data.remote.dto.stocks.GraphicDataRemote
import com.turkurt656.data.remote.dto.stocks.StocksDetailRemote

fun StocksDetailRemote.toDomain() =
    StocksDetail(isDown, bid, change, count, difference, offer, highest, lowest, maximum,
     minimum, price, volume, symbol, graphicData.toDomain())

fun GraphicDataRemote.toDomain() =
    GraphicData(day, value)

fun List<GraphicDataRemote>.toDomain() =
    map { it.toDomain() }