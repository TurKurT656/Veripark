package com.turkurt656.feature.stocks.di

import com.turkurt656.feature.stocks.ui.list.StocksListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val stocksModule = module {

    viewModel { StocksListViewModel() }

}