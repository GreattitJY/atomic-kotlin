package weeks.week6

/*
Fergusonball players are given a star rating based on the number of points that they score and the number of fouls that they commit.
Specifically, they are awarded 5 stars for each point scored, and 3 stars are taken away for each foul committed.
For every player, the number of points that they score is greater than the number of fouls that they commit.

Your job is to determine how many players on a team have a star rating greater than 40.
You also need to determine if the team is considered a gold team which means that all the players have a star rating greater than 40.

<Input Specification>
The first line of input consists of a positive integer N representing the total number of players on the team.
This is followed by a pair of consecutive lines for each player.
The first line in a pair is the number of points that the player scored.
The second line in a pair is the number of fouls that the player committed.
Both the number of points and the number of fouls, are non-negative integers.

<Output Specification>
Output the number of players that have a star rating greater than 40, immediately followed by a plus sign if the team is considered a gold team.
 */

// 입력받은 문자열이 positive integer, non-negative integer인지 체크
private val validInteger: (String, Boolean) -> Int = { value, includeZero ->
    val result = value.toIntOrNull() ?: throw IllegalArgumentException("Invalid value: ${value}")
    if (result < 0) throw IllegalArgumentException("Invalid negative integer: $value")
    if (!includeZero && result == 0) throw IllegalArgumentException("Invalid zero integer: $value")
    result
}

fun ccc22j2() {
    val input = System.`in`.bufferedReader()

    val N = input.readLine().let { validInteger(it, false) }

    var count = 0
    var i = 0
    while (i < N) {
        val points = input.readLine().let { validInteger(it, true) }
        val fouls = input.readLine().let { validInteger(it, true) }

        val score = (points * 5) - (fouls * 3)
        if (score < 0) throw IllegalArgumentException("socre is greater than the number of fuols that they commit")

        if (score > 40) count++
        i++
    }

    println("""${count}${if (count == N) "+" else ""}""")
}