package weeks.week5

/*
Mahima has been experimenting with a new style of art.
She stands in front of a canvas and, using her brush, flicks drops of paint onto the canvas.
When she thinks she has created a masterpiece, she uses her 3D printer to print a frame to surround the canvas.

Your job is to help Mahima by determining the coordinates of the smallest possible rectangular frame such that
each drop of paint lies inside the frame. Points on the frame are not considered inside the frame.

<Input Specification>
The first line of input contains the number of drops of paint, N, where 2 <= N <= 100 and is an integer.
Each of the next N lines contain exactly two positive integers X and Y separated by one comma (no spaces).
Each of these pairs of integers represent the coordinates of a drop of paint on the canvas.
Assume that X <= 100 and Y <= 100, and that there will be at least two distinct points.
The coordinates (0, 0) represent the bottom-left corner of the canvas.

For 12 of the available marks, X and Y will both be two-digit integers.

<Output Specification>
Output two lines. Each line must contain exactly two non-negative integers separated by a single comma (no spaces).
The first line represents the coordinates of the bottom-left corner of the rectangular frame.
The second line represents the coordinates of the top-right corner of the rectangular frame.
*/

private val inputRange: (String, IntRange) -> Int = { value, range ->
    val result = value.toIntOrNull() ?: throw IllegalArgumentException("invalid value: ${value}")
    if (result !in range) throw IllegalArgumentException("out of range: ${range}")
    result
}

fun ccc20j3() {
    val input = System.`in`.bufferedReader()

    val N = input.readLine().let { inputRange(it, 2..100) }

    var minX = Int.MAX_VALUE
    var maxX = Int.MIN_VALUE
    var minY = Int.MAX_VALUE
    var maxY = Int.MIN_VALUE

    var i = 0
    while (i < N) {
        val split = input.readLine().split(',')

        if (split.size != 2) throw IllegalArgumentException("invalid split size: ${split.size}")

        val x = split[0].let { inputRange(it, 0..100) }
        val y = split[1].let { inputRange(it, 0..100) }

//        마크 좌표들
        minX = minOf(minX, x)
        maxX = maxOf(maxX, x)
        minY = minOf(minY, y)
        maxY = maxOf(maxY, y)

        i++
    }

//    프레임 좌표는 마크보다 커야 한다.
    println("${maxOf(0, minX - 1)},${maxOf(0, minY - 1)}")
    println("${maxX + 1},${maxY + 1}")
}