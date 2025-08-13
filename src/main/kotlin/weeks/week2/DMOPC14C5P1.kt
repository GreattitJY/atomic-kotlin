package weeks.week2

import kotlin.math.PI

fun dmopc14c5p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()
    val r = input.readLine().toDouble()
    val h = input.readLine().toDouble()

    val volume = PI * r * r * h / 3

    output.write("$volume")
    output.flush()
}