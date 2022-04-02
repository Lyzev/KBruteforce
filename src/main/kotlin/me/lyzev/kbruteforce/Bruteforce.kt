package me.lyzev.kbruteforce

/**
 * An abstract call to create bruteforce methods.
 *
 * @author Lyzev
 * @param T the output type of the bruteforce method
 */
abstract class Bruteforce<T> : Iterator<T>, Iterable<T> {

    override operator fun iterator(): Iterator<T> = this
}