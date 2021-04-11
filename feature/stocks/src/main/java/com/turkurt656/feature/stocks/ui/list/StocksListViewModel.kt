package com.turkurt656.feature.stocks.ui.list

import androidx.lifecycle.MutableLiveData
import com.turkurt656.common.core.base.BaseViewModel
import com.turkurt656.common.core.ktx.*
import com.turkurt656.data.domain.dto.stocks.Period
import com.turkurt656.data.domain.dto.stocks.Stocks
import com.turkurt656.data.domain.result.Result
import com.turkurt656.data.domain.usecase.stocks.GetStocksListUseCase
import com.turkurt656.library.lifecycle.ktx.combine

class StocksListViewModel(
    private val getStocksListUseCase: GetStocksListUseCase,
) : BaseViewModel() {

    private val _stocksResult = MutableLiveResult<List<Stocks>>()

    val searchQuery = MutableLiveData<String>()

    val stocksList = combine(_stocksResult, searchQuery) { stocksResult, searchQuery ->
        when (stocksResult) {
            is Result.Success -> {
                if (searchQuery.isNullOrBlank()) return@combine stocksResult.data
                return@combine stocksResult.data.filter { it.symbol.contains(searchQuery, true) }
            }
            else -> return@combine emptyList()
        }
    }

    init {
        getStocksList(Period.ALL)
    }

    fun getStocksList(period: Period) = launch {
        getStocksListUseCase(period).collectOnLiveData(
            _stocksResult,
            this@StocksListViewModel
        )
    }

    fun onStocksClicked(stocks: Stocks) {
        navigateTo(StocksListFragmentDirections.toDetail(stocks.id))
    }

}