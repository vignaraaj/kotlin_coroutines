import kotlinx.coroutines.*
import kotlin.concurrent.thread
fun main() {
    println("${Thread.currentThread().name} inside main")
    runBlocking {//runBlocking itself defines its own coroutine scope
        println(StringBuilder().append(this).append( " ${Thread.currentThread().name} inside main,runBlocking"))
        val result1 = Helper.simpleFunc1(this)
        println(result1.await())
        val result2 = Helper.simpleFunc2(this)
        println(result2)
        val result4 = Helper.simpleFunc4()
        //println(result4.await())
    }
    GlobalScope.launch{
        val result3 = Helper.simpleFunc3(this)
        //println(result3.await())
    }
    thread {
        println("${Thread.currentThread().name} inside thread")
        Thread.sleep(300)// blocks the thread
    }
//    println("${Thread.activeCount()}" + " -> Thread count ")
}



