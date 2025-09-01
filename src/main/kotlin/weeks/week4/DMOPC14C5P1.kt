package weeks.week4

private fun inputInt(v: String, range: IntRange): Int {
    val result = v.toIntOrNull() ?: throw Throwable("invalid int")
    if (result !in range) throw Throwable("out of $range: $result")
    return result
}

fun dmopc14c5p1() {
    val input = System.`in`.bufferedReader()

    val r = input.readLine().let { inputInt(it, 1..100) }
    val h = input.readLine().let { inputInt(it, 1..100) }

    val core = Math.PI * r * r * h / 3

    println(core)
}

