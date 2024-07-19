package collections

fun main() {
    val mySet = setOf("apple", "banana", "orange", "apple")
    val mySet2 = setOf("banana", "orange", "watermelon")
    println(mySet)
    val contains = mySet.contains("apple")
    println(contains)

    val mutableSet = mutableSetOf(1, 2, 3, 1, 4, 5)
    println(mutableSet)

    mutableSet.add(9)
    println(mutableSet)
    mutableSet.add(2)
    println(mutableSet)

    for (element in mutableSet) {
        print(element)
    }

    println()

    val mySet3 = mySet.union(mySet2)
    println(mySet3)

    val mySet4 = mySet.intersect(mySet2)
    println(mySet4)

    val mySet5 = mySet.subtract(mySet2)
    println(mySet5)

}