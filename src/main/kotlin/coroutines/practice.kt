package coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.coroutines.EmptyCoroutineContext

var counter = 0

suspend fun main(): Unit = coroutineScope {
    val result: Deferred<String> = CoroutineScope(Dispatchers.IO).async {
        println("Do some Job")
        "result"
    }

    val coroutineResult = result.await()

    val job = launch(
        context = Dispatchers.Main,
        start = CoroutineStart.LAZY
    ){

        // Все suspend фукции из библиотке kotlinx.coroutines при вызове метода cancel() у job
        // вызывют CancellationException. Но для того, чтобы такой же сценарий работал для собственных suspend функций
        // необходимо прописывать проверки
        launch(Dispatchers.IO + Job() + CoroutineName("someName")){
            repeat(5) {
                if (this.isActive) {
                    println("someShit")
                } else {
                    println("Error")
                    return@launch
                }
            }

            repeat(5) {
                ensureActive()
            }

            repeat(5) {
                yield()
            }
        }

        // Если не отловить исключения, то есть риск уадлить практически все job в дереве
        // Чтобы этого избежать существует SupervisorJob, который не позволит удалять родительские job

        CoroutineScope(Dispatchers.Main).launch {
            launch(SupervisorJob()) {
                launch {
                    delay(1000L)
                }
                launch {
                    throw RuntimeException()
                }
            }
        }
        // В данном примере удалиться как первая, так и вторая дочерние корутины
        // Так как при объявлении новой корутины создается новый Job, на основе родительского, который
        // передается в скобках

        CoroutineScope(Dispatchers.Main).launch {
            val sharedJob = SupervisorJob()

            launch(sharedJob) {
                delay(1000L)
            }

            launch(sharedJob) {
                throw RuntimeException()
            }
        }

        // Данный же пример решает проблему, но есть вариант без явного создания Job

        CoroutineScope(Dispatchers.IO).launch {
            supervisorScope {
                launch {
                    delay(1000L)
                }

                launch {
                    throw RuntimeException()
                }
            }
        }

        // Как поймать исключение

        // 1) try/catch
        CoroutineScope(context = EmptyCoroutineContext).launch {
            launch {
                try {
                    delay(100L)
                    throw RuntimeException()
                } catch (e: Exception){
                    // Exception handling
                }
            }
        }

        // 2) runCaching
        CoroutineScope(context = EmptyCoroutineContext).launch {
            launch {
                val result: Result<Unit> = kotlin.runCatching {
                    delay(100L)
                    throw RuntimeException()
                }
            }
        }

        // 3) CoroutineExceptionHandler

        CoroutineScope(context = EmptyCoroutineContext).launch {
            val handler = CoroutineExceptionHandler { _, exception ->
                println("Exception $exception handled")
            }

            launch(SupervisorJob() + handler) {
                try {
                    delay(100L)
                    throw RuntimeException("bruh")
                } catch (e: Exception){
                    // Exception handling
                }
            }
        }
    }
    job.start()
    job.cancel()


    // Share States
    massiveRun { counter++ }
    println(counter)

    // Channel - необходим для передачи данных между корутинами

    supervisorScope {

        val channel: Channel<String> = Channel<String>()

        //sender
        launch {
            repeat(10) { index ->
                channel.send("send index $index")
            }
            channel.close()
        }

        //receiver
        launch {
            for (message in channel) {
                println(message)
            }
        }

        //flow collection
        launch {
            emitToFlow().collect { data ->
                println(data)

            }
        }
    }


    //Разница между flow и channel в том, что
    // Channel - генерирует данные даже если нет получается
    // Flow - генерирует данные только если есть получатель
}

suspend fun massiveRun(action: suspend () -> Unit) {
    val mutex = Mutex()

    withContext(Dispatchers.Main) {
        repeat(100) {
            launch {
                repeat(100) {
                    mutex.withLock {
                        action()
                    }
                }
            }
        }
    }
}

// Для решения проблемы с доступом можно использовать: Atomic, coroutine mutex, Thread confinement (Использование одного потока для измеения данных)


suspend fun emitToFlow(): Flow<String> {
    return flow {
        repeat(2) { index ->
            emit(index.toString())
        }
    }
}