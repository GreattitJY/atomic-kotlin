package weeks.week2

fun coci16c1p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val X = input.readLine().toIntOrNull() ?: throw Throwable("invalid int X")
    if (X !in 1..100) throw Throwable("out of range 1..100 X: $X")

    val N = input.readLine().toIntOrNull() ?: throw Throwable("invalid int N")
    if (N !in 1..100) throw Throwable("out of range 1..100 N: $N")

    var availabeldData = X
    var i = 1
    while (i in 1..N) {
        val p = input.readLine().toIntOrNull() ?: throw Throwable("invalid int p")
        if (p !in 0..10000) throw Throwable("out of range 0..10000 p: ${p}")
        availabeldData -= p
        if (availabeldData < 0) throw Throwable("availableData < 0")
        availabeldData += X
        i++
    }

    output.write("$availabeldData")
    output.flush()
}