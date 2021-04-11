package com.turkurt656.data.domainimpl.mapping.stocks

import com.turkurt656.data.domain.dto.stocks.Stocks
import com.turkurt656.data.remote.dto.stocks.StocksListResponseRemote
import com.turkurt656.data.remote.dto.stocks.StocksRemote

fun StocksListResponseRemote.toDomain() =
    stocks.map { it.toDomain() }

fun StocksRemote.toDomain() =
    Stocks(id, isDown, bid, difference, offer, price, volume, symbol)