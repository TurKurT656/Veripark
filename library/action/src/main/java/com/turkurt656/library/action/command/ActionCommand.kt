package com.turkurt656.library.action.command

import androidx.annotation.StringRes

sealed class ActionCommand {
    data class ShowToast(val message: String, val duration: Int) : ActionCommand()
    data class ShowToastRes(@StringRes val message: Int, val duration: Int) : ActionCommand()
    data class ShowSnackBar(val message: String, val duration: Int) : ActionCommand()
    data class ShowSnackBarRes(@StringRes val message: Int, val duration: Int) : ActionCommand()
}