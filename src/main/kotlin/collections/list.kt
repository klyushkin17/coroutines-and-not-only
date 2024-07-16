package collections

fun main() {
    val fruitsArray = arrayOf("Orange", "Apple", "Lime")
    val fruitsList = listOf("Orange", "Apple", "Orange", "Lime")
    var fruitsMutableList = mutableListOf("Orange", "Apple", "Orange", "Lime")

    val element = fruitsArray[1] // Аналогично с val element  = fruitArray.get(1)
    fruitsArray[2] = "Peach" // Аналогично с fruitArray.set(2, "Peach")
    println(element)
    println(fruitsArray[2])

    println(fruitsList[0])
    println(fruitsList.size)
    println(fruitsList.last()) //Получение последнего элемента
    println(fruitsList.indexOf("Orange")) //Получение индекса элемента
    println(fruitsList.lastIndexOf("Orange")) //Получение индекса последнего вхождения элемента
    println(fruitsList.subList(0, 2)) //Создание нового списка на основе данного

    /*fruitsList[1] = "Peach"*/ //Действие запрещено, так как массив изначально неизменяемый
    fruitsMutableList[1] = "Peach" //Замена значений в списке
    println(fruitsMutableList)

    fruitsMutableList.remove("Orange") //Удаление элемент из списка
    println(fruitsMutableList)
    fruitsMutableList.removeAt(1) //Удаление элемента из списка под определенным индексом
    println(fruitsMutableList)
    fruitsMutableList.removeAll(listOf("Peach", "Lime")) //Удаление элементов из списка удаляемых элементов
    println(fruitsMutableList)
    fruitsMutableList = mutableListOf("Orange", "Apple", "Orange", "Lime")
    fruitsMutableList.clear() //Отчистка списка
    println(fruitsMutableList)
    fruitsMutableList.add("Melon") //Добавление в конец списка
    println(fruitsMutableList)
    fruitsMutableList.add(0, "Pineapple") //Добавление под определенный индекс
    println(fruitsMutableList)
    fruitsMutableList.addAll(listOf("Bebra", "Shmebra")) //Добавление нескольких элементов в конец списка
    println(fruitsMutableList)
}