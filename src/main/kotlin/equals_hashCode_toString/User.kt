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