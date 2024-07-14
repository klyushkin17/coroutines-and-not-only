package null_safety

fun main() {
    val answer = getAnswer("Any question")

    // !!. - мы уверены, что answer не будет равен null и функция toUpperCase() вызовиться в любом случае
/*println(answer!!.toUpperCase())


    // ?. - мы не уверены, что answer не будет равен null и функция to UpperCase() не вызовиться, если answer == null
println(answer?.toUpperCase())


    // ?: - так можно выкинуть ошибку в случает null
println(answer?:throw UserNotFound())


    // ?: - так можно подсавить дефолтное значение в случае null
println(answer?: "Default answer")*/

}


fun getAnswer(question: String): String? {
    var answer: String? = null

    if (question.length < 10) {
        answer = "This is your answer"
    }

    return answer
}

