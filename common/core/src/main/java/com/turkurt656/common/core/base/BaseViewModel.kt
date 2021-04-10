package com.turkurt656.common.core.base

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.google.android.material.snackbar.Snackbar
import com.hadilq.liveevent.LiveEvent
import com.turkurt656.library.action.command.ActionCommand
import com.turkurt656.library.navigation.command.NavigationCommand

abstract class BaseViewModel() : ViewModel() {

    private val _navigationCommand = LiveEvent<NavigationCommand>()
    val navigationCommand: LiveData<NavigationCommand> = _navigationCommand

    fun navigateTo(directions: NavDirections) =
        _navigationCommand.postValue(NavigationCommand.To(directions))

    fun navigateBack() =
        _navigationCommand.postValue(NavigationCommand.Back)

    fun navigateBackTo(destinationId: Int, inclusive: Boolean) =
        _navigationCommand.postValue(NavigationCommand.BackTo(destinationId, inclusive))


    private val _actionCommand = LiveEvent<ActionCommand>()
    val actionCommand: LiveData<ActionCommand> = _actionCommand

    fun showToast(message: String, duration: Int = Toast.LENGTH_SHORT) =
        _actionCommand.postValue(ActionCommand.ShowToast(message, duration))


    fun showToast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) =
        _actionCommand.postValue(ActionCommand.ShowToastRes(message, duration))


    fun showSnackBar(message: String, duration: Int = Snackbar.LENGTH_SHORT) =
        _actionCommand.postValue(ActionCommand.ShowSnackBar(message, duration))


    fun showSnackBar(@StringRes message: Int, duration: Int = Snackbar.LENGTH_SHORT) =
        _actionCommand.postValue(ActionCommand.ShowSnackBarRes(message, duration))

}