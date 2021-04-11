package com.turkurt656.data.domain.result

sealed class ResultException(override val message: String): Exception() {

    /**
     * Remote Exceptions
     */
    data class HttpClientException(override val message: String, val code: Int): ResultException(message)
    data class HttpServerException(override val message: String, val code: Int): ResultException(message)
    data class NetworkException(override val message: String) : ResultException(message)
    data class UnknownNetworkException(override val message: String): ResultException(message)
    data class ApiException(override val message: String, val code: Int): ResultException(message)
    data class CryptoException(override val message: String): ResultException(message)


    data class UnknownResultException(override val message: String): ResultException(message)

}