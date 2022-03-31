package me.lyzev.example

import me.lyzev.kbruteforce.KBruteforce

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
    val bruteforce = KBruteforce(charArrayOf('a', 'b', 'c'), 1, 3)
    for (next in bruteforce)
        println(next)
}