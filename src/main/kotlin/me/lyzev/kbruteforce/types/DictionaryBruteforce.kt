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
 * This bruteforce method needs an array of strings and bruteforces all combinations with it.
 *
 * @property dictionary the array of strings
 * @property min the start length
 * @property max the end length
 * @constructor creates an instance for bruteforcing string combinations
 */
class DictionaryBruteforce(private val dictionary: Array<String>, private val min: Int, private val max: Int) :
    Bruteforce<String>() {

    private var positions = IntArray(min)
    private var last = ""

    fun reset() {
        positions = IntArray(min)
        last = ""
    }

    override operator fun hasNext(): Boolean = Array(max) { dictionary[dictionary.size - 1] }.joinToString("") != last

    override fun next(): String {
        if (Array(positions.size) { dictionary[dictionary.size - 1] }.joinToString("") == last)
            positions = IntArray(positions.size + 1)
        val next = StringBuilder()
        positions.forEach { next.append(dictionary[it]) }
        increase(0)
        last = next.toString()
        return last    }

    private fun increase(pos: Int) {
        if (pos == positions.size)
            return
        positions[pos]++
        if (positions[pos] == dictionary.size) {
            positions[pos] = 0
            increase(pos + 1)
        }
    }
}