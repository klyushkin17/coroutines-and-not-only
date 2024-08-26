package generic

interface Storage<T> {
    fun get(): T
    fun add(storageElement: T)
}