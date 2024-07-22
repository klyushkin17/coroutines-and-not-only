package abstract_interface

//Интерфейсы поддерживают множественное наследование. То есть позволяют классам наследоваться от
//множества интерфейсов
interface Movable {
    fun startEngine() {
        println("Двигатель запущен")
    }
    fun prepareForTakeoff()
    fun prepareForLanding()
}