package me.lyzev.kbruteforce.multithread

import me.lyzev.kbruteforce.Bruteforce
import java.util.concurrent.Executors

/**
 * This file is part of KBruteforce.
 * Copyright (c) 2021 Lyzev.
 *
 * @author Lyzev
 * @date 3/30/2022
 * @project KBruteforce
 * @package me.lyzev.kbruteforce.multithread
 *
 * This class can multithread a bruteforce.
 *
 * @property bruteforce the instance of the bruteforce method
 * @property threads the amount of threads
 * @property thread the lambda will be executed for every output of the bruteforce method
 * @constructor creates an instance for multithreading a bruteforce method
 */
class MultiBruteforce(private val bruteforce: Bruteforce<*>, threads: Int, private val thread: (current: Any) -> Unit) {

    private val threadPool = Executors.newFixedThreadPool(threads) // thread pool for multithreading

    /**
     * Starts the multithreaded bruteforce
     */
    fun start() {
        for (current in bruteforce) {
            threadPool.submit {
                thread(current!!)
            }
        }
        threadPool.shutdown()
    }
}