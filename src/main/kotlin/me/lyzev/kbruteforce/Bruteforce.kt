package me.lyzev.kbruteforce

/**
 * This file is part of KBruteforce.
 * Copyright (c) 2021 Lyzev.
 *
 * @author Lyzev
 * @date 3/30/2022
 * @project KBruteforce
 * @package me.lyzev.kbruteforce
 *
 * An abstract call to create bruteforce methods.
 *
 * @param T the output type of the bruteforce method
 */
abstract class Bruteforce<T> : Iterator<T>, Iterable<T> {

    override operator fun iterator(): Iterator<T> = this
}