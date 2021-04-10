package com.turkurt656.data.remote.exception.exception

sealed class RemoteException(override val message: String): Exception() {

    data class HttpClientException(override val message: String, val code: Int): RemoteException(message)
    data class HttpServerException(override val message: String, val code: Int): RemoteException(message)
    data class NetworkException(override val message: String) : RemoteException(message)
    data class UnknownNetworkException(override val message: String): RemoteException(message)
    data class ApiException(override val message: String, val code: Int): RemoteException(message)

}