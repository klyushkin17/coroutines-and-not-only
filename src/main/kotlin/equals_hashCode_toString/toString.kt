package equals_hashCode_toString

fun main() {
    val user1 = User("123456", "Doe", 25)
    val user2 = User("123456", "Doe1", 30)

    println(user1 == user2)
    println(user1.hashCode())
    println(user2.hashCode())
}