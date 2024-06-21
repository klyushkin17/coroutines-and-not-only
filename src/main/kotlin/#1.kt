package org.example

import kotlinx.coroutines.*
import java.util.Random

/*fun main() {
    GlobalScope.launch {

    }
}*/

/*fun main(): Unit = runBlocking {
    launch {
        val result = doWork("Hello World")
        println(result)
    }
}*/

/*fun main(): Unit = runBlocking {
    repeat(100) {
        launch {
            val result = doWork(it.toString())
            println(result)
        }
    }
}*/

/*fun main(): Unit = runBlocking {
    repeat(100) {
        val result = doWork(it.toString())
        println(result)
    }
}*/

/*fun main(): Unit = runBlocking {
    val coroutines: List<Deferred<String>> = List(100) {
        async(start = CoroutineStart.LAZY) {
            doWork(it.toString())
        }
    }
    coroutines.forEach { println(it.await()) }
}*/

/*fun main(): Unit = runBlocking {
    val coroutines: List<Deferred<String>> = List(100) {
        async(start = CoroutineStart.DEFAULT) {
            doWork(it.toString())
        }
    }
    coroutines.forEach { println(it.await()) }
}*/

fun main(): Unit = runBlocking {
    val coroutines: List<Job> = List(100) {
        launch(start = CoroutineStart.DEFAULT) {
            doWork(it.toString())
        }
    }
    coroutines.forEach { it.cancel("canceled") }
}

suspend fun doWork(name: String): String {
    delay(Random().nextInt(5000).toLong())
    return "Done. $name"
}