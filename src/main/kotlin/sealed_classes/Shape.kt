package sealed_classes

sealed class Shape {
    data class Circle(var radius: Float): Shape()
    class Square(var side: Int): Shape()
    object NotAShape: Shape()

    /*sealed class Line: Shape()
    sealed interface Draw*/
}

class Rectangle(var length: Int, var breadth: Int): Shape()

fun main() {

    var circle = Shape.Circle(3.0f)
    var square = Shape.Square(8)
    var rectangle = Rectangle(20, 10)
    var noShape = Shape.NotAShape

    checkShape(noShape)

}


fun checkShape(shape: Shape) {
    when (shape) {
        is Shape.Circle -> println("Circle area...")
        is Shape.Square -> println("Square area...")
        is Rectangle -> println("Rec area...")
        is Shape.NotAShape -> println("No Shape found")
    }
}