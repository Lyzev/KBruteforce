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
object MD {

    @JvmStatic
    @JvmOverloads
    fun hash2(`in`: String, salt: ByteArray? = null): String = hash(`in`, salt, "MD2")

    @JvmStatic
    @JvmOverloads
    fun hash4(`in`: String, salt: ByteArray? = null): String = hash(`in`, salt, "MD4")

    @JvmStatic
    @JvmOverloads
    fun hash5(`in`: String, salt: ByteArray? = null): String = hash(`in`, salt, "MD5")
}