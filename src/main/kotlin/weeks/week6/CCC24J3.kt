package weeks.week6

/*
After completing a competition, you are struck with curiosity. How many participants were awarded bronze level?

Gold level is awarded to all participants who achieve the highest score.
Silver level is awarded to all participants who achieve the second highest score.
Bronze level is awarded to all participants who achieve the third highest score.

Given a list of all the scores, your job is to determine the score required for bronze level and how many participants achieved this score.

<Input Specification>
The first line of input contains a positive integer, N, representing the number of participants.
Each of the next N lines of input contain a single integer representing a participant's score.
Each score is between 0 and 75 (inclusive) and there will be at least three distinct scores.

<Output Specification>
Output a non-negative integer, S, and a positive integer,, separated by a single space,
where S is the score required for bronze level and P is how many participants achieved this score.
 */

private val inputInt: (String, IntRange) -> Int = { value, range ->
    val result = value.toIntOrNull() ?: throw IllegalArgumentException("invalid value: ${value}")
    if (result !in range) throw IllegalArgumentException("out of range: ${range}")
    result
}

fun ccc24j3() {
    val input = System.`in`.bufferedReader()

    val N = input.readLine().let { inputInt(it, 3..250_000) }

    var scores = mutableListOf<Int>()
    var i = 0
    while (i < N) {
        val score = input.readLine().let { inputInt(it, 0..75) }
        scores.add(score)
        i++
    }

    scores.sortDescending()

    var bronze = -1
    var bronzeCount = 0
//    level =  0: gold, 1: silver, 2: bronze
    var level = 0;
    i = 1
    while (i <= scores.lastIndex) {

        if (scores[i] != scores[i - 1]) {
            level += 1
        }

        if (level == 2) {
            bronze = scores[i]
            bronzeCount++
        }

        if (level == 3) break
        i++
    }

    println("$bronze $bronzeCount")

}