package weeks.week3

fun ccc18s1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    var N = input.readLine().toIntOrNull() ?: throw Throwable("invalid N")
    if (N !in 3..100) throw Throwable("out of range 3..100 N: $N")

    val vList = mutableListOf<Int>()
    while (N > 0) {
        val v = input.readLine().toIntOrNull() ?: throw Throwable("invalid v")
        if (v !in -1_000_000_000..1_000_000_000) throw Throwable("out of range -1_000_000_000..1_000_000_000 v: $v")
        vList.add(v)
        N--
    }

    vList.sort()
    val distList = mutableListOf<Double>()
    for (i in 0..<vList.size - 1) {
        val A = vList[i]
        val B = vList[i + 1]
        val dist = (B - A) / 2.0
        distList.add(dist)
    }

    var minSize = Double.MAX_VALUE
    for (i in 0..<distList.size - 1) {
        val units = distList[i] + distList[i + 1]
        minSize = Math.min(units, minSize)
    }

    val result = String.format("%.1f", minSize)
    output.write(result)
    output.flush()
}