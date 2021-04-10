package com.turkurt656.data.domain.repository

import com.turkurt656.data.domain.dto.auth.HandShakeResponse
import com.turkurt656.data.domain.result.FlowResult

interface AuthRepository {

    fun handShake(): FlowResult<HandShakeResponse>

}