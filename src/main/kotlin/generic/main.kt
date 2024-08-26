package generic

import java.nio.BufferUnderflowException

class Gun(
    val gunName: String
) {

}

fun main() {
    val ak47 = Gun("ak-47")
    val pistol = Gun("desert eagle")
    val box = Box(ak47)
    println(box.get().gunName)
    box.add(pistol)
    println("After changing")
    println(box.get().gunName)
}