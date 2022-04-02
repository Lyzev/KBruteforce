package me.lyzev.kbruteforce.types

import me.lyzev.kbruteforce.Bruteforce

/**
 * This bruteforce method needs an array of strings and bruteforces all combinations with it.
 *
 * @author Lyzev
 * @param dictionary the array of strings
 * @param min the start length
 * @param max the end length
 * @constructor creates an instance for bruteforcing string combinations
 */
class DictionaryBruteforce(private val dictionary: Array<String>, private val min: Int, private val max: Int) :
    Bruteforce<String>() {

    private var positions = IntArray(min)
    private var last = ""

    /**
     * Resets the bruteforce method.
     */
    fun reset() {
        positions = IntArray(min)
        last = ""
    }

    /**
     * If it has a next bruteforce value.
     */
    override operator fun hasNext(): Boolean = Array(max) { dictionary[dictionary.size - 1] }.joinToString("") != last

    /**
     * Gets the next bruteforce value.
     */
    override fun next(): String {
        if (Array(positions.size) { dictionary[dictionary.size - 1] }.joinToString("") == last)
            positions = IntArray(positions.size + 1)
        val next = StringBuilder()
        positions.forEach { next.append(dictionary[it]) }
        increase(0)
        last = next.toString()
        return last
    }

    /**
     * Increases the bruteforce value.
     */
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