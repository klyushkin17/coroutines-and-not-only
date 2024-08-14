package interfaces

interface InterfaceA {
    val value1: Int

    fun methodA(someValue: Int): Int {
        return someValue
    }
}

interface InterfaceB {
    val value1: Int

    fun methodA(someValue: Int): Int {
        return someValue
    }

    fun methodB()
}

class ClassA(override val value1: Int, private val value2: Int): InterfaceB, InterfaceA {
    override fun methodA(someValue: Int): Int {
        TODO("Not yet implemented")
    }

    override fun methodB() {
        TODO("Not yet implemented")
    }
}
