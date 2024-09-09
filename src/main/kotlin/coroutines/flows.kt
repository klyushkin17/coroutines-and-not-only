package coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow


// flow - это холодный стрим, что значит, что он работает лишь тогда, когда у него есть получаетль, то есть
// вызывается .collect()
suspend fun main(){
    coroutineScope {
        startTimer(10).collect{ value ->
            println(value)
        }
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


