package com.turkurt656.data.domainimpl.di

import com.turkurt656.data.domain.repository.AuthRepository
import com.turkurt656.data.domain.token.TokenHolder
import com.turkurt656.data.domainimpl.repository.AuthRepositoryImpl
import com.turkurt656.data.domainimpl.token.TokenHolderImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<TokenHolder> { TokenHolderImpl() }

    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }

}