package extenstions

fun main(){
    val a = "Hello"
    val b = a[2]
    val c = a.getThirdLetter()
    println(b)
    println(c)

    val array = arrayOf(1, 2, 3, 4, 5)

    val element1 = array[0]
    val element2 = array[array.size - 1]
    array[0] = element2
    array[array.size - 1] = element1
    println(array[0])
    println(array[array.size - 1])

    array.swap(0, 1)
    array.print()

    println()

    val dog = Dog()
    dog.bark()
    dog.sleep()
}

class Dog{
    fun bark() {
        println("Woof")
    }
}

fun String.getThirdLetter(): Char{ // Функция расширения. Тем самым класс расширяется, но не изменяется
    return this[2]
}

fun <T> Array<T>.swap(index1: Int, index2: Int){
    val element1 = this[index1]
    val element2 = this[index2]
    this[index1] = element2
    this[index2] = element1
}

fun <T> Array<T>.print(){
    this.forEach { element ->
        print("$element ")
    }
}

fun Dog.sleep() {
    println("Zzzzz")
}

fun Dog.bark() {
    println("Dav")
}