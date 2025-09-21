package weeks.week6

/*
A new and upcoming artist has a unique way to create checkered patterns. The idea is to use an M-by-N canvas which is initially entirely black.
Then the artist repeatedly chooses a row or column and runs their magic brush along the row or column.
The brush changes the colour of each cell in the row or column from black to gold or gold to black. Given the artist's choices,
your job is to determine how much gold appears in the pattern determined by these choices.

<Input Specification>
The first line of input will be a positive integer N.
The second line of input will be a positive integer N.
The third line of input will be a positive integer K.
The remaining input will be K lines giving the choices made by the artist.
Each of these lines will either be R followed by a single space and then an integer which is a row number,
or C followed by a single space and then an integer which is a column number.
Rows are numbered top down from 1 to M. Columns are numbered left to right from 1 to N.

<Output Specification>
Output one non-negative integer which is equal to the number of cells that are gold in the pattern determined by the artist's choices.
 */

private val inputInt: (String, IntRange) -> Int = { value, range ->
    val result = value.toIntOrNull() ?: throw IllegalArgumentException("Invalid value ${value}")
    if (result !in range) throw IllegalArgumentException("out of range: ${range}")
    result
}

fun ccc21s2() {
    val input = System.`in`.bufferedReader()

    val M = input.readLine().let { inputInt(it, 1..5_000_000) }
    val N = input.readLine().let { inputInt(it, 1..5_000_000) }
    val K = input.readLine().let { inputInt(it, 1..1_000_000) }

    var canvas = mutableListOf<MutableList<String>>()

    for (m in 0..<M) {
        canvas.add(mutableListOf<String>())
        for (n in 0..<N) {
            canvas[m].add("B")
        }
    }


    var i = 0
    while (i < K) {
        val split = input.readLine().split(' ')

        if (split.size != 2) throw IllegalArgumentException("Invalid split size: ${split.size}")

        if (split[0] != "R" && split[0] != "C") throw IllegalArgumentException("Invalid split[0]: ${split[0]}")

//        유효성 검사 (행열 초과하지 않는 지 체크)
        val rowOrColumnIndex = when (split[0]) {
            "R" -> inputInt(split[1], 1..M) - 1
            "C" -> inputInt(split[1], 1..N) - 1
            else -> throw IllegalArgumentException("partition fullfilled")
        }


//        요구사항 - 행 혹은 열을 반전 (black->gold,ㄷ gold -> black)
        when (split[0]) {
            "R" -> {
                for (n in 0..<N) {
                    if (canvas[rowOrColumnIndex][n] == "B") canvas[rowOrColumnIndex][n] = "G"
                    else canvas[rowOrColumnIndex][n] = "B"
                }
            }

            "C" -> {
                for (m in 0..<M) {
                    if (canvas[m][rowOrColumnIndex] == "B") canvas[m][rowOrColumnIndex] = "G"
                    else canvas[m][rowOrColumnIndex] = "B"
                }
            }
        }


        i++
    }

    var count = 0
    for (i in 0..<M) {
        for (j in 0..<N) {
            if (canvas[i][j] == "G") count++
        }
    }

    println(count)
}

// TLE에 대한 ai 해결법
//fun ccc21s2Optimized() {
//    val input = System.`in`.bufferedReader()
//
//    val M = input.readLine().toInt()
//    val N = input.readLine().toInt()
//    val K = input.readLine().toInt()
//
//    // 각 행과 열이 뒤집힌 횟수를 카운트
//    val rowFlips = IntArray(M) { 0 }
//    val colFlips = IntArray(N) { 0 }
//
//    repeat(K) {
//        val split = input.readLine().split(' ')
//        val index = split[1].toInt() - 1  // 0-based 인덱스로 변환
//
//        when (split[0]) {
//            "R" -> rowFlips[index]++
//            "C" -> colFlips[index]++
//        }
//    }
//
//    var goldCount = 0
//
//    // 각 셀의 최종 상태 계산
//    for (r in 0..<M) {
//        for (c in 0..<N) {
//            // 총 뒤집힌 횟수 = 해당 행 뒤집힌 횟수 + 해당 열 뒤집힌 횟수
//            val totalFlips = rowFlips[r] + colFlips[c]
//
//            // 홀수 번 뒤집히면 Gold (원래 Black에서 변경됨)
//            if (totalFlips % 2 == 1) {
//                goldCount++
//            }
//        }
//    }
//
//    println(goldCount)
//}