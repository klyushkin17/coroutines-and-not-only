package generic

class Box<T>(
    var boxElement: T
): Storage<T>{
    override fun get(): T {
        return boxElement
    }

    override fun add(
        addingBoxElement: T
    ) {
        boxElement = addingBoxElement
    }
}