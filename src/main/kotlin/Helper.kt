import kotlinx.coroutines.*
class Helper {
    companion object {
        suspend fun simpleFunc1(c:CoroutineScope):Deferred<String> { // runs on main thread
            println("${Thread.currentThread().name} inside simpleFunc1")
            println(this)//Helper$Companion@6ad8b69e
            val result:Deferred<String>  =
                c.async (start=CoroutineStart.LAZY){
                    println("${Thread.currentThread().name} inside simpleFunc1,async")
                    println(this)//LazyDeferredCoroutine{Active}@72c25a4d
                    delay(100)
                    "async2"
            }
            return result
        }
        suspend fun simpleFunc2(c:CoroutineScope):String { //runs on main thread
            println("${Thread.currentThread().name} inside simpleFunc2")
            println(this)//Helper$Companion@6ad8b69e
            val result:Deferred<String>  =
                c.async {
                    println("${Thread.currentThread().name} inside simpleFunc2,async")
                    println(this)//DeferredCoroutine{Active}@33ee8d8b
                    delay(100)
                    "async2"
                }
            return result.await()
        }
        suspend fun simpleFunc3(c:CoroutineScope):Deferred<String> { //runs on main thread
            println("${Thread.currentThread().name} inside simpleFunc3")
            println(this)//Helper$Companion@6ad8b69e
            val result:Deferred<String>  =
                c.async (start=CoroutineStart.LAZY){
                    println("${Thread.currentThread().name} inside simpleFunc3,async")
                    println(this)
                    println("lazy initialize")
                    delay(100)
                    "async3"
                }
            return result
        }
        suspend fun simpleFunc4():Deferred<String>{
            println("${Thread.currentThread().name} inside simpleFunc4")
            println(this)//Helper$Companion@6ad8b69e
            val result:Deferred<String>  =
                GlobalScope.async {
                    delay(100)
                    println("${Thread.currentThread().name} inside simpleFunc4,async")
                    println(this)
                    println("Not lazily initialised")
                    "async4"
                }
            return result
        }
    }
}