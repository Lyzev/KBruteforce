package me.lyzev.kbruteforce

/**
 * This file is part of KBruteforce.
 * Copyright (c) 2021 Lyzev.
 *
 * @author Lyzev
 * @date 3/30/2022
 * @project Bruteforce
 * @package me.lyzev.kbruteforce
 */
class KBruteforce(private val chars: CharArray, min: Int, private val max: Int) : Iterator<String>, Iterable<String> {

    private var positions = IntArray(min)
    private var last = ""

    override operator fun hasNext(): Boolean = String(CharArray(max) { chars[chars.size - 1] }) != last

    override operator fun next(): String {
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

    override operator fun iterator(): Iterator<String> = this
}