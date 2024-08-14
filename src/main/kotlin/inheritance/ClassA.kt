package inheritance

open class ClassA(
    val value1: String,
    val value2: Int
) {
    open fun methodA(someValue: Int): Int {
        return someValue
    }

    open fun methodA(someValue: Int, someValue2: Int): Int {
        return someValue
    }

    fun methodB(someValue: String): String {
        return someValue
    }
}

class ClassB(
    value1: String,
    value2: Int
): ClassA(value1, value2) {
    override fun methodA(someValue: Int): Int {
        return someValue
    }

    override fun methodA(someValue: Int, someValue2: Int): Int {
        return someValue2
    }

}

fun main() {
    val elementClassB = ClassB("someString", 666)
    elementClassB.methodB(elementClassB.value1)
    elementClassB.methodA(elementClassB.value2)
    elementClassB.methodA(elementClassB.value2, elementClassB.value2)
}