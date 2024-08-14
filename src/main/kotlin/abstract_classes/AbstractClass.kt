package abstract_classes

abstract class AbstractClass1(
    val value1: Int,
    val value2: String
) {
    val value3: String = "sfs"
    abstract val value4: String

    fun methodA(someValue: Int): Int {
        return someValue
    }
    abstract fun methodB()

    open fun methodC(someValue: Int): Int {
        return someValue
    }
}

abstract class AbstractClass2() {

}

class Class1(
    value1: Int,
    value2: String
): AbstractClass1(value1, value2) {
    override val value4: String
        get() = TODO("Not yet implemented")

    override fun methodC(someValue: Int): Int {
        return someValue
    }

    override fun methodB() {
        TODO("Not yet implemented")
    }
}