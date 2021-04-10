package com.turkurt656.common.core.ba

import androidx.databinding.BindingAdapter
import com.turkurt656.data.domain.result.Result
import com.turkurt656.library.designsystem.primarybutton.PrimaryButton

object PrimaryButtonBindingAdapter {

    @BindingAdapter("bind:loading")
    @JvmStatic
    fun <T> setLoading(primaryButton: PrimaryButton, result: Result<T>?) {
        primaryButton.isLoading = result is Result.Loading
    }

    @BindingAdapter("bind:loading")
    @JvmStatic
    fun setLoading(primaryButton: PrimaryButton, isLoading: Boolean?) {
        primaryButton.isLoading = isLoading == true
    }

}