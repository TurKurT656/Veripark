package com.turkurt656.library.core.di

import org.koin.core.qualifier.named

object RemoteQualifiers {

    val BASE_URL = named("BASE_URL")

    val READ_TIMEOUT = named("READ_TIMEOUT")
    val WRITE_TIMEOUT = named("WRITE_TIMEOUT")
    val CONNECTION_TIMEOUT = named("CONNECTION_TIMEOUT")

    val LOGGING_INTERCEPTOR = named("LOGGING_INTERCEPTOR")
    val API_EXCEPTION_INTERCEPTOR = named("API_EXCEPTION_INTERCEPTOR")
    val AUTHORIZATION_INTERCEPTOR = named("AUTHORIZATION_INTERCEPTOR")

}