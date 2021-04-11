package com.turkurt656.data.domainimpl.repository

import com.turkurt656.data.domain.crypto.AESCryptoManager
import com.turkurt656.data.domain.dto.stocks.Period
import com.turkurt656.data.domain.dto.stocks.Stocks
import com.turkurt656.data.domain.dto.stocks.StocksDetail
import com.turkurt656.data.domain.repository.StocksRepository
import com.turkurt656.data.domain.result.FlowResult
import com.turkurt656.data.domainimpl.mapping.stocks.toDomain
import com.turkurt656.data.domainimpl.result.flowResult
import com.turkurt656.data.remote.api.StocksApi
import com.turkurt656.data.remote.dto.stocks.StocksDetailRequestRemote
import com.turkurt656.data.remote.dto.stocks.StocksListRequestRemote
import java.util.*


class StocksRepositoryImpl(
    private val stocksApi: StocksApi,
    private val aesCryptoManager: AESCryptoManager,
) : StocksRepository {

    override fun getStocksList(
        period: Period,
    ): FlowResult<List<Stocks>> =
        flowResult {
            val encryptedPeriod =
                aesCryptoManager.encrypt(period.toString().toLowerCase(Locale.ENGLISH))
            stocksApi.getStocksList(StocksListRequestRemote(encryptedPeriod))
                .toDomain().map {
                    it.copy(symbol = aesCryptoManager.decrypt(it.symbol))
                }
        }

    override fun getStocksDetail(
        id: Long
    ): FlowResult<StocksDetail> =
        flowResult {
            val encryptedId = aesCryptoManager.encrypt(id.toString())
            stocksApi.getStocksDetail(StocksDetailRequestRemote(encryptedId))
                .toDomain().run { copy(symbol = aesCryptoManager.decrypt(symbol)) }
        }
}