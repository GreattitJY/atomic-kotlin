package weeks.week2

fun ccc08j2() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    var p1 = "A"
    var p2 = "B"
    var p3 = "C"
    var p4 = "D"
    var p5 = "E"

    do {
        val button = input.readLine().toIntOrNull() ?: throw Throwable("invalid int button")
        if (button !in 1..4) throw Throwable("out of range 1..4 button: $button")

        val n = input.readLine().toIntOrNull() ?: throw Throwable("invalid int n")
        if (n !in 1..10) throw Throwable("out of range 1..10 n: $n")

        if (button == 4 && n != 1) throw Throwable("button 4 requires n to be 1, but was $n")

        for (i in 1..n) {
            when (button) {
                1 -> {
                    val tmp = p1
                    p1 = p2
                    p2 = p3
                    p3 = p4
                    p4 = p5
                    p5 = tmp
                }

                2 -> {
                    val tmp = p5
                    p5 = p4
                    p4 = p3
                    p3 = p2
                    p2 = p1
                    p1 = tmp
                }

                3 -> {
                    val tmp = p1
                    p1 = p2
                    p2 = tmp
                }
            }
        }
    } while (button != 4)

    output.write("$p1 $p2 $p3 $p4 $p5")
    output.flush()
}

