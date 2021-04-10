package com.turkurt656.data.domainimpl.result

import com.turkurt656.data.domain.result.FlowResult
import com.turkurt656.data.domain.result.Result
import com.turkurt656.data.domainimpl.exception.handleError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext

fun <T> flowResult(callback: suspend () -> T): FlowResult<T> {
    return flow {
        emit(safeCall { callback() })
    }.onStart {
        emit(Result.Loading)
    }
}

private suspend fun <T> safeCall(callback: suspend () -> T) =
    withContext(Dispatchers.IO) {
        return@withContext try {
            Result.Success(callback())
        } catch (e: Exception) {
            Result.Error(handleError(e))
        }
    }

fun <T> Flow<T>.toFlowResult(): FlowResult<T> {
    return map {
        Result.Success(it)
    }.catch<Result<T>> { e ->
        emit(value = Result.Error(handleError(e as Exception)))
    }.onStart {
        Result.Loading
    }
}