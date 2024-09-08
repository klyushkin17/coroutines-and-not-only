package coroutines

import kotlinx.coroutines.*

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
    }
    job.start()
    job.cancel()
}
