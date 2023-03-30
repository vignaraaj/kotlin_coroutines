import kotlinx.coroutines.*
import kotlin.coroutines.*
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis
fun main(){
    repeat(50000) {
        thread {
            println(Thread.currentThread().name)
            //Thread.sleep(100)  // previous threads unblocks and terminates so quickly so new thread can be created so creation of thread goes infinitely
            Thread.sleep(1000)  //4071
            //Thread.sleep(10000000) // 4071
            //Thread.sleep(1000000000000000000)  //4071   (the value in ms is the extreme value)


        }
    }
    val myExecutor = Executors.newSingleThreadExecutor()  // how to use a single thread that is not main thread in coroutines as a dispatcher
    val myDispatcher = myExecutor.asCoroutineDispatcher()
    repeat(5_00_000){
        CoroutineScope(myDispatcher). launch{
            println("${Thread.currentThread().name} $it")
            delay(10000000)
            println("hi")
        }

    }
    }

//(make delay 3 hours or more so that it won't affect the code)
//500000000 --> repeat , 1000000000000000000 -- > delay(max-(317097.91 centuries)) , coroutines-->819669(starts to slow down) 0 to 819669 ,creates new thread @ 819670
//500000000 --> repeat , 1000                -- > delay ,coroutines-->637222(starts to slow down)  0 to 639537(coroutines), creates new thread @ 639538

// At an approximate rate 10000000 coroutines can be created and can be handled by a single thread itself
//OutOfMemoryError: GC overhead limit exceeded error is an error thrown by the Java virtual machine to
// indicate that the application is spending more time in garbage collection (GC) than in useful work.
// This error is thrown by JVM when the application spends 98% of the time in garbage collection.
//666851  --> 100 crore repeat,10000000 -->delay
//672104  --> 100 crore repeat,1000000000 -->delay
// 662180 coroutines are created when 10 crore times  iterated
//  639537-81000 coroutines are created when 5 crore times  iterated
//99 lakh coroutines appx created when 1 crore times iterated //10000000  --> repeat,  10000000-- > delay(3 hours),coroutines --> 0 to 9934943/9935768 , creates new thread @ 9934944/9935769
// 1 lakh  coroutines are created when 1 lakh times  iterated
//10 lakh coroutines are created if iterated for 10 lakh times
//5 lakh coroutines are created if iterated for 5 lakh times
