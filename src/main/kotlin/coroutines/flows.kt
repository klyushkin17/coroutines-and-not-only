package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*


// flow - это холодный стрим, что значит, что он работает лишь тогда, когда у него есть получатель, то есть
// вызывается .collect()
suspend fun main(){

    val flow1 = flow {
        emit(1)
        delay(500L)
        emit(2)
    }

    coroutineScope {
        flow1.flatMapConcat { value ->
            flow {
                emit(value + 1)
                delay(500L)
                emit(value + 2)
            }
        }.collect { value ->
            print(value)
        }
    }

    val recipeFlow = (1..6).asFlow()

    coroutineScope {
        recipeFlow.flatMapConcat { id ->
            getRecipeById(id)
        }.collect { value ->
            println(value)
        }
    }

    coroutineScope {
        val count = startTimer(10)
            // typical operators
            .filter { value ->
                value % 2 == 0
            }
            .map { value ->
                value * value
            }
            .onEach { value ->
                println(value)
            }
            // terminal operators
            /*.fold(100) { acc, value ->
                acc + value
            }*/
            /*.reduce { accumulator, value ->
                accumulator + value
            }*/
            .count { value ->
                value % 2 == 0
            }
        println(count)
    }

    // Метод .collectLatest для flow будет отменять действия с полученным из flow значением, если уже пришло новое значение
    coroutineScope {
        startTimer(10).collectLatest { value ->
            delay(1500L)
            println()
            // В таком случае collectLatest даст выполниться только последнему элементу из flow
            // Такой подход будет полезен для обновления данный в ui, так как в нем актуален лишь последний state
        }
    }

    val cafeFlow = flow {
        delay(250L)
        emit("Appetizer")
        delay(1000L)
        emit("Main dish")
        delay(100L)
        emit("Dessert")
    }

    coroutineScope {
        // Функция buffer() позволяет емитить данные и получать их в разных корутинах
        // Если бы мы не прописали buffer, то flow не заменит данные, пока в блоке collect не завершиться обработка
        // кода
        // Функция conflate() так же переводит emit и collect в разные потоки, но при этом collect обрабатывает только самые
        // последние вхождения во flow, при этом забив хер на те, которые были очереди спереди. Он их удаляет из обработки
        cafeFlow.onEach { dish ->
            println("$dish is delivered")
        }.buffer().collect { dish ->
            println("Start eating $dish")
            delay(1500L)
            println("Finish eating $dish")
        }
    }
}

suspend fun startTimer(initialValue: Int): Flow<Int> {
    return flow {
        var startValue = initialValue

        while (startValue >= 0) {

            emit(startValue)
            delay(1000L)
            startValue--
        }
    }
}


