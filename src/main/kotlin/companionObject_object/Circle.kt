package companionObject_object

import sealed_classes.Shape
import kotlin.random.Random

class Circle (
    private val radius: Double
) {
    companion object {
        fun createRandomCircle(): Circle {
            val radius = Random.nextDouble(1.0, 10.0)
            return Circle(radius)
        }
    }

    init {
        println("Circle created with radius = $radius")
        println("And area = ${area()}")
        println("And perimeter = ${perimeter()}")
    }

    private fun area() = radius * radius * ImportantConstants.PI

    private fun perimeter() = 2 * radius * ImportantConstants.PI
}