package com.turkurt656.data.domain.usecase.stocks

import com.turkurt656.data.domain.dto.stocks.StocksDetail
import com.turkurt656.data.domain.result.FlowResult

typealias GetStocksDetailUseCase = (id: Long) -> FlowResult<StocksDetail>