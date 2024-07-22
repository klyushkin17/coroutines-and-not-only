package inheritance

//В Kotlin нельзя просто так наследоваться от класса. Для этого нужно написать
//ключевое слово open
//Так же в Kotlin запрещено множественное наследование. Наследоваться можно только от одного класса, но от множества интерфейсов
//Чтобы запретить создание суперкласса, можно заменить open на abstract
open class Spaceship(
    val name: String,
    val speed: Int,
    val unmanned: Boolean = false
) {

    fun switchToWarpMode() {
        println("$name Переход в варп-режим")
    }

    // Открываем функцию для переопределения
    open fun runSystemDiagnostic() {
        println("$name Запущена диагностика системы корабля")
    }
}