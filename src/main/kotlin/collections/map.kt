package collections

/*
This problem can be solved by maps

val passportNumbers = listOf("123", "321", "231")
val persons = listOf("Ivan Ivanov", "Petr Petrov", "Stepan Stepanov")

fun main(){
    val person = getPersonByPassportNumber("123")
    println(person)
}

fun getPersonByPassportNumber(number: String): String {
    val personIndex = passportNumbers.indexOf(number)
    return persons[personIndex]
}*/

fun main() {
    val passport = mutableMapOf(
        "123" to "Ivan Ivanov",
        "321" to "Pert Petrov",
        "231" to "Stepan Stepanov",
        "231" to "Boris Godunov",
        null to "Null Nullov"
    )

    val phoneNumbers = mapOf<Int, Float>(
        12345 to 125.65f,
        12346 to 125.65f,
        12347 to 125.65f,

    )

    val books = mapOf(
        "Ivan Ivanov" to listOf("Book 1", "Book 2"),
        "Petr Ivanov" to listOf("Book 3", "Book 4"),
    )
    println(passport.get("231")) //Если ключи повторяются, то они будут перезаписываться и валидным останется последний в списке
    println(passport["25"]) //Обращение к несуществующему элементу возвращает null
    println(phoneNumbers[12345])
    println(books["Petr Ivanov"])
    println(passport[null]) //ключ может быть null
    println(passport.values)
    println(passport.keys)
    println(passport.size)
    println(passport.entries) //key=value
    println(passport.containsKey("123"))
    passport.put("456", "Someone Someonov")
    println(passport)
    passport["678"] = "Justine Bieber"
    println(passport)
    passport.replace("456", "Somebody")
    println(passport)
    passport.remove("456")
    println(passport.entries)

    for (pair in passport) {
        println(pair.key)
        println(pair.value)
    }
}