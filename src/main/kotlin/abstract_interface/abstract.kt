package abstract_interface

abstract class SpaceShuttle(
) : Movable, Shootable{
    abstract val tankSize: Int
    open fun runDiagnostic(){}
}

//При наследовании от абстрактного класса необходимо переопределить все поля и методы
// помеченные ключевым словом abstract
class Upsilon(override val tankSize: Int) : SpaceShuttle() {
    override fun runDiagnostic() {
        println("Диагностика запущена")
    }

    override fun prepareForTakeoff() {
        println("Развернуть крылья")
    }

    override fun prepareForLanding() {
        println("Свернуть крылья")
    }

    override fun startShooting() {
        println("Начать стрельбу")
    }

    override fun reloadGuns() {
        println("Перезарядить орудия")
    }
}