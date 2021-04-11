package com.turkurt656.feature.stocks.ui.list

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import com.turkurt656.common.core.base.BaseFragment
import com.turkurt656.common.core.ktx.setSupportActionBar
import com.turkurt656.data.domain.dto.stocks.Period
import com.turkurt656.feature.stocks.R
import com.turkurt656.feature.stocks.databinding.StocksListFragmentBinding
import com.turkurt656.library.designsystem.ktx.getColorCompat
import com.turkurt656.library.designsystem.ktx.orWhite
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class StocksListFragment : BaseFragment<StocksListViewModel, StocksListFragmentBinding>() {

    override val viewModel: StocksListViewModel by viewModel()
    override val layoutRes: Int = R.layout.stocks_list_fragment
    private val stocksAdapter: StocksAdapter by inject()

    private val drawerToggle: ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(
            activity,
            binding?.drlPeriods,
            binding?.toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        ).apply {
            drawerArrowDrawable.color =
                context?.getColorCompat(R.color.color_icon_on_light_bg_lighter).orWhite()
        }
    }

    override fun everyTimeEvent() {
        setSupportActionBar(binding?.toolbar)
        configList()
        configDrawer()
    }

    private fun configList() {
        binding?.rcvStocksList?.adapter = stocksAdapter
        stocksAdapter.onItemClicked = { item, _ ->
            viewModel.onStocksClicked(item)
        }
    }

    private fun configDrawer() {
        binding?.nvvPeriods?.setNavigationItemSelectedListener {
            val period = when (it.itemId) {
                R.id.period_all -> Period.ALL
                R.id.period_increasing -> Period.INCREASING
                R.id.period_decreasing -> Period.DECREASING
                R.id.period_volume30 -> Period.VOLUME30
                R.id.period_volume50 -> Period.VOLUME50
                R.id.period_volume100 -> Period.VOLUME100
                else -> Period.ALL
            }
            viewModel.getStocksList(period)
            binding?.drlPeriods?.closeDrawers()
            return@setNavigationItemSelectedListener true
        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawerToggle.syncState()
        binding?.drlPeriods?.addDrawerListener(drawerToggle)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun hookVariables() {
        binding?.vm = viewModel
    }
}