package com.turkurt656.common.core.ktx

import com.turkurt656.common.core.base.BaseViewModel
import com.turkurt656.data.domain.result.ResultException

fun BaseViewModel.handleCommonExceptions(e: ResultException) {
    // Handle UI scenarios based on exception
    // For example we can navigate to login page if we get a Http 401 exception and...
}