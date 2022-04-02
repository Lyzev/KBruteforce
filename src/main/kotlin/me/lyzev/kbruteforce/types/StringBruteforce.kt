package me.lyzev.kbruteforce.types

import me.lyzev.kbruteforce.Bruteforce

/**
 * This file is part of KBruteforce.
 * Copyright (c) 2021 Lyzev.
 *
 * @author Lyzev
 * @date 3/30/2022
 * @project KBruteforce
 * @package me.lyzev.kbruteforce.types
 *
 * This bruteforce method needs an array of chars and bruteforces all combinations with it.
 *
 * @property chars the array of chars
 * @property min the start length
 * @property max the end length
 * @constructor creates an instance for bruteforcing char combinations
 */
class StringBruteforce(private val chars: CharArray, private val min: Int, private val max: Int) :
    Bruteforce<String>() {

    private var positions = IntArray(min)
    private var last = ""

    fun reset() {
        positions = IntArray(min)
        last = ""
    }

    override operator fun hasNext(): Boolean = String(CharArray(max) { chars[chars.size - 1] }) != last

    override fun next(): String {
        if (String(CharArray(positions.size) { chars[chars.size - 1] }) == last)
            positions = IntArray(positions.size + 1)
        val next = StringBuilder()
        positions.forEach { next.append(chars[it]) }
        increase(0)
        last = next.toString()
        return last
    }

    private fun increase(pos: Int) {
        if (pos == positions.size)
            return
        positions[pos]++
        if (positions[pos] == chars.size) {
            positions[pos] = 0
            increase(pos + 1)
        }
    }
}