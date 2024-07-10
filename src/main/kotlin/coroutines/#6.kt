package org.example.coroutines

/*
///Синхронизация между корутинами///
Синхронизация между корутинами заключается в том, чтобы не возникло ситуации, когда разные потоки
обращаются к одному критическому участку кода в один и тот же отезок времени

Захват блокировки
Снять блокировку необходимо на том же потоке, в котором она была поставлен, соответсвенно
между созданием и снятием блокировки не должно быть вызовов suspend функций, так как нет гаранта,
что они будут выполняться в том же потоке

var counter = 0
val lock = ReentrantLock()
val jobs = List(100) {
    scope.launch() {
        repeat(1_000) {
            lock.withLock
                counter += generateInt()
            }
        }
    }
}
jobs.joinAll()

Так же можно использовать mutex. Здесь, в критическом блоке кода может быть вызвана suspend функция
var counter = 0
val mutex = Mutex()
val jobs = List(100) {
    scope.launch() {
        repeat(1_000) {
            mutex.withLock
                counter += generateInt()
            }
        }
    }
}
jobs.joinAll()


Последовательный доступ
Так же, для обеспечения последовательного доступа можно создать отдельный диспатчер, который будет
гарантировать работу на отдельном

var counter = 0
val counterContext = newSingleThreadContext("Counter")
val jobs = List(100) {
    scope.launch() {
        repeat(1_000) {
            withContext(counterContext) {
                counter += generateInt()
            }
        }
    }
}
jobs.joinAll()
counterContext.close()


Использование каналов для синхронизации

fun main() {

}*/
