package inheritance

class Industrial(
    name: String,
    speed: Int,
    val numbersOfMiners: Int
) : Spaceship(name, speed, unmanned = true){

    fun lunchScanningDrones() {
        println("$name сканирующие дроны запущены")
    }

    //Переопределяем функцию дочернего класса
    override fun runSystemDiagnostic() {
        super.runSystemDiagnostic() // super - позволяет обратиться к реализации метода родительского класса
        println("$name диагностика дронов завершена")
    }
}