package com.turkurt656.common.core.ktx

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.hadilq.liveevent.LiveEvent
import com.turkurt656.data.domain.result.Result

typealias LiveResult<T> = LiveData<Result<T>>
typealias MutableLiveResult<T> = MutableLiveData<Result<T>>
typealias MediatorLiveResult<T> = MediatorLiveData<Result<T>>
typealias LiveEventResult<T> = LiveEvent<Result<T>>

fun <T> LiveResult<T>.getData(): T? = (value as? Result.Success)?.data

fun <T> LiveResult<T>.mapData(): LiveData<T?> = map { (it as? Result.Success)?.data }

inline fun <T, W> LiveResult<T>.mapSuccess(
    crossinline transform: (T) -> W
): LiveResult<W> =
    MediatorLiveResult<W>().apply {
        addSource(this@mapSuccess) {
            value = when (it) {
                is Result.Success -> Result.Success(transform(it.data))
                is Result.Error -> it
                is Result.Loading -> it
            }
        }
    }