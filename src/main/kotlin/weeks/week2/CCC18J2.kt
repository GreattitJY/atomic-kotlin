package weeks.week2

fun ccc18j2() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val n = input.readLine().toIntOrNull() ?: throw Throwable("invalid int")
    if (n !in 1..100) throw Throwable("out of range 1..100 n: $n")

    val yesterday = input.readLine()
    if (yesterday.length != n) throw Throwable("invalid yesterday length: ${yesterday.length}")

    var i = 0
    while (i < n) {
        if (yesterday[i] !in "C.") throw Throwable("invalid char yesterday[$i]: ${yesterday[i]}")
        i++
    }

    val today = input.readLine()
    if (today.length != n) throw Throwable("invalid today length: ${today.length}")

    i = 0
    while (i < n) {
        if (today[i] !in "C.") throw Throwable("invalid char today[$i]: ${today[i]}")
        i++
    }

    var count = 0
    for (i in 0..<n) {
        if (yesterday[i] == 'C' && today[i] == 'C') count++
    }

    output.write("$count")
    output.flush()
}