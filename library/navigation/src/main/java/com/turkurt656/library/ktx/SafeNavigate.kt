package com.turkurt656.library.ktx

import androidx.navigation.NavController
import java.lang.Exception

inline fun NavController.doSafely(block: NavController.() -> Unit) =
    try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
    }