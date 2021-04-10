package com.turkurt656.data.domain.token

interface TokenHolder {

    fun getAuthorizationToken(): String

    fun updateAuthorizationToken(token: String)

}