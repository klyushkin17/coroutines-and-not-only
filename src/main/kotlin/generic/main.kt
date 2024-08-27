package generic

import java.nio.BufferUnderflowException

data class Gun(
    val gunName: String
)

data class Candy(
    val candyName: String
)

fun main() {
    val ak47 = Gun("ak-47")
    val pistol = Gun("desert eagle")
    val candy = Candy("RotFront")
    val box = Box(ak47, candy)
    println(box.get().gunName)
    box.add(pistol)
    println("After changing")
    println(box.get().gunName)
    someGenericFunction(ak47)
}

fun <T> someGenericFunction (
    someAnyTypeValue: T
) {

}
