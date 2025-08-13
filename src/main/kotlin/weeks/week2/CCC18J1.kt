package weeks.week2

fun ccc18j1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()
    val numbers = mutableListOf<Int>()


    for (i in 1..4) {
        numbers.add(input.readLine().toInt())
    }

    val result = if (isTelemarketer(numbers)) "ignore" else "answer"

    output.write("$result")
    output.flush()
}

fun isTelemarketer(numbers: List<Int>): Boolean {
    if (numbers[0] < 8 || numbers[3] < 8) {
        return false
    }

    if (numbers[1] != numbers[2]) {
        return false
    }
    return true
}