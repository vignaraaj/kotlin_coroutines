import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
fun printNumbersFromCoroutine() {
    for (i in 1..50) {
        print (" $i ")
//        delay(5)
    }
}
fun main() {

    runBlocking (Dispatchers.IO){ // coroutineScope uses default dispatcher by default
        val time = measureTimeMillis {
            val c1 = launch {
                println("${Thread.currentThread().name}")
                printNumbersFromCoroutine()
            }
            val c2 = launch {
                println("${Thread.currentThread().name}")
                printNumbersFromCoroutine()
            }
            val c3 = launch {
                println(Thread.currentThread().name)
                printNumbersFromCoroutine()
            }
            val c4 = launch {
                println(Thread.currentThread().name)
                printNumbersFromCoroutine()
            }
            val c5 = launch {
                println("${Thread.currentThread().name}")
                printNumbersFromCoroutine()
            }
            val c6 = launch {
                println("${Thread.currentThread().name}")
                printNumbersFromCoroutine()
            }
            val c7 = launch {
                println("${Thread.currentThread().name}")
                printNumbersFromCoroutine()
            }
            val c8 = launch {
                println("${Thread.currentThread().name}")
                printNumbersFromCoroutine()
            }
            val c9 = launch {
                println("${Thread.currentThread().name}")
                printNumbersFromCoroutine()
            }
            val c10 = launch {
                println("${Thread.currentThread().name}")
                printNumbersFromCoroutine()
            }
            c1.join()
            c2.join()
            c3.join()
            c4.join()
            c5.join()
            c6.join()
            c7.join()
            c8.join()
            c9.join()
            c10.join()
        }
        println("time-" + time)
    }

}



