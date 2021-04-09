package com.turkurt656.library.designsystem.ktx

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat

fun Context.getDrawableCompat(@DrawableRes id: Int): Drawable? =
    ContextCompat.getDrawable(this, id)

fun Context.getColorCompat(@ColorRes id: Int): Int? =
    ContextCompat.getColor(this, id)

fun Context.getColorStateListCompat(@ColorRes id: Int): ColorStateList? =
    ContextCompat.getColorStateList(this, id)

fun Context.getDimension(@DimenRes id: Int): Float =
    resources.getDimension(id)

fun Context.getDimensionPixelSize(@DimenRes id: Int): Int =
    resources.getDimensionPixelSize(id)

fun Context.getFont(@FontRes id: Int): Typeface? =
    ResourcesCompat.getFont(this, id)