package com.turkurt656.feature.stocks.ui.list

import com.turkurt656.common.core.base.BaseFragment
import com.turkurt656.feature.stocks.R
import com.turkurt656.feature.stocks.databinding.StocksListFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class StocksListFragment : BaseFragment<StocksListViewModel, StocksListFragmentBinding>() {

    override val viewModel: StocksListViewModel by viewModel()
    override val layoutRes: Int = R.layout.stocks_list_fragment
    private val stocksAdapter: StocksAdapter by inject()

    override fun everyTimeEvent() {
        binding?.rcvStocksList?.adapter = stocksAdapter
    }

    override fun hookVariables() {
        binding?.vm = viewModel
    }
}