package generic

fun main () {
    var integers = (1..10).toList().customFilter { it > 5 }
    var triple = Triple(1, "Bue", true)
    var customTriple = CustomTriple<Int, String, Boolean>(2, "Buy", true)
    customTriple.printTypes()
}

fun <T : Number> List<T>.customFilter(filterFunction: (T) -> (Boolean)): List<T> {
    val resultList = mutableListOf<T>()
    for (item in this) {
        if (filterFunction(item)) {
            resultList.add(item)
        }
    }
    return resultList
}

/*
fun <T : Number> List<T>.customFilter(filterFunction: (T) -> (Boolean)): List<T> {
    val resultList = mutableListOf<T>()
    for (item in this) {
        if (filterFunction(item)) {
            resultList.add(item)
        }
    }
    return resultList
}*/
