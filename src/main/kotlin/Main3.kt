import kotlinx.coroutines.*
suspend fun main() {
    val s = runBlocking { // if launch or async used the main thread won't be blocked to complete its child coroutines
        launch {
            println("${Thread.currentThread().name} 1")
            yield()
        }
        println("${Thread.currentThread().name} 0")
        yield()
        launch {
            println("${Thread.currentThread().name} 2")
            yield()
        }
        launch {
            println("${Thread.currentThread().name} inside runBlocking")
            repeat(5) {
                println(it)
                yield()
            }
            //here yield() doesn't give control to another coroutine because it has no visibility of other coroutines(the new coroutine is inside other coroutine)
            launch {//since this launch is inside another launch the parent executes to reach this level and then only creates new coroutine
                println("${Thread.currentThread().name} inside runBlocking launch")
                yield()
            }
        }

        simple()//stores the value that returned by simple()
    }
// GlobalScope.launch //doesn't even execute main thread won't wait for the coroutines
    val job = CoroutineScope(Job()+Dispatchers.Default).launch {// doesn't even execute main thread won't wait for the coroutines
        launch {
            println("${Thread.currentThread().name} 1vk")
            yield()
        }
        launch {
            println("${Thread.currentThread().name} 2vi")
            yield()
        }

    }
    job.join()//the main function is made suspend, so join() waits for the above coroutine to be executed.
    println(s)
}

suspend fun simple():String{
        return coroutineScope {//runs in main thread (if you don't want to run on main thread give own dispatchers)
            launch {
                println("${Thread.currentThread().name} 1simple")
                yield()
            }
            launch {
                println("${Thread.currentThread().name} 2simple")
                yield()
            }
            "blocks main thread"
        }
    }



