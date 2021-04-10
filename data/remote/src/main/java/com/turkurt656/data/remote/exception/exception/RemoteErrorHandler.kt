package com.turkurt656.data.remote.exception.exception

import com.turkurt656.data.remote.exception.exception.RemoteException.*
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun handleRemoteError(e: Exception): RemoteException? =
    when (e) {
        is UnknownHostException -> NetworkException("Internet is not available")
        is HttpException -> {
            when (e.code()) {
                400 -> HttpClientException("The request that was sent to the server is invalid.", e.code())
                401 -> HttpClientException("Unauthorized error, you must provide credentials to be able to view the protected resource", e.code())
                403 -> HttpClientException("Forbidden error, due to a lack of permission to access the requested resource", e.code())
                404 -> HttpClientException("Resource not found", e.code())
                405 -> HttpClientException("Method Not Allowed, a request method is not supported for the requested resource", e.code())
                409 -> HttpClientException("Conflict error, the request could not be processed because of conflict in the current state of the resource", e.code())
                429 -> HttpClientException("Too Many Requests, you have sent too many requests in a given amount of time. Please try again later", e.code())
                500 -> HttpServerException("Internal Server Error, server cannot process the request for an unknown reason", e.code())
                502 -> HttpServerException("Bad Gateway error", e.code())
                503 -> HttpServerException("Service Unavailable error, the server is overloaded or under maintenance", e.code())
                504 -> HttpServerException("Gateway Timeout error", e.code())
                else -> HttpServerException("Unknown HTTP error, please try again", e.code())
            }
        }
        is ApiResponseException -> ApiException(e.message, e.code)
        is SocketTimeoutException -> NetworkException("Request timeout!")
        is IOException -> NetworkException("Unknown Network error")
        // Do not put another value in else branch,
        // It will cause to prevent local exceptions and... see: [handleError] function
        else -> null
    }