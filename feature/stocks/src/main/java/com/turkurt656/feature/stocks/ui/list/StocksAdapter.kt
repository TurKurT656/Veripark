package com.turkurt656.feature.stocks.ui.list

import com.turkurt656.common.core.base.BaseAdapter
import com.turkurt656.data.domain.dto.stocks.Stocks
import com.turkurt656.feature.stocks.R

class StocksAdapter : BaseAdapter<Stocks>(
    areItemsTheSame = { oldItem: Stocks, newItem: Stocks -> oldItem.id == newItem.id },
    areContentsTheSame = { oldItem: Stocks, newItem: Stocks -> oldItem == newItem }
) {

    override fun getItemViewType(position: Int): Int =
        R.layout.item_stocks

}