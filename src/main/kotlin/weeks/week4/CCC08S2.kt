package weeks.week4

import kotlin.math.sqrt

/*
The game "Pennies in the Ring" is often played by bored computer programmers who have gotten tired of playing solitaire.
The objective is to see how many pennies can be put into a circle. The circle is drawn on a grid,
with its center at the coordinate (0, 0)
A single penny is placed on every integer grid coordinate (e.g., (1,1), (1,2), etc.)
that lies within or on the circle. It's not a very exciting game, but it's very good for wasting time.
Your goal is to calculate how many pennies are needed for a circle with a given radius.

<Input>
The input is a sequence of positive integer values, one per line, where each integer is the radius of a circle.
You can assume the radius will be less than or equal to 25_000.
The last integer will be indicated by 0.
You may assume that the grid is large enough for two pennies to be on adjacent integer coordinates and not touch.

<Output>
You are to output, each on its own line, the number of pennies needed for each circle.
You do not need to output 0 for the last 0.
You may assume that the number of possible pennies is less than 2 billion
(which is only $20 million dollars: computer scientists have lots of money).
*/
fun ccc08s2() {
    val input = System.`in`.bufferedReader()

    val result = mutableListOf<Int>()
    while (true) {
        val radius =
            input.readLine().let { it.toIntOrNull() ?: throw IllegalArgumentException("invalid radius: ${it}") }

        if (radius < 0 || radius > 25000) throw IllegalArgumentException("out of range 0..25000 radius: $radius")
        if (radius == 0) break

        var count = 0

//        TLE 시간 초과
//        // 원점과 x,y축을 제외한 1사분면을 순회하면서 좌표를 찾은 뒤 4사분면의 대칭을 고려하여 4를 더해준다.
//        for (x in 1..radius) {
//            for (y in 1..radius) {
//                if ((x * x) + (y * y) <= (radius * radius)) {
//                    count += 4
//                }
//            }
//        }

        for (x in 1..radius) {
            val y = sqrt((radius * radius - x * x).toDouble()).toInt()
            count += 4 * y
        }

//        원점이 아닌 1사분면 x축(x,0)을 순회하면서 4사분면의 대칭을 고려하여 4를 더해준다.
        for (x in 1..radius) {
            count += 4
        }

//        원점 카운트
        count += 1
        result.add(count)
    }

    for (r in result) {
        println(r)
    }
}