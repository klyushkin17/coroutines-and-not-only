package inheritance

import com.sun.jdi.InvalidCodeIndexException

fun main() {
    val ship1 = Spaceship("ship1", 500)
    ship1.runSystemDiagnostic()
    ship1.switchToWarpMode()
    println()

    val scout1 = Scout("scout1", 750, 100, 1000)
    scout1.runSystemDiagnostic()
    scout1.switchToWarpMode()
    scout1.runAfterburner()
    scout1.handleDataFromRadar()
    println()

    val industrial1 = Industrial("industrial1", 250, 8)
    industrial1.runSystemDiagnostic()
    industrial1.switchToWarpMode()
    industrial1.lunchScanningDrones()
    println()
}