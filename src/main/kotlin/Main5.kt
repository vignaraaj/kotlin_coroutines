import kotlinx.coroutines.*
fun main() {
    val job1 = runBlocking {
        val scope = this  // this refers to coroutineScope which just has the context of the coroutine(CoroutineContext)
        val job1 = this.launch(Dispatchers.Default + Job() + CoroutineName("1")) {//though child
                // takes parents scope it inherently takes parent's context too but if needed the context can be changed like here
                //the elements of context  which are not mentioned while creating coroutine (constructor of launch) are took from parents context
                //the elements are dispatchers, name, job object and etc
                println("${Thread.currentThread().name}")
                printNumbersFromCoroutine()
            }
        val job2 = this.launch(Dispatchers.Default + CoroutineName("2")) {// here 'this' is not needed by default the scope of parent is given to child as its scope
                println("${Thread.currentThread().name}")
                printNumbersFromCoroutine()
            }
        val job3 = this.launch(Dispatchers.Default + CoroutineName("3")) {
            println("${Thread.currentThread().name}")
            printNumbersFromCoroutine()
        }
        "Completed tasks using coroutines that use different threads(worker threads created by default dispatcher"
        job1.join()  //optional since runBlocking blocks current thread until it executes all of its coroutines
        job2.join()
        job3.join()
        }
    println(job1)
}
