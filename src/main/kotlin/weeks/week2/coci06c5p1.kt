package weeks.week2

fun coci06c5p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    var moves = input.readLine()
    var cups = mutableListOf<Boolean>(true, false, false)

    for (move in moves) {
        changeBall(move, cups)
    }

    val result = cups.indexOf(true) + 1

    output.write("$result")
    output.flush()
}

fun changeBall(type: Char, cups: MutableList<Boolean>) {
    if (type == 'A') {
        val tmp = cups[0]
        cups[0] = cups[1]
        cups[1] = tmp
    } else if (type == 'B') {
        val tmp = cups[1]
        cups[1] = cups[2]
        cups[2] = tmp
    } else {
        val tmp = cups[0]
        cups[0] = cups[2]
        cups[2] = tmp
    }
}