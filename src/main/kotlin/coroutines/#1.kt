package org.example.coroutines

import kotlinx.coroutines.*
import java.util.Random

// Корутины позволяют выполнять асинхронные операции, которые могут быть приостановлены
// Корутины - это легковесные потоки. Основное преимущество корутин над потоками в том, что
// они не требуют системных вызовов

// Различие между асинхронностью и параллельностью:
// Асинхронность - это концепция программирования, в которой события происходят независимо
// от главного потока, взаимодействие происходит через коллбеки
// Параллельность - несколько операций происходит одновременно

// Ключевое слово suspend приостанавливает выполнение корутины

// Сравнение выполнения тяжеловесной задачи в одном потоки и в корутине:
// Поток:
// Если в потоке произойдет вызов какой-либо функции, ответа которой необходимо ожидать, то
// данный поток заблокируется и не даст работать другим потокам. В таком случае свободные ресурсы
// не используются

// Корутины:
// Пир вызове suspend функции в корутине, корутина будет приостановлена и высвободит ресурсы для
// выполнения какой-либо другой задачи. При этом продолжение работы корутины после завершения работы suspend функции
// может происходить в другом потоке

// Как отслеживать запущенные через корутины операции:
// Каждая корутина привязана к какому-то жизненному циклу scope (Coroutine Scope)


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