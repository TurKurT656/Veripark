package com.turkurt656.feature.stocks.ui.detail

import androidx.navigation.fragment.navArgs
import com.turkurt656.common.core.base.BaseFragment
import com.turkurt656.common.core.ktx.setSupportActionBar
import com.turkurt656.feature.stocks.R
import com.turkurt656.feature.stocks.databinding.StocksDetailFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class StocksDetailFragment : BaseFragment<StocksDetailViewModel, StocksDetailFragmentBinding>() {

    private val args: StocksDetailFragmentArgs by navArgs()
    override val viewModel: StocksDetailViewModel by viewModel(parameters = { parametersOf(args.id) })
    override val layoutRes: Int = R.layout.stocks_detail_fragment

    override fun everyTimeEvent() {
        setSupportActionBar(binding?.toolbar)
    }

    override fun hookVariables() {
        binding?.vm = viewModel
    }
}