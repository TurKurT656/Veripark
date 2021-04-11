package com.turkurt656.data.remote.interceptor

import com.turkurt656.data.remote.exception.exception.ApiResponseException
import com.turkurt656.data.remote.token.TokenHolder
import okhttp3.Interceptor
import okhttp3.Response

/**
 * if a request has this header, then [AuthorizationInterceptor]
 * will add access token to the request.
 * DEFAULT: true
 */
const val NEEDS_ACCESS_TOKEN = "NEEDS_ACCESS_TOKEN"

class AuthorizationInterceptor(
    private val tokenHolder: TokenHolder
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val needsAccessTokenHeader = request.header(NEEDS_ACCESS_TOKEN) ?: "true"
        if (
            needsAccessTokenHeader.equals("true", true).not() &&
            needsAccessTokenHeader.equals("false", true).not()
        ) throw ApiResponseException("$NEEDS_ACCESS_TOKEN value is not true or false", -1)

        val needsAccessToken = needsAccessTokenHeader.toBoolean()
        val newRequest =
            if (needsAccessToken)
                request.newBuilder().addHeader(AUTHORIZATION, tokenHolder.getAuthorizationToken()).build()
            else
                request

        return chain.proceed(newRequest)
    }

}