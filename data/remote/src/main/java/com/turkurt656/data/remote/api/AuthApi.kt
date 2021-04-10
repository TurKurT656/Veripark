package com.turkurt656.data.remote.api

import com.turkurt656.data.remote.dto.auth.HandShakeRequestRemote
import com.turkurt656.data.remote.dto.auth.HandShakeResponseRemote
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("handshake/start")
    suspend fun handShake(@Body params: HandShakeRequestRemote): HandShakeResponseRemote


}