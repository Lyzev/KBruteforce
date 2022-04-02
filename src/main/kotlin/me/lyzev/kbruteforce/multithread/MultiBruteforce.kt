package me.lyzev.kbruteforce.multithread

import me.lyzev.kbruteforce.Bruteforce
import java.util.concurrent.Executors

/**
 * This class can multithread a bruteforce.
 *
 * @author Lyzev
 * @param bruteforce the instance of the bruteforce method
 * @param threads the amount of threads
 * @param thread the lambda will be executed for every output of the bruteforce method
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