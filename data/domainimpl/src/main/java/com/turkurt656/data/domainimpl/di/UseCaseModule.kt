package com.turkurt656.data.domainimpl.di

import com.turkurt656.data.domain.repository.AuthRepository
import com.turkurt656.data.domain.usecase.auth.HandShakeUseCase
import com.turkurt656.library.core.di.UseCaseQualifiers.HAND_SHAKE
import org.koin.dsl.module

val useCaseModule = module {

    factory<HandShakeUseCase>(HAND_SHAKE) { get<AuthRepository>()::handShake }

}