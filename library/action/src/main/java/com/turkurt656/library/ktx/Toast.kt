package com.turkurt656.library.ktx

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) =
    context?.showToast(message, duration)

fun Context.showToast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()

fun Fragment.showToast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) =
    context?.showToast(message, duration)