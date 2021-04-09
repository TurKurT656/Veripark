package com.turkurt656.library.lifecycle.ktx

import androidx.lifecycle.MutableLiveData

inline fun <T> MutableLiveData<T?>.update(block: (value: T?) -> T) = postValue(block(value))

inline fun <T> MutableLiveData<T?>.updateNonNull(block: (value: T) -> T) {
    postValue(block(value ?: return))
}