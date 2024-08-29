package generic

interface Source<out T> {
    fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs // Благодаря out можем присвоить Source<String> типу Source<Any>
}

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0)
    val y: Comparable<Double> = x
}

// Вывод: Если есть необходимость коллекции типов родителей присвоить коллекции
// типов наследников, то при объявлении обобщающего типа используется слово out
// Если же возникает необходимость коллекции типов наследников присвоить коллекции
// типов родителей, то при объявлении обобщающего используется in

// in показывает, что мы только передаем тип аргументам функций в классе
// out показывает, что мы только возвращаем тип аргументов функций в классе
