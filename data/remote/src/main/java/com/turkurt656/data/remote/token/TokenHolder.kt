package com.turkurt656.data.remote.token

interface TokenHolder {

    fun getAuthorizationToken(): String

    fun updateAuthorizationToken(token: String)

}