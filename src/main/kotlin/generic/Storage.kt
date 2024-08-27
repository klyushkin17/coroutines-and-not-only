package generic

interface Storage<T, E> {
    fun get(): T
    fun get2(): E
    fun add(storageElement: T)
}