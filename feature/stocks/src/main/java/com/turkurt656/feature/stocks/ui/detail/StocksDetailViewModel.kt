package com.turkurt656.feature.stocks.ui.detail

import com.turkurt656.common.core.base.BaseViewModel
import com.turkurt656.common.core.ktx.MutableLiveResult
import com.turkurt656.common.core.ktx.collectOnLiveData
import com.turkurt656.common.core.ktx.launch
import com.turkurt656.common.core.ktx.mapData
import com.turkurt656.data.domain.dto.stocks.StocksDetail
import com.turkurt656.data.domain.usecase.stocks.GetStocksDetailUseCase

class StocksDetailViewModel(
    val id: Long,
    private val getStocksDetailUseCase: GetStocksDetailUseCase,
): BaseViewModel() {

    private val _stocksDetailResult = MutableLiveResult<StocksDetail>()
    val stocksDetail = _stocksDetailResult.mapData()

    init {
        launch {
            getStocksDetailUseCase(id).collectOnLiveData(
                _stocksDetailResult,
                this@StocksDetailViewModel
            )
        }

    }

}