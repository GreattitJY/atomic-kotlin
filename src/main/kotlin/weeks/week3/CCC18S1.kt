package weeks.week3

fun ccc18s1() {
    val input = System.`in`.bufferedReader()

    val N = input.readLine().toIntOrNull() ?: throw Throwable("invalid int N")
    if (N !in 3..100) throw Throwable("out of range 3..100 B: N: $N")
    val list = mutableListOf<Int>()
    var i = 0
    while (i < N) {
        val V = input.readLine().toIntOrNull() ?: throw Throwable("invalid int V")
        if (V !in -1_000_000_000..1_000_000_000) throw Throwable("out of range -1_m..1m V: $V")
        list.add(V)
        i++
    }
    list.sort()

    val size = mutableListOf<Double>()
    for (i in 1..<list.lastIndex) {
        size.add(abs(list[i + 1] - list[i - 1]).toDouble() / 2.0)
    }
    size.sort()

    println("$.1f".format(size[0]))
    output.flush()
}