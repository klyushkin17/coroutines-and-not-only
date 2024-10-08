package data_classes

fun main() {
    val word = Word("Red", "Красный")
    val word1 = Word("Red", "Красный")
    val word2 = Word("Blue", "Синий")

    println(word === word1)
    println(word == word1)
    println(word1 == word2)
    println(word)

    println(word2)
    val word3 = word2.copy(translation = "Голубой")
    println(word3)

    println(word.hashCode())
    println(word1.hashCode())
    println()
    println(word2.hashCode())
    println(word3.hashCode())

    val classB = ClassB("one", 2, "three", 4)
    classB.someFun(classB.value1, classB.value2)
}

data class Word(
    val text: String,
    val translation: String,
)


open class ClassA(
    val value1: String,
    val value2: Int
) {
    open fun someFun(funVal1: String, funVal2: Int) {

    }
}

class ClassB(
    value1: String,
    value2: Int,
    val value3: String,
    val value4: Int
): ClassA(
    value1, value2
){
    override fun someFun(funVal1: String, funVal2: Int) {
        println(funVal1)
    }
}






