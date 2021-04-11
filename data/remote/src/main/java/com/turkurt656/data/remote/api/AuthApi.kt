package com.turkurt656.data.remote.api

import com.turkurt656.data.remote.dto.auth.HandShakeRequestRemote
import com.turkurt656.data.remote.dto.auth.HandShakeResponseRemote
import com.turkurt656.data.remote.interceptor.NEEDS_ACCESS_TOKEN
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApi {

    @POST("handshake/start")
    @Headers("$NEEDS_ACCESS_TOKEN:false")
    suspend fun handShake(@Body params: HandShakeRequestRemote): HandShakeResponseRemote


}