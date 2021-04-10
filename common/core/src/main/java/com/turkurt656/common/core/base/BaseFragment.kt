package com.turkurt656.common.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.turkurt656.common.core.R
import com.turkurt656.common.core.ktx.addNavigatorOn
import com.turkurt656.common.core.ktx.launchWhenStarted
import com.turkurt656.common.core.ktx.observeActions
import com.turkurt656.common.core.ktx.setStatusBarColor

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> :
    Fragment(), BackPressCatcher {

    abstract val viewModel: VM
    abstract val layoutRes: Int

    open var binding: DB? = null

    abstract fun hookVariables()

    open fun bindObservables() {}

    open fun oneTimeEvent() {}

    open fun everyTimeEvent() {}

    override fun onBackPressed() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchWhenStarted {
            initNavigator()
            initActions()
            bindObservables()
            oneTimeEvent()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initDataBinding(inflater, container)
        return binding?.root ?: View(context)
    }

    override fun onStart() {
        super.onStart()
        setStatusBarColor(R.color.white, false)
        everyTimeEvent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initActions() = observeActions(viewModel)

    private fun initNavigator() = addNavigatorOn(viewModel, findNavController())

    private fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        DataBindingUtil.inflate<DB>(inflater, layoutRes, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }.also { binding = it }
        hookVariables()
    }
}