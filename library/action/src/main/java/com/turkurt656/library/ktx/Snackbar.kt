package com.turkurt656.library.ktx

import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun View.showSnackBar(
    @StringRes message: Int,
    duration: Int = Snackbar.LENGTH_SHORT
) = Snackbar.make(this, message, duration).show()

fun Fragment.showSnackBar(
    @StringRes message: Int,
    duration: Int = Snackbar.LENGTH_SHORT
) = view?.showSnackBar(message, duration)

fun View.showSnackBar(
    message: String,
    duration: Int = Snackbar.LENGTH_SHORT
) = Snackbar.make(this, message, duration).show()

fun Fragment.showSnackBar(
    message: String,
    duration: Int = Snackbar.LENGTH_SHORT
) = view?.showSnackBar(message, duration)