import kotlin.concurrent.thread
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
fun main()=runBlocking {
    val time1 = measureTimeMillis {
        val thread1 = thread {
            repeat(5000) {
                //Thread.sleep(1000)
            }
        }
    }
    println(time1)
    val time2 = measureTimeMillis {
        launch {
            repeat(5000) {
                //delay(1000)
            }
        }
    }
    println(time2)


    val time5 = measureTimeMillis {
        runBlocking {
            repeat(5000) {
                //delay(1000)
            }
        }
    }
    println(time5)
}