package com.turkurt656.data.domain.crypto

interface AESCryptoManager {

    fun updateKeys(key: String, iv: String)

    fun encrypt(raw: String): String

    fun decrypt(encrypted: String): String

}