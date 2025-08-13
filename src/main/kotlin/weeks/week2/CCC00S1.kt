package weeks.week2

fun ccc00s1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    var totalQuarters = input.readLine().toInt()
    val machines = mutableMapOf<Int, Int>()
    var count = 0
    var canPlay = true

    for (i in 0..2) {
        val times = input.readLine().toInt()
        machines[i] = times
    }

    while (totalQuarters > 0 && canPlay) {
        for (i in 0..2) {
            if (totalQuarters < 1) {
                canPlay = false
                break;
            }

            machines[i] = machines[i]!! + 1
            totalQuarters -= 1
            count++

            val pay = machinePays(i, machines[i]!!)
            totalQuarters += pay
        }
    }

    output.write("Martha plays $count times before going broke.")
    output.flush()
}

fun machinePays(type: Int, playCount: Int): Int {
    if (type == 0 && playCount % 35 == 0) {
        return 30
    } else if (type == 1 && playCount % 100 == 0) {
        return 60
    } else if (type == 2 && playCount % 10 == 0) {
        return 9
    } else {
        return 0
    }
}