package com.turkurt656.library.lifecycle.ktx

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

inline fun <T1, T2, R> combine(
    source1: LiveData<T1>,
    source2: LiveData<T2>,
    crossinline combine: (data1: T1?, data2: T2?) -> R
): LiveData<R> = MediatorLiveData<R>().apply {

    var data1: T1? = null
    var data2: T2? = null

    addSource(source1) {
        data1 = it
        value = combine(data1, data2)
    }

    addSource(source2) {
        data2 = it
        value = combine(data1, data2)
    }

}

inline fun <T1, T2, T3, R> combine(
    source1: LiveData<T1>,
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    crossinline combine: (data1: T1?, data2: T2?, data3: T3?) -> R
): LiveData<R> = MediatorLiveData<R>().apply {

    var data1: T1? = null
    var data2: T2? = null
    var data3: T3? = null

    addSource(source1) {
        data1 = it
        value = combine(data1, data2, data3)
    }

    addSource(source2) {
        data2 = it
        value = combine(data1, data2, data3)
    }

    addSource(source3) {
        data3 = it
        value = combine(data1, data2, data3)
    }

}

inline fun <T1, T2, T3, T4, R> combine(
    source1: LiveData<T1>,
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    source4: LiveData<T4>,
    crossinline combine: (data1: T1?, data2: T2?, data3: T3?, data4: T4?) -> R
): LiveData<R> = MediatorLiveData<R>().apply {

    var data1: T1? = null
    var data2: T2? = null
    var data3: T3? = null
    var data4: T4? = null

    addSource(source1) {
        data1 = it
        value = combine(data1, data2, data3, data4)
    }

    addSource(source2) {
        data2 = it
        value = combine(data1, data2, data3, data4)
    }

    addSource(source3) {
        data3 = it
        value = combine(data1, data2, data3, data4)
    }

    addSource(source4) {
        data4 = it
        value = combine(data1, data2, data3, data4)
    }

}

inline fun <T1, T2, T3, T4, T5, R> combine(
    source1: LiveData<T1>,
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    source4: LiveData<T4>,
    source5: LiveData<T5>,
    crossinline combine: (data1: T1?, data2: T2?, data3: T3?, data4: T4?, data5: T5?) -> R
): LiveData<R> = MediatorLiveData<R>().apply {

    var data1: T1? = null
    var data2: T2? = null
    var data3: T3? = null
    var data4: T4? = null
    var data5: T5? = null

    addSource(source1) {
        data1 = it
        value = combine(data1, data2, data3, data4, data5)
    }

    addSource(source2) {
        data2 = it
        value = combine(data1, data2, data3, data4, data5)
    }

    addSource(source3) {
        data3 = it
        value = combine(data1, data2, data3, data4, data5)
    }

    addSource(source4) {
        data4 = it
        value = combine(data1, data2, data3, data4, data5)
    }

    addSource(source5) {
        data5 = it
        value = combine(data1, data2, data3, data4, data5)
    }

}

inline fun <T1, T2, T3, T4, T5, T6, R> combine(
    source1: LiveData<T1>,
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    source4: LiveData<T4>,
    source5: LiveData<T5>,
    source6: LiveData<T6>,
    crossinline combine: (data1: T1?, data2: T2?, data3: T3?, data4: T4?, data5: T5?, data6: T6?) -> R
): LiveData<R> = MediatorLiveData<R>().apply {

    var data1: T1? = null
    var data2: T2? = null
    var data3: T3? = null
    var data4: T4? = null
    var data5: T5? = null
    var data6: T6? = null

    addSource(source1) {
        data1 = it
        value = combine(data1, data2, data3, data4, data5, data6)
    }

    addSource(source2) {
        data2 = it
        value = combine(data1, data2, data3, data4, data5, data6)
    }

    addSource(source3) {
        data3 = it
        value = combine(data1, data2, data3, data4, data5, data6)
    }

    addSource(source4) {
        data4 = it
        value = combine(data1, data2, data3, data4, data5, data6)
    }

    addSource(source5) {
        data5 = it
        value = combine(data1, data2, data3, data4, data5, data6)
    }

    addSource(source6) {
        data6 = it
        value = combine(data1, data2, data3, data4, data5, data6)
    }

}

