import kotlin.concurrent.thread
class Thread2 : Thread() {
    override fun run(){
        println("${Thread.currentThread().name} welcome")
    }
}
fun main() {
    println("${Thread.currentThread().name}")
    thread {
        thread {
            println("${Thread.currentThread().name} Hello")
        }
        Thread2().start()
         thread {
             println("${Thread.currentThread().name} world")
         }
        println("end of thread")
    }
    println("end of main thread")
}
