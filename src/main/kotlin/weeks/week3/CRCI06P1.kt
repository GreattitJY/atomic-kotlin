package weeks.week3

fun crci06p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val BARD = 1

    val N = input.readLine().toIntOrNull() ?: throw Throwable("invalid N")
    if (N < 2 || N > 100) throw Throwable("out of range 2..100 N: $N")
    val E = input.readLine().toIntOrNull() ?: throw Throwable("invalid E")
    if (E < 1 || E > 50) throw Throwable("out of range 1..50 E: $E")

//    유효성 검사 -
    var e = 1
    while (e in e..E) {
        val K = input.readLine()
        if (K.isNullOrBlank()) throw Throwable("isNullOrBlank K")

        val vList = K.split(" ")
        if (vList.size > N) throw Throwable("out of range size <= N: ${vList.size} <= $N")

        var vIndex = 0
        while (vIndex in vIndex..<vList.size) {
            val v = vList[vIndex]

            if (vIndex == 0 && (v < 2 || v > N)) throw Throwable("out of range first v: $v")
            if (v != BARD && (v < 2 || v > N)) throw Throwable("out of range rest v(not bard): $v")


            vIndex++

        }
        e++
    }



    output.write("crci06p1")
    output.flush()
}