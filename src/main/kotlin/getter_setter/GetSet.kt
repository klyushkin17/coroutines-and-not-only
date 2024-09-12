package getter_setter


class Box(
    var length: Int = 10,
    var width: Int = 20,
    var height: Int = 5,
) {

    val volume: Int
        get() = length * width * height

    var boxName: String = "Default name"
        set(value) {
            if (value.length < 3) println("The name is too short")
            else field = value
        }
}


fun main() {
    val box = Box()

    println(box.volume)

    box.boxName = "lo"
    println(box.boxName)

    box.boxName = "My box box"
    println(box.boxName)
}