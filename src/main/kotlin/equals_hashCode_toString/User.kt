package equals_hashCode_toString

data class User (var passportNumber: String, var lastName: String, var age: Int){

    override fun toString(): String {
        return "First name: $passportNumber, Last name: $lastName, Age: $age"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        return passportNumber == other.passportNumber
    }

    override fun hashCode(): Int {
        return passportNumber.hashCode()
    }
}

data class DataClass(
    val field1: Int,
    val field2 : Int,
    val field3: Int ,
    val field4: Int,
){
    override fun equals(other: Any?): Boolean {
        other as DataClass

        return field4 == other.field1
    }
}


fun main() {
    val dataClass1 = DataClass(1, 2,3, 4)
    val dataClass2 = DataClass(1, 2,3, 4)
    println(dataClass1)
    println(dataClass2 == dataClass1)
}