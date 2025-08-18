package weeks.week2

fun ccc00s1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    var quarter = input.readLine().toIntOrNull() ?: throw Throwable("invalid int quarter")
    if (quarter !in 1..1000) throw Throwable("out of range 1..1000 quarter: $quarter")

    val turn1 = 35
    val turn2 = 100
    val turn3 = 10
    val prize1 = 30
    val prize2 = 60
    val prize3 = 9

    var played1 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int played1")
    played1 %= turn1
    var played2 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int played2")
    played2 %= turn2
    var played3 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int played3")

    var turn = 0
    var count = 0
    while (quarter > 0) {
        quarter--
        count++
        when (turn) {
            0 -> played1++
            1 -> played2++
            2 -> played3++
        }
        turn = (turn + 1) % 3

        if (played1 == turn1) {
            played1 = 0
            quarter += prize1
        }
        if (played2 == turn2) {
            played2 = 0
            quarter += prize2
        }
        if (played3 == turn3) {
            played3 = 0
            quarter += prize3
        }
    }

    output.write("Martha plays $count times before going broke.")
    output.flush()
}

