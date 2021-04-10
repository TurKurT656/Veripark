@file:Suppress("EXPERIMENTAL_API_USAGE")

package com.turkurt656.data.domain.ktx

import com.turkurt656.data.domain.result.FlowResult
import com.turkurt656.data.domain.result.Result
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow

inline fun <T, R> FlowResult<T>.flatMapLatestOnSuccess(
    crossinline transform: suspend (value: T) -> FlowResult<R>
): FlowResult<R> {
    return flatMapLatest {
        return@flatMapLatest when (it) {
            is Result.Success -> transform.invoke(it.data)
            is Result.Error -> flow { emit(it) }
            is Result.Loading -> flow { emit(it) }
        }
    }
}

