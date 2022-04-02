package me.lyzev.kbruteforce.util.hash

import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom

/**
 * This file is part of KBruteforce.
 * Copyright (c) 2021 Lyzev.
 *
 * @author Lyzev
 * @date 3/31/2022
 * @project KBruteforce
 * @package me.lyzev.kbruteforce.util.hash
 */
object HashUtil {

    /**
     * Generates a random salt for hashing.
     */
    @JvmStatic
    val salt: ByteArray
        get() = try {
            val salt = ByteArray(16)
            SecureRandom.getInstanceStrong().nextBytes(salt)
            salt
        } catch (e: NoSuchAlgorithmException) {
            println("Error while generating salt.")
            throw e
        }

    /**
     * Util method for hashing.
     */
    @JvmStatic
    fun hash(`in`: String, salt: ByteArray?, hash: String): String = try {
        val md = MessageDigest.getInstance(hash)
        if (salt != null) md.update(salt)
        val bytes = md.digest(`in`.toByteArray(StandardCharsets.UTF_8))
        val out = StringBuilder()
        for (b in bytes) out.append(((b.toInt() and 0xff) + 0x100).toString(16).substring(1))
        out.toString()
    } catch (e: NoSuchAlgorithmException) {
        println("Error while hashing.")
        throw e
    }
}