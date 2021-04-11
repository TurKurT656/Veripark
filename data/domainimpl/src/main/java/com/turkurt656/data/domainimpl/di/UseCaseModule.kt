package com.turkurt656.data.domainimpl.di

import com.turkurt656.data.domain.repository.AuthRepository
import com.turkurt656.data.domain.repository.StocksRepository
import com.turkurt656.data.domain.usecase.auth.HandShakeUseCase
import com.turkurt656.data.domain.usecase.stocks.GetStocksDetailUseCase
import com.turkurt656.data.domain.usecase.stocks.GetStocksListUseCase
import com.turkurt656.library.core.di.UseCaseQualifiers.GET_STOCKS_DETAIL
import com.turkurt656.library.core.di.UseCaseQualifiers.GET_STOCKS_LIST
import com.turkurt656.library.core.di.UseCaseQualifiers.HAND_SHAKE
import org.koin.dsl.module

val useCaseModule = module {

    factory<HandShakeUseCase>(HAND_SHAKE) { get<AuthRepository>()::handShake }
    factory<GetStocksListUseCase>(GET_STOCKS_LIST) { get<StocksRepository>()::getStocksList }
    factory<GetStocksDetailUseCase>(GET_STOCKS_DETAIL) { get<StocksRepository>()::getStocksDetail }

}