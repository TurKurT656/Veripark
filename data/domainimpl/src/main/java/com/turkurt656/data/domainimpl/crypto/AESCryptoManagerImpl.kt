package com.turkurt656.data.domainimpl.crypto

import android.util.Base64
import com.turkurt656.data.domain.crypto.AESCryptoManager
import com.turkurt656.data.domain.result.ResultException
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


class AESCryptoManagerImpl : AESCryptoManager {

    private val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")

    private var key: SecretKeySpec? = null
    private var iv: IvParameterSpec? = null

    override fun updateKeys(key: String, iv: String) {
        this.key = SecretKeySpec(Base64.decode(key, Base64.DEFAULT), "AES")
        this.iv = IvParameterSpec(Base64.decode(iv, Base64.DEFAULT))
    }

    override fun encrypt(raw: String): String {
        if (key == null || iv == null)
            throw ResultException.CryptoException("Key or IV is null")
        return try {
            cipher.init(Cipher.ENCRYPT_MODE, key, iv)
            val encrypted = cipher.doFinal(raw.toByteArray(Charsets.UTF_8))
            String(Base64.encode(encrypted, Base64.DEFAULT), Charsets.UTF_8)
        } catch (e: Exception) {
            e.printStackTrace()
            throw ResultException.CryptoException("Error while encryption")
        }
    }

    override fun decrypt(encrypted: String): String {
        if (key == null || iv == null)
            throw ResultException.CryptoException("Key or IV is null")
        return try {
            cipher.init(Cipher.DECRYPT_MODE, key, iv)
            val bytes = Base64.decode(encrypted, Base64.DEFAULT)
            val decrypted = cipher.doFinal(bytes)
            String(decrypted, Charsets.UTF_8)
        } catch (e: Exception) {
            e.printStackTrace()
            throw ResultException.CryptoException("Error while decryption")
        }
    }

}