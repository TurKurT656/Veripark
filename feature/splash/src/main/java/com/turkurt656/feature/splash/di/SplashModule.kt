package com.turkurt656.feature.splash.di

import com.turkurt656.feature.splash.ui.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {

    viewModel { SplashViewModel() }

}