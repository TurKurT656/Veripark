package com.turkurt656.common.core.ba

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.turkurt656.common.core.base.BaseAdapter
import com.turkurt656.data.domain.result.Result

object RecyclerViewBindingAdapter {

    @Suppress("UNCHECKED_CAST")
    @BindingAdapter("bind:data")
    @JvmStatic
    fun <T : Any> setRecyclerViewData(
        recyclerView: RecyclerView,
        result: Result<List<T>>?
    ) =
        with(recyclerView) {
            when (result) {
                is Result.Success -> {
                    if (adapter is BaseAdapter<*>)
                        (adapter as BaseAdapter<T>).submitList(result.data)
                }
                else -> {
                }
            }
        }

    @Suppress("UNCHECKED_CAST")
    @BindingAdapter("bind:data")
    @JvmStatic
    fun <T : Any> setRecyclerViewData(
        recyclerView: RecyclerView,
        result: List<T>?
    ) =
        with(recyclerView) {
            if (adapter is BaseAdapter<*>)
                (adapter as BaseAdapter<T>).submitList(result)
        }

}