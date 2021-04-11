package com.turkurt656.data.remote.token

class TokenHolderImpl: TokenHolder {

    private var token: String = ""

    override fun getAuthorizationToken(): String = token

    override fun updateAuthorizationToken(token: String) {
        this.token = token
    }
}