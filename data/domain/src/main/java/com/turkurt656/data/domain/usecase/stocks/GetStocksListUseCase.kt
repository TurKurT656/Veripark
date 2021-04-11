package com.turkurt656.data.domain.usecase.stocks

import com.turkurt656.data.domain.dto.stocks.Period
import com.turkurt656.data.domain.dto.stocks.Stocks
import com.turkurt656.data.domain.result.FlowResult

typealias GetStocksListUseCase = (period: Period) -> FlowResult<List<Stocks>>