package weeks.week5

/*
People who study epidemiology use models to analyze the spread of disease. In this problem, we use a simple model.

When a person has a disease, they infect exactly R other people but only on the very next day.
No person is infected more than once.
We want to determine when a total of more than P people have had the disease.

<Input Specification>
There are three lines of input. Each line contains one positive integer.
The first line contains the value of P.
The second line contains N, the number of people who have the disease on Day 0.
The third line contains the value of R.
Assume that P <= 10^7 and N <= P and R <= 10/

<Output Specification>
Output the number of the first day on which the total number of people who have had the disease is greater than P.
*/

// 입력받은 문자열의 유효성 검사 - 1. Int로 반환, 2. IntRange 검사
private val inputValid: (String, IntRange) -> Int = { value, range ->
    val result = value.toIntOrNull() ?: throw IllegalArgumentException("Invalid value: ${value}")
    if (result !in range) throw IllegalArgumentException("Out of range: ${range}")
    result
}

fun ccc20j2() {
    val input = System.`in`.bufferedReader()

//    목표 인원
    val P = input.readLine().let { inputValid(it, 1..10_000_000) }
//    오늘 감염된 사람
    val N = input.readLine().let { inputValid(it, 1..P) }
//    전파율
    val R = input.readLine().let { inputValid(it, 1..10) }

    var day = 0
    var totalInfected = N
    var todayInfected = N

    while (totalInfected <= P) {
        val tomorrowInfected = todayInfected * R

        totalInfected += tomorrowInfected
        todayInfected = tomorrowInfected

        day++
    }

    println(day)
}
