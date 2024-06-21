package org.example

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

///Обработка ошибок в корутинах///

//Обработка ошибок при спользовании launch
/*fun main() {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            TODO()
        } catch (e: Exception) {
            // Обработка исключений
        }
    }
}*/

//Обработка ошибок при использовании async-await
/*
supervisorScope {
    val deferred = async {
        soSomethingLong()
    }

    try {
        deferred.await()
    } catch (e: Exception) {
        //Обрабатываем исключение
    }
}

Для того, чтобы отловить абсолютно все исключения, и чтобы исключения не пробрасывались в
родительский Scope можно использовать coroutineScope:
try {
    coroutineScope {
        todo
    } catch (e: Exception) {
        // Обработка ВСЕХ исключений в Scope
    }
}

Уведомление об ошибке в корутине:

val job = launch() {
    todo
}

job.invokeOnCompletion { cause: Throwable? ->
    is (cause != null) {
        Ошибка произошла
    } else {
        Ошбики нет
    }
}

Для того, чтобы обработать отмену (cancel) используется CancellationException, но чтобы не нарушать
работу отмены
launch {
    try {
        todo
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        // Обрабока других исключений
    }
}

Как вызвать suspend функцию, которая будет вывываться при завершении корутины с ошбикой или отменой

val inputStream: InputStream
try {
    doSomethingLong(inputStream)
} catch (e: Exception) {
    // Обработка исключений
} finally {
    withContext(NonCancellable) {
        shutdown(inputSteam)
    }
}
*/

