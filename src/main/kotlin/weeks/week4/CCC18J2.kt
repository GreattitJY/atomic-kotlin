package weeks.week4
/*
You supervise a small parking lot which has N parking spaces.

Yesterday, you recorded which parking spaces were occupied by cars and which were empty.

Today, you recorded the same information.

How many of the parking spaces were occupied both yesterday and today?

<Input Specification>

The first line of input contains the integer N(1..100).

The second and third lines of input contain N characters each.

The second line of input records the information about yesterday's parking spaces,
and the third line of input records the information about today's parking spaces.

Each of these 2N characters will either be C to indicate an occupied space or
. to indicate it was an empty parking space.

<Output Specification>
Output the number of parking spaces which were occupied yesterday and today.
 */

private fun inputInt(v: String, range: IntRange): Int {
    val result = v.toIntOrNull() ?: throw IllegalArgumentException("invalid int X")
    if (result !in range) throw IllegalArgumentException("out of $range: $result")
    return result
}

// 입력받은 문자열의 길이가 유효한지 파악하는 함수
private fun inputLength(v: String, length: Int): String {
    if (v.length != length) throw IllegalArgumentException()
    return v
}

fun ccc18j2() {
    val input = System.`in`.bufferedReader()

    val N = input.readLine().let { inputInt(it, 1..100) }

    val yesterday = input.readLine().let { inputLength(it, N) }

    var i = 0;
    while (i < yesterday.lastIndex) {
//        메모리에 저장할 게 아니라면 바로 사용 (val parkingSpace = yesterday[i])와 같이 할 이유가 없음
        if (yesterday[i] !in "C.") throw IllegalArgumentException("invalid char yesterday[$i]: ${yesterday[i]}")
        i++
    }

    val today = input.readLine().let { inputLength(it, N) }

    i = 0
    while (i < today.lastIndex) {
        if (today[i] !in "C.") throw IllegalArgumentException("invalid char today[$i]: ${today[i]}")
        i++
    }

    var count = 0;
    for (i in 0..<N) {
        if (yesterday[i] == 'C' && today[i] == 'C') count++
    }

    println(count)
}