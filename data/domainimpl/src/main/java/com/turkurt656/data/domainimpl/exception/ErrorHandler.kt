package com.turkurt656.data.domainimpl.exception

import com.turkurt656.data.domain.result.ResultException
import com.turkurt656.data.remote.exception.exception.handleRemoteError

fun handleError(e: Exception): ResultException {
    handleRemoteError(e)?.let { return it.toResultException() }
    // handleLocalError here
    return ResultException.UnknownResultException("UnknownError")
}