package weeks.week2

fun ccc08j2() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()
    var playlist = mutableListOf<Char>('A', 'B', 'C', 'D', 'E')

    while (true) {
        val b = input.readLine().toInt()
        val n = input.readLine().toInt()

        if (b == 4 && n == 1) break

        for (i in 1..n) {
            playlist = button(playlist, b)
        }

    }

    output.write("${playlist.joinToString(" ")}\n")
    output.flush()
}

fun button(playlist: List<Char>, type: Int): MutableList<Char> {
    val newList = (playlist + playlist).toMutableList()

    if (type == 1) {
        return newList.slice(1..5).toMutableList()

    } else if (type == 2) {
        return newList.slice(4..8).toMutableList()

    } else if (type == 3) {
        val tmp = newList[0]
        newList[0] = newList[1]
        newList[1] = tmp
        return newList.slice(0..4).toMutableList()
    } else {
        return playlist.toMutableList()
    }
}
