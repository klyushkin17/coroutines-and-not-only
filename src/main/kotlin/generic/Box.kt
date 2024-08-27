package generic

class Box<T, E>(
    var boxElement: T,
    var boxElement2: E
): Storage<T, E>{
    override fun get(): T {
        return boxElement
    }

    override fun get2(): E {
        return boxElement2
    }

    override fun add(
        addingBoxElement: T
    ) {
        boxElement = addingBoxElement
    }
}