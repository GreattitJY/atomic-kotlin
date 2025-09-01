package weeks.week3

import java.util.*
import kotlin.math.abs

fun ecoo17r1p1() {
    val input = System.`in`.bufferedReader()
    val TRIPS = 10
    val e = 2.220446049250313e-15
    val prices = listOf(12, 10, 7, 5)

    val output = mutableListOf<Boolean>()
    var i = 0
    while (i < TRIPS) {
        val cost = input.readLine().toIntOrNull() ?: throw IllegalArgumentException("invalid int coast")
        if (cost !in 50..50000) throw IllegalStateException("out of range 50..50000 cost: $cost")

        val split = input.readLine().split(" ")
        if (split.size != 4) throw IllegalAccessError("invalid rate.size: ${split.size}")
        val rate = mutableListOf<Double>()
        var j = 0
        while (j < split.size) {
            val r = split[j].toDoubleOrNull() ?: throw IllegalMonitorStateException("invalid double split: ${split[j]}")
            if (r !in 0.0..1.0) throw Throwable("out of range 0.1..<1.0 rate: $r")
            rate.add(r)
            j++
        }

        if (abs(rate.sum() - 1.0) > e) throw IllformedLocaleException(
            "sum of rate is not 1.0, rate: ${
                rate.joinToString(
                    ","
                )
            }}"
        )
        val N = input.readLine().toIntOrNull() ?: throw Exception("invalid N")
        if (N !in 4..2000) throw Error("out of range 4..2000: $N")
        val student = mutableListOf<Int>()
        for (k in rate) {
            student.add((k * N).toInt())
        }
        val delta = N - student.sum()
        if (delta > 0) student[student.indexOf(student.max())] += delta
        var sum = 0
        for (l in 0..student.lastIndex) {
            sum += student[l] * prices[l]
        }
        output.add(sum < cost * 2)
        i++
    }

    for (o in output) {
        println(if (o) "YES" else "NO")
    }
}