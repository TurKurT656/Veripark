package com.turkurt656.data.remote.api

import com.turkurt656.data.remote.dto.stocks.StocksDetailRemote
import com.turkurt656.data.remote.dto.stocks.StocksDetailRequestRemote
import com.turkurt656.data.remote.dto.stocks.StocksListRequestRemote
import com.turkurt656.data.remote.dto.stocks.StocksListResponseRemote
import retrofit2.http.Body
import retrofit2.http.POST

interface StocksApi {

    @POST("stocks/list")
    suspend fun getStocksList(@Body params: StocksListRequestRemote): StocksListResponseRemote

    @POST("stocks/detail")
    suspend fun getStocksDetail(@Body params: StocksDetailRequestRemote): StocksDetailRemote

}