package com.turkurt656.common.core.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.turkurt656.common.core.BR

abstract class BaseAdapter<T>(
    val areItemsTheSame: (oldItem: T, newItem: T) -> Boolean,
    val areContentsTheSame: (oldItem: T, newItem: T) -> Boolean
) : ListAdapter<T, BaseAdapter<T>.DataBindingViewHolder>(
    object : DiffUtil.ItemCallback<T>() {

        override fun areItemsTheSame(oldItem: T, newItem: T) =
            areItemsTheSame(oldItem, newItem)

        override fun areContentsTheSame(oldItem: T, newItem: T) =
            areContentsTheSame(oldItem, newItem)

    }
) {

    var onItemClicked: ((item: T, view: View) -> Unit)? = null
    var onItemLongClicked: ((item: T, view: View) -> Boolean)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        return DataBindingViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) =
        holder.bind(getItem(position))

    abstract override fun getItemViewType(position: Int): Int

    override fun onViewAttachedToWindow(holder: DataBindingViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.onAppear()
    }

    override fun onViewDetachedFromWindow(holder: DataBindingViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.onDisappear()
    }

    inner class DataBindingViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root), LifecycleOwner {

        private val lifecycleRegistry = LifecycleRegistry(this)

        init {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        }

        fun onAppear() {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        }

        fun onDisappear() {
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        }

        override fun getLifecycle() = lifecycleRegistry

        fun bind(item: T) {
            binding.apply {
                lifecycleOwner = this@DataBindingViewHolder
                setVariable(BR.item, item)
                executePendingBindings()
                root.apply {
                    setOnClickListener {
                        onItemClicked?.invoke(item, this)
                    }
                    setOnLongClickListener {
                        return@setOnLongClickListener onItemLongClicked?.invoke(item, this)
                            ?: true
                    }
                }
            }

        }
    }
}
