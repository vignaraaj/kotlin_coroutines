import kotlin.concurrent.thread
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
fun main(){
    val time1 = measureTimeMillis {
        val thread1 = thread{
            repeat(50){
            //Thread.sleep(1000)
            }
        }
    }
    println(time1)
    val time2 = measureTimeMillis {
        CoroutineScope(Dispatchers.Default).launch{// don't prefer globalscope takes more time when executed for first time and then takes less time from 2nd execution
            repeat(50){
                //delay(1000)
            }
        }
    }
    println(time2)
    val time3 = measureTimeMillis {
        runBlocking{
            repeat(50){
                //delay(1000)
                yield()
            }
        }
    }
    println(time3)
}