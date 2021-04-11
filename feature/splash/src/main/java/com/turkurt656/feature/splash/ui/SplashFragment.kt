package com.turkurt656.feature.splash.ui

import com.turkurt656.common.core.base.BaseFragment
import com.turkurt656.common.core.ktx.setSupportActionBar
import com.turkurt656.feature.splash.R
import com.turkurt656.feature.splash.databinding.SplashFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<SplashViewModel, SplashFragmentBinding>() {

    override val viewModel: SplashViewModel by viewModel()
    override val layoutRes: Int = R.layout.splash_fragment

    override fun everyTimeEvent() {
        setSupportActionBar(binding?.toolbar)
    }

    override fun hookVariables() {
        binding?.vm = viewModel
    }
}