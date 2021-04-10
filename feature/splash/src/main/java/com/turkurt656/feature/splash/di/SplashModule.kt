package com.turkurt656.feature.splash.di

import com.turkurt656.feature.splash.ui.SplashViewModel
import com.turkurt656.library.core.di.UseCaseQualifiers.HAND_SHAKE
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {

    viewModel { SplashViewModel(get(HAND_SHAKE)) }

}