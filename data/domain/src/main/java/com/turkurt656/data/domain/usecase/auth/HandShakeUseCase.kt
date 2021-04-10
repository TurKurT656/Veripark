package com.turkurt656.data.domain.usecase.auth

import com.turkurt656.data.domain.dto.auth.HandShakeResponse
import com.turkurt656.data.domain.result.FlowResult

typealias HandShakeUseCase = () -> FlowResult<HandShakeResponse>