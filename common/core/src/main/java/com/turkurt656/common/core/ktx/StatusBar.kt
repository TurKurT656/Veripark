package com.turkurt656.common.core.ktx

import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.turkurt656.library.designsystem.ktx.getColorCompat
import com.turkurt656.library.designsystem.ktx.orBlack

/**
 * This only works for Marshmallow and above
 */
fun Fragment.setStatusBarColor(
    @ColorRes colorResId: Int,
    isDarkStatusBar: Boolean,
    isFullScreenStatusBar: Boolean = false,
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        with(activity?.window ?: return) {
            setStatusBarFullScreenMode(isFullScreenStatusBar)
            statusBarColor = context?.getColorCompat(colorResId).orBlack()
            setStatusBarDarkMode(isDarkStatusBar)
        }
    }
}

@Suppress("DEPRECATION")
@RequiresApi(Build.VERSION_CODES.M)
private fun Fragment.setStatusBarFullScreenMode(isFullScreen: Boolean) {
    with(activity?.window ?: return) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (isFullScreen) insetsController?.show(WindowInsets.Type.statusBars())
            else insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            clearFlags(FLAG_FULLSCREEN)
            if (isFullScreen) addFlags(FLAG_FULLSCREEN)
            else addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        }
    }
}

@Suppress("DEPRECATION")
@RequiresApi(Build.VERSION_CODES.M)
private fun Fragment.setStatusBarDarkMode(isDark: Boolean) {
    with(activity?.window ?: return) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (isDark) {
                insetsController?.setSystemBarsAppearance(
                    APPEARANCE_LIGHT_STATUS_BARS.inv(),
                    APPEARANCE_LIGHT_STATUS_BARS.inv()
                )
            } else {
                insetsController?.setSystemBarsAppearance(
                    APPEARANCE_LIGHT_STATUS_BARS,
                    APPEARANCE_LIGHT_STATUS_BARS
                )
            }
        } else {
            decorView.systemUiVisibility =
                if (isDark) View.SYSTEM_UI_FLAG_VISIBLE else View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }
}