inline fun <T1, T2, T3, T4, T5, T6, T7, R> combine(
    source1: LiveData<T1>,
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    source4: LiveData<T4>,
    source5: LiveData<T5>,
    source6: LiveData<T6>,
    source7: LiveData<T7>,
    crossinline combine: (data1: T1?, data2: T2?, data3: T3?, data4: T4?, data5: T5?, data6: T6?, data7: T7?) -> R
): LiveData<R> = MediatorLiveData<R>().apply {

    var data1: T1? = null
    var data2: T2? = null
    var data3: T3? = null
    var data4: T4? = null
    var data5: T5? = null
    var data6: T6? = null
    var data7: T7? = null

    addSource(source1) {
        data1 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7)
    }

    addSource(source2) {
        data2 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7)
    }

    addSource(source3) {
        data3 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7)
    }

    addSource(source4) {
        data4 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7)
    }

    addSource(source5) {
        data5 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7)
    }

    addSource(source6) {
        data6 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7)
    }

    addSource(source7) {
        data7 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7)
    }

}

inline fun <T1, T2, T3, T4, T5, T6, T7, T8, R> combine(
    source1: LiveData<T1>,
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    source4: LiveData<T4>,
    source5: LiveData<T5>,
    source6: LiveData<T6>,
    source7: LiveData<T7>,
    source8: LiveData<T8>,
    crossinline combine: (data1: T1?, data2: T2?, data3: T3?, data4: T4?, data5: T5?, data6: T6?, data7: T7?, data8: T8?) -> R
): LiveData<R> = MediatorLiveData<R>().apply {

    var data1: T1? = null
    var data2: T2? = null
    var data3: T3? = null
    var data4: T4? = null
    var data5: T5? = null
    var data6: T6? = null
    var data7: T7? = null
    var data8: T8? = null

    addSource(source1) {
        data1 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8)
    }

    addSource(source2) {
        data2 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8)
    }

    addSource(source3) {
        data3 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8)
    }

    addSource(source4) {
        data4 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8)
    }

    addSource(source5) {
        data5 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8)
    }

    addSource(source6) {
        data6 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8)
    }

    addSource(source7) {
        data7 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8)
    }

    addSource(source8) {
        data8 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8)
    }

}

inline fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> combine(
    source1: LiveData<T1>,
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    source4: LiveData<T4>,
    source5: LiveData<T5>,
    source6: LiveData<T6>,
    source7: LiveData<T7>,
    source8: LiveData<T8>,
    source9: LiveData<T9>,
    crossinline combine: (data1: T1?, data2: T2?, data3: T3?, data4: T4?, data5: T5?, data6: T6?, data7: T7?, data8: T8?, data9: T9?) -> R
): LiveData<R> = MediatorLiveData<R>().apply {

    var data1: T1? = null
    var data2: T2? = null
    var data3: T3? = null
    var data4: T4? = null
    var data5: T5? = null
    var data6: T6? = null
    var data7: T7? = null
    var data8: T8? = null
    var data9: T9? = null

    addSource(source1) {
        data1 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8, data9)
    }

    addSource(source2) {
        data2 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8, data9)
    }

    addSource(source3) {
        data3 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8, data9)
    }

    addSource(source4) {
        data4 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8, data9)
    }

    addSource(source5) {
        data5 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8, data9)
    }

    addSource(source6) {
        data6 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8, data9)
    }

    addSource(source7) {
        data7 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8, data9)
    }

    addSource(source8) {
        data8 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8, data9)
    }

    addSource(source9) {
        data9 = it
        value = combine(data1, data2, data3, data4, data5, data6, data7, data8, data9)
    }

}
