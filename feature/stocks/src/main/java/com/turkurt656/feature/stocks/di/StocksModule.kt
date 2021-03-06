package com.turkurt656.feature.stocks.di

import com.turkurt656.feature.stocks.ui.detail.StocksDetailViewModel
import com.turkurt656.feature.stocks.ui.list.StocksAdapter
import com.turkurt656.feature.stocks.ui.list.StocksListViewModel
import com.turkurt656.library.core.di.UseCaseQualifiers.GET_STOCKS_DETAIL
import com.turkurt656.library.core.di.UseCaseQualifiers.GET_STOCKS_LIST
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val stocksModule = module {

    viewModel { StocksListViewModel(get(GET_STOCKS_LIST)) }
    viewModel { (id: Long) -> StocksDetailViewModel(id, get(GET_STOCKS_DETAIL)) }

    factory { StocksAdapter() }

}