package com.turkurt656.data.domainimpl.token

import com.turkurt656.data.domain.token.TokenHolder

class TokenHolderImpl: TokenHolder {

    private var token: String = ""

    override fun getAuthorizationToken(): String = token

    override fun updateAuthorizationToken(token: String) {
        this.token = token
    }
}