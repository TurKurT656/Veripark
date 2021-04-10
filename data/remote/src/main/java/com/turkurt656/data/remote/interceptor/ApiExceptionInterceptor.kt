package com.turkurt656.data.remote.interceptor

import com.squareup.moshi.Moshi
import com.turkurt656.data.remote.dto.ApiResponse
import com.turkurt656.data.remote.exception.exception.ApiResponseException
import okhttp3.Interceptor
import okhttp3.Response

class ApiExceptionInterceptor(
    private val moshi: Moshi
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        // Check if response isn't json then don't check api exceptions
        if (response.header(CONTENT_TYPE)?.contains(APPLICATION_JSON) == false)
            return response

        response.peekBody(2048)
            .string()
            .takeIf { it.isNotBlank() }
            ?.handleApiExceptions(moshi)

        return response
    }

    private fun String.handleApiExceptions(moshi: Moshi) {
        val apiAdapter = moshi.adapter(ApiResponse::class.java)
            ?: throw ApiResponseException("Couldn't create moshi ApiAdapter", -1)
        val apiResponse = apiAdapter.fromJson(this)
            ?: throw ApiResponseException("Couldn't convert json to ApiResponse", -1)

        if (apiResponse.status.isSuccess.not())
            throw ApiResponseException(
                apiResponse.status.error.message,
                apiResponse.status.error.code,
            )
    }
}