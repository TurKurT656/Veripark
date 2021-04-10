package com.turkurt656.feature.splash.ui

import com.turkurt656.common.core.base.BaseViewModel
import com.turkurt656.common.core.ktx.LiveResult
import com.turkurt656.common.core.ktx.MutableLiveResult
import com.turkurt656.common.core.ktx.collectOnLiveData
import com.turkurt656.common.core.ktx.launch
import com.turkurt656.data.domain.dto.auth.HandShakeResponse
import com.turkurt656.data.domain.usecase.auth.HandShakeUseCase
import com.turkurt656.feature.splash.SplashNavigationDirections

class SplashViewModel(
    private val handShakeUseCase: HandShakeUseCase,
) : BaseViewModel() {

    private val _handShakeResult = MutableLiveResult<HandShakeResponse>()
    val handShakeResponse: LiveResult<HandShakeResponse> = _handShakeResult

    fun proceed() = launch {
        handShakeUseCase().collectOnLiveData(
            _handShakeResult,
            this@SplashViewModel,
            onSuccess = {
                navigateTo(SplashNavigationDirections.toStocks())
            }
        )
    }

}