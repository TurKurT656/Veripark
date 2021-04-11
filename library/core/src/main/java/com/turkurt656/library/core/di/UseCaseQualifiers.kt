package com.turkurt656.library.core.di

import org.koin.core.qualifier.named

object UseCaseQualifiers {

    val HAND_SHAKE = named("HAND_SHAKE")
    val GET_STOCKS_LIST = named("GET_STOCKS_LIST")

}