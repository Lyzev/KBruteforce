package me.lyzev.kbruteforce.util.hash.hashes

import me.lyzev.kbruteforce.util.hash.HashUtil.hash

/**
 * This file is part of KBruteforce.
 * Copyright (c) 2021 Lyzev.
 *
 * @author Lyzev
 * @date 3/31/2022
 * @project Bruteforce
 * @package me.lyzev.kbruteforce.util.hash.hashes
 */
object SHA1 {

    @JvmStatic
    @JvmOverloads
    fun hash1(`in`: String, salt: ByteArray? = null): String = hash(`in`, salt, "SHA-1")

    @JvmStatic
    @JvmOverloads
    fun hash224(`in`: String, salt: ByteArray? = null): String = hash(`in`, salt, "SHA-224")

    @JvmStatic
    @JvmOverloads
    fun hash256(`in`: String, salt: ByteArray? = null): String = hash(`in`, salt, "SHA-256")

    @JvmStatic
    @JvmOverloads
    fun hash384(`in`: String, salt: ByteArray? = null): String = hash(`in`, salt, "SHA-384")

    @JvmStatic
    @JvmOverloads
    fun hash512(`in`: String, salt: ByteArray? = null): String = hash(`in`, salt, "SHA-512")
}