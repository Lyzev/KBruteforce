package me.lyzev.example

import me.lyzev.kbruteforce.Bruteforce
import me.lyzev.kbruteforce.multithread.MultiBruteforce
import me.lyzev.kbruteforce.types.DictionaryBruteforce
import me.lyzev.kbruteforce.types.StringBruteforce
import me.lyzev.kbruteforce.util.hash.hashes.SHA3

/**
 * This file is part of Bruteforce.
 * Copyright (c) 2021 Lyzev.
 *
 * @author Lyzev
 * @date 3/31/2022
 * @project Bruteforce
 * @package me.lyzev.example
 */
fun main() {
    var bruteforce: Bruteforce<*> = StringBruteforce(charArrayOf('a', 'b', 'c', 'd'), 1, 5) // chars to bruteforce, start length, end length
    var multiBruteforce = MultiBruteforce(bruteforce, 50) { // bruteforce instance, amount of threads, unit/thread to execute
        println(SHA3.hash256(it.toString())) // prints the sha3 256 hash of the current bruteforce string
    }
    multiBruteforce.start() // starts the multithreading

    bruteforce = DictionaryBruteforce(arrayOf("Game", "Password", "Life"), 1, 5) // words combinations to bruteforce, start length, end length
    multiBruteforce = MultiBruteforce(bruteforce, 50) { // bruteforce instance, amount of threads, unit/thread to execute
        println(it.toString()) // prints the current bruteforce string
    }
    multiBruteforce.start() // starts the multithreading
}