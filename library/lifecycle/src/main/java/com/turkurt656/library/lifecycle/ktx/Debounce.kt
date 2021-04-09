package com.turkurt656.library.lifecycle.ktx

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData


fun <T> LiveData<T>.debounce(duration: Long = 1000L): LiveData<T> =
    MediatorLiveData<T>().apply {
        val source = this@debounce
        val handler = Handler(Looper.getMainLooper())

        val runnable = Runnable {
            if (value != source.value) value = source.value
        }

        addSource(source) {
            handler.removeCallbacks(runnable)
            handler.postDelayed(runnable, duration)
        }
    }