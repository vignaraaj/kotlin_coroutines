import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis
fun printNumbersFromThreads() {
    for (i in 1..50) {
        print(" $i ")
//        Thread.sleep(5)
    }
}
fun main() {
        val time = measureTimeMillis {
            val t1 = thread {
                println("${Thread.currentThread().name}")
                printNumbersFromThreads()
            }
            val t2 = thread {
                println("${Thread.currentThread().name}")
                printNumbersFromThreads()
            }
            val t3 = thread {
                println("${Thread.currentThread().name}")
                printNumbersFromThreads()
            }
            val t4 = thread {
                println("${Thread.currentThread().name}")
                printNumbersFromThreads()
            }
            val t5 = thread {
                println("${Thread.currentThread().name}")
                printNumbersFromThreads()
            }
            val t6 = thread {
                println("${Thread.currentThread().name}")
                printNumbersFromThreads()
            }
            val t7 = thread {
                println("${Thread.currentThread().name}")
                printNumbersFromThreads()
            }
            val t8 = thread {
                println("${Thread.currentThread().name}")
                printNumbersFromThreads()
            }
            val t9 = thread {
                println("${Thread.currentThread().name}")
                printNumbersFromThreads()
            }
            val t10 = thread {
                println("${Thread.currentThread().name}")
                printNumbersFromThreads()
            }
            t1.join()
            t2.join()
            t3.join()
            t4.join()
            t5.join()
            t6.join()
            t7.join()
            t8.join()
            t9.join()
            t10.join()


        }
        println("time-" + time)
}