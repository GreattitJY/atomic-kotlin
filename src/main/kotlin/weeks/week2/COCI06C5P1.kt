package weeks.week2

fun coci06c5p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val n = input.readLine()
//   도메인에는 1부터 시작인지 0부터인지 나와있지 않다면, 주석에 써놓든 기획자에게 가야한다.
    if (n.length !in 1..50) throw Throwable("out of range 1..50 n.length: ${n.length}")
    var i = 0
    while (i < n.length) {
        if (n[i] !in "ABC") throw Throwable("invalid char n[$i]: ${n[i]}")
        i++
    }

    var pos0 = 1
    var pos1 = 0
    var pos2 = 0

    for (c in n) {
        when (c) {
            A -> {
                val tmp = pos0
                pos0 = pos1
                pos1 = tmp
            }

            B -> {
                val tmp = pos1
                pos1 = pos2
                pos2 = tmp
            }

            C -> {
                val tmp = pos0
                pos0 = pos2
                pos2 = tmp
            }
        }
    }

    val result = when {
        pos0 == 1 -> "1"
        pos1 == 1 -> "2"
        pos2 == 1 -> "3"
        else -> throw Throwable("fulfill partion")
    }
    
    output.write("$result")
    output.flush()
}