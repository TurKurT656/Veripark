package com.turkurt656.common.core.ktx

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import com.turkurt656.library.action.command.ActionCommand
import com.turkurt656.library.ktx.doSafely
import com.turkurt656.library.ktx.showSnackBar
import com.turkurt656.library.ktx.showToast
import com.turkurt656.library.navigation.command.NavigationCommand
import com.turkurt656.common.core.base.BaseViewModel

fun LifecycleOwner.addNavigatorOn(
    viewModel: BaseViewModel,
    navController: NavController
) {
    viewModel.navigationCommand.observe(this) { command ->
        when (command) {
            is NavigationCommand.To ->
                navController.doSafely { navigate(command.directions) }
            is NavigationCommand.Back ->
                navController.doSafely { popBackStack() }
            is NavigationCommand.BackTo ->
                navController.doSafely { popBackStack(command.destinationId, command.inclusive) }
        }
    }
}

fun LifecycleOwner.observeActions(
    viewModel: BaseViewModel
) {
    viewModel.actionCommand.observe(this) { command ->
        when (command) {
            is ActionCommand.ShowToast ->
                when (this) {
                    is Activity -> showToast(command.message, command.duration)
                    is Fragment -> showToast(command.message, command.duration)
                }

            is ActionCommand.ShowToastRes ->
                when (this) {
                    is Activity -> showToast(command.message, command.duration)
                    is Fragment -> showToast(command.message, command.duration)
                }

            is ActionCommand.ShowSnackBar ->
                when (this) {
                    is Fragment ->
                        showSnackBar(command.message, command.duration)
                    is Activity ->
                        findViewById<ViewGroup>(android.R.id.content)
                            .showSnackBar(command.message, command.duration)
                }

            is ActionCommand.ShowSnackBarRes ->
                when (this) {
                    is Fragment ->
                        showSnackBar(command.message, command.duration)
                    is Activity ->
                        findViewById<ViewGroup>(android.R.id.content)
                            .showSnackBar(command.message, command.duration)
                }

        }
    }
}

val View.lifecycleOwner: LifecycleOwner?
    get() = try {
        val fragment = findFragment<Fragment>()
        fragment.viewLifecycleOwner
    } catch (e: IllegalStateException) {
        when (val activity = context.getActivity()) {
            is ComponentActivity -> activity
            else -> null
        }
    }

private tailrec fun Context.getActivity(): Activity? = this as? Activity
    ?: (this as? ContextWrapper)?.baseContext?.getActivity()
