package weeks.week2

fun ccc18j2() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()
    val n = input.readLine().toInt()
    var spaces = ""
    var count = 0

    repeat(2) {
        spaces += input.readLine()
    }

    for (i in 0 until n) {
        if (spaces[i] == 'C' && spaces[i] == spaces[i + n]) {
            count++;
        }
    }

    output.write("$count")
    output.flush()
}