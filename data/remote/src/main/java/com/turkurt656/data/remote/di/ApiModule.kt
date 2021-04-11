package com.turkurt656.data.remote.di

import com.turkurt656.data.remote.api.AuthApi
import com.turkurt656.data.remote.api.StocksApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val apiModule = module {

    factory<AuthApi> { get<Retrofit>().create() }
    factory<StocksApi> { get<Retrofit>().create() }

}