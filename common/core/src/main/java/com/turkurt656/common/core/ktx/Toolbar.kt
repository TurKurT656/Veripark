package com.turkurt656.common.core.ktx

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

fun Fragment.setSupportActionBar(toolbar: Toolbar?) =
    (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)

val Fragment.supportActionBar
    get() = (activity as? AppCompatActivity)?.supportActionBar