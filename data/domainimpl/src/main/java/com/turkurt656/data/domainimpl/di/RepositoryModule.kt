package com.turkurt656.data.domainimpl.di

import com.turkurt656.data.domain.crypto.AESCryptoManager
import com.turkurt656.data.domain.repository.AuthRepository
import com.turkurt656.data.domain.repository.StocksRepository
import com.turkurt656.data.domainimpl.crypto.AESCryptoManagerImpl
import com.turkurt656.data.domainimpl.repository.AuthRepositoryImpl
import com.turkurt656.data.domainimpl.repository.StocksRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<AESCryptoManager> { AESCryptoManagerImpl() }

    single<AuthRepository> { AuthRepositoryImpl(get(), get(), get()) }
    single<StocksRepository> { StocksRepositoryImpl(get(), get()) }

}