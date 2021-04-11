package com.turkurt656.data.domain.repository

import com.turkurt656.data.domain.dto.stocks.Period
import com.turkurt656.data.domain.dto.stocks.Stocks
import com.turkurt656.data.domain.result.FlowResult

interface StocksRepository {

    fun getStocksList(period: Period): FlowResult<List<Stocks>>

}