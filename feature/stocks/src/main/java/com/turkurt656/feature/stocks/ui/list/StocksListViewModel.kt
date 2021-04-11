package com.turkurt656.feature.stocks.ui.list

import com.turkurt656.common.core.base.BaseViewModel
import com.turkurt656.common.core.ktx.*
import com.turkurt656.data.domain.dto.stocks.Period
import com.turkurt656.data.domain.dto.stocks.Stocks
import com.turkurt656.data.domain.usecase.stocks.GetStocksListUseCase

class StocksListViewModel(
    private val getStocksListUseCase: GetStocksListUseCase,
) : BaseViewModel() {

    private val _stocksResult = MutableLiveResult<List<Stocks>>()
    val stocksResult: LiveResult<List<Stocks>> = _stocksResult


    init {
        launch {
            getStocksListUseCase(Period.ALL).collectOnLiveData(
                _stocksResult,
                this@StocksListViewModel
            )
        }
    }

}