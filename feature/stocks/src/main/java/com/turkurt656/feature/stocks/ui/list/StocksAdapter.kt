package com.turkurt656.feature.stocks.ui.list

import com.turkurt656.common.core.base.BaseAdapter
import com.turkurt656.data.domain.dto.stocks.Stocks
import com.turkurt656.feature.stocks.R
import com.turkurt656.library.designsystem.ktx.getColorCompat
import com.turkurt656.library.designsystem.ktx.orWhite

class StocksAdapter : BaseAdapter<Stocks>(
    areItemsTheSame = { oldItem: Stocks, newItem: Stocks -> oldItem.id == newItem.id },
    areContentsTheSame = { oldItem: Stocks, newItem: Stocks -> oldItem == newItem }
) {

    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val bgColor = if (position % 2 == 0)
            holder.itemView.context.getColorCompat(R.color.color_background_more_lightest).orWhite()
        else
            holder.itemView.context.getColorCompat(R.color.color_background_lightest).orWhite()
        holder.itemView.setBackgroundColor(bgColor)
    }

    override fun getItemViewType(position: Int): Int =
        R.layout.item_stocks

}