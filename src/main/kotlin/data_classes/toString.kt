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
}

data class Word(
    val text: String,
    val translation: String,
)