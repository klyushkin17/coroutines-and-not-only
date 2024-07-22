package abstract_interface

fun main() {
    val upsilonShuttle = Upsilon(50)

    upsilonShuttle.runDiagnostic()
    upsilonShuttle.prepareForTakeoff()
    upsilonShuttle.prepareForLanding()
    upsilonShuttle.startEngine()
    upsilonShuttle.startShooting()
}