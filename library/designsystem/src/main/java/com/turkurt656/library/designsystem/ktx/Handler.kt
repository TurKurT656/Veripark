package com.turkurt656.library.designsystem.ktx

import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.turkurt656.library.core.annotation.TestApi

inline fun runnable(crossinline call: Runnable.() -> Unit) =
    object : Runnable {
        override fun run() {
            call()
        }
    }

@TestApi
fun handler(delay: Long = 0, call: () -> Unit) =
    Handler(Looper.getMainLooper()).postDelayed(delay) { call() }