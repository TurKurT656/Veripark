package com.turkurt656.library.designsystem.ktx

import android.content.res.ColorStateList
import android.graphics.Color

fun Int?.orColor(color: Int): Int = this ?: color

fun Int?.orTransparent(): Int = this.orColor(Color.TRANSPARENT)
fun Int?.orBlack(): Int = this.orColor(Color.BLACK)
fun Int?.orWhite(): Int = this.orColor(Color.WHITE)

fun ColorStateList?.orValueOf(color: Int): ColorStateList = this ?: ColorStateList.valueOf(color)

fun ColorStateList?.orTransparent(): ColorStateList = this.orValueOf(Color.TRANSPARENT)
fun ColorStateList?.orBlack(): ColorStateList = this.orValueOf(Color.BLACK)
fun ColorStateList?.orWhite(): ColorStateList = this.orValueOf(Color.WHITE)
