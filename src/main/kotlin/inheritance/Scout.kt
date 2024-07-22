package inheritance


//Так как переменные уже были объявлены в родительском классе, в классе наследнике объявлять их не обязательно
class Scout(
    name: String,
    speed: Int,
    val radarRange: Int, //Создаем дополнительные свойства для класса наследника(помечаем val)
    val afterburnerSpeed: Int,
) : Spaceship(name, speed) {

    //Добавляем новые методы для реализации класса
    fun handleDataFromRadar() {
        println("$name обработка данных с радара")
    }

    fun runAfterburner() {
        println("$name форсаж запущен")
    }
}