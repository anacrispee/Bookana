package com.example.data_local.security

import android.content.SharedPreferences
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Base64
import androidx.core.content.edit
import androidx.sqlite.db.SupportSQLiteOpenHelper
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory
import java.security.KeyStore
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec

class SqlCipherKeyManager(
    private val sharedPreferences: SharedPreferences
) {
    private val keyStore: KeyStore = KeyStore.getInstance(ANDROID_KEYSTORE).apply { load(null) }

    init {
        loadCipher()
        initialize()
    }

    private fun loadCipher() {
        System.loadLibrary("sqlcipher")
    }

    private fun initialize() {
        generateKeyStoreKeyIfNeeded()
        if (sharedPreferences.contains(ENCRYPTED_KEY).not()) {
            generateAndEncryptSqlCipherKey()
        }
    }

    private fun generateKeyStoreKeyIfNeeded() {
        if (keyStore.containsAlias(SQLCIPHER_KEYSTORE_KEY).not()) {
            val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, ANDROID_KEYSTORE)
            val keyGenSpec = KeyGenParameterSpec.Builder(
                SQLCIPHER_KEYSTORE_KEY,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .build()
            keyGenerator.init(keyGenSpec)
            keyGenerator.generateKey()
        }
    }

    private fun generateAndEncryptSqlCipherKey() {
        val secretKey = getSecretKey()
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)

        val sqlCipherKey = ByteArray(32)
        SecureRandom().nextBytes(sqlCipherKey)

        val encryptedKey = cipher.doFinal(sqlCipherKey)
        val iv = cipher.iv

        sharedPreferences.edit {
            putString(ENCRYPTED_KEY, Base64.encodeToString(encryptedKey, Base64.NO_WRAP))
            putString(ENCRYPTION_IV, Base64.encodeToString(iv, Base64.NO_WRAP))
        }

        sqlCipherKey.fill(0)
    }

    private fun getSecretKey() : SecretKey = (keyStore.getEntry(SQLCIPHER_KEYSTORE_KEY, null) as KeyStore.SecretKeyEntry).secretKey

    private fun getDecryptedSqlCipherKey(key: String, iv: String): ByteArray {
        val encryptedKey = Base64.decode(key, Base64.NO_WRAP)
        val ivBytes = Base64.decode(iv, Base64.NO_WRAP)

        val secretKey = getSecretKey()
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.DECRYPT_MODE, secretKey, GCMParameterSpec(128, ivBytes))

        return cipher.doFinal(encryptedKey)
    }

    fun getSupportFactory(): SupportOpenHelperFactory {
        val encryptedKey = sharedPreferences.getString(ENCRYPTED_KEY, null).orEmpty()
        val iv = sharedPreferences.getString(ENCRYPTION_IV, null).orEmpty()
        val decryptedKey = getDecryptedSqlCipherKey(encryptedKey, iv)
        return WipeAfterUseSupportFactory(decryptedKey)
    }

    class WipeAfterUseSupportFactory(
        private val passphrase: ByteArray
    ) : SupportOpenHelperFactory(passphrase) {

        override fun create(configuration: SupportSQLiteOpenHelper.Configuration): SupportSQLiteOpenHelper {
            val factory = super.create(configuration)
            passphrase.fill(0)
            return factory
        }
    }

    companion object {
        const val SQLCIPHER_KEYSTORE_KEY = "sqlcipher_keystore_key"
        const val ANDROID_KEYSTORE = "AndroidKeyStore"
        const val ENCRYPTED_KEY = "encrypted_key"
        const val ENCRYPTION_IV = "encryption_iv"
        const val TRANSFORMATION = "AES/GCM/NoPadding"
    }
}