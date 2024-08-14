package extenstions

fun main() {
    val number = 123
    println(number.digitsSum())
}

fun Int.digitsSum(): Int {
    var number = this
    var sum = 0
    while (number > 0) {
        sum += number % 10
        number /= 10
    }
    return sum
}

