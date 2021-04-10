package com.turkurt656.data.domainimpl.exception

import com.turkurt656.data.domain.result.ResultException
import com.turkurt656.data.remote.exception.exception.RemoteException

fun RemoteException.toResultException(): ResultException =
    when (this) {
        is RemoteException.HttpClientException -> ResultException.HttpClientException(message, code)
        is RemoteException.HttpServerException -> ResultException.HttpServerException(message, code)
        is RemoteException.NetworkException -> ResultException.NetworkException(message)
        is RemoteException.UnknownNetworkException -> ResultException.UnknownNetworkException(message)
        is RemoteException.ApiException -> ResultException.ApiException(message, code)
    }