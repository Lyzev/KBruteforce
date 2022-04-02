package me.lyzev.kbruteforce.types

import me.lyzev.kbruteforce.Bruteforce

/**
 * This bruteforce method needs an array of chars and bruteforces all combinations with it.
 *
 * @author Lyzev
 * @param chars the array of chars
 * @param min the start length
 * @param max the end length
 * @constructor creates an instance for bruteforcing char combinations
 */
class StringBruteforce(private val chars: CharArray, private val min: Int, private val max: Int) :
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
    override operator fun hasNext(): Boolean = String(CharArray(max) { chars[chars.size - 1] }) != last

    /**
     * Gets the next bruteforce value.
     */
    override fun next(): String {
        if (String(CharArray(positions.size) { chars[chars.size - 1] }) == last)
            positions = IntArray(positions.size + 1)
        val next = StringBuilder()
        positions.forEach { next.append(chars[it]) }
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
        if (positions[pos] == chars.size) {
            positions[pos] = 0
            increase(pos + 1)
        }
    }
}