package constructors

//Первичный конструктр
/*class Ingredient constructor() {

    var name = "some name"
    var weight = 999
    var count = 888
}*/

//Основной конструктор
/*
class Ingredient constructor(
    val name: String,
    val weight: Int,
    val count: Int
) {
}
*/

//Вторичный конструктор + init{}
class Ingredient constructor(
    val name: String,
    val weight: Int,
    val count: Int
) {
    var isNeedToPrepare = false

    constructor(
        name: String,
        weight: Int,
        count: Int,
        _isNeedToPrepare: Boolean,
    ): this(name, weight, count) {

        isNeedToPrepare = _isNeedToPrepare

    }

    init {
        println("info message")
    }

    init {
        println("another message")
    }

    // Порядок выполнения блоков кода:
    // вторичный конструктор
    // первичный конструктор
    // блоки init
    // тело вторичного конструктора
}
