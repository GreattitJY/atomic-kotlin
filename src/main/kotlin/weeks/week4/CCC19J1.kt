package weeks.week4

/*
You record all of the scoring activity at a basketball game. Points are scored by

-3 point shot
-2 point field shot
-1 point free shot

You know the number of each of these types of scoring for the two teams: the Apples and the Bananas.
Your job is to determine which team won, or if the game ended in a tie.

<Input Specification>

The first three lines of input describe the scoring of the Apples,
and the next three lines of input describe the scoring of the Bananas.

For each team

- the first line contains the number of successful 3 point shots
- the second line contains the number of successful 2 point field goals
- the third line contains the number of successful 1 pint free throws

Each number will be an integer 0 and 100, inclusive

<Output Specification>

The output will be a single character.
If the Apples scored more points than the Bananas, output A.
If the Bananas scored more points than the Apples, output B.
Otherwise, output T, to indicate a tie.

*/

private fun inputInt(v: String, range: IntRange): Int {
    val result = v.toIntOrNull() ?: throw IllegalArgumentException("invalid int V")
    if (result !in range) throw IllegalArgumentException("out of $range: $result")
    return result
}

// 팀 스코어와 그에 해당하는 가중치를 받아서 계산한 뒤 반환한다.
private fun calcScore(teamScore: List<Int>, weight: List<Int>): Int {
    if (teamScore.size != weight.size) throw IllegalArgumentException("invalid size: ${teamScore.size} != ${weight.size}")
    var score = 0
    for (i in teamScore.indices) {
        score += teamScore[i] * weight[i]
    }
    return score
}


fun ccc19j1() {
    val input = System.`in`.bufferedReader()

//   인덱스 기준으로 0: 3점, 1: 2점, 2: 1점
    val weight = listOf<Int>(3, 2, 1)

    val a3 = input.readLine().let { inputInt(it, 0..100) }
    val a2 = input.readLine().let { inputInt(it, 0..100) }
    val a1 = input.readLine().let { inputInt(it, 0..100) }

    val b3 = input.readLine().let { inputInt(it, 0..100) }
    val b2 = input.readLine().let { inputInt(it, 0..100) }
    val b1 = input.readLine().let { inputInt(it, 0..100) }

    val scoreA = calcScore(listOf(a3, a2, a1), weight)
    val scoreB = calcScore(listOf(b3, b2, b1), weight)
    val result = when {
        scoreA > scoreB -> 'A'
        scoreA < scoreB -> 'B'
        else -> 'T'
    }
    println(result)
}