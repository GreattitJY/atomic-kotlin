package weeks.week2

fun dmopc14c5p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val n0 = input.readLine()
    val r = n0.toIntOrNull() ?: throw Throwable("invalid int n0: $n0")
    if (r !in 1..100) throw Throwable("out of range 0..100 r: $r")
    
    val n1 = input.readLine()
    val h = n1.toIntOrNull() ?: throw Throwable("invalid int n1: $n1")
    if (h !in 1..100) throw Throwable("out of range 0..100 h:$h")

    val core = Math.PI * r * r * h / 3

    output.write("$core")

    output.flush()
}