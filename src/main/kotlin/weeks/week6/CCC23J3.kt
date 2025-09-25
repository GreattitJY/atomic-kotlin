package weeks.week6

/*
You are trying to schedule a special event on one of five possible days.

Your job is to determine on which day you should schedule the event, so that the largest number of interested people are able to attend.

<Input Specification>
The first line of input will contain a positive integer N, representing the number of people interested in attending your event.
The next N lines will each contain one person's availability using one character for each of Day 1, Day 2, Day 3, Day 4, and Day 5 (in that order).
The character Y means the person is able to attend and a period (.) means the person is not able to attend.

<Output Specification>
The output will consist of one line listing the day number(s) on which the largest number of interested people are able to attend.

If there is more than one day on which the largest number of people are able to attend,
output all of these day numbers in increasing order and separated by commas (without spaces).

 */
fun ccc23j3() {
    val input = System.`in`.bufferedReader()

    val N = input.readLine().toIntOrNull() ?: throw IllegalArgumentException("invalid int N")

    var attendDays = mutableListOf<Int>()

    for (i in 0..<5) {
        attendDays.add(0)
    }

    var i = 0
    while (i < N) {
        val schedule = input.readLine().let {
            if (it.length != 5) throw IllegalArgumentException("invalid length: ${it.length}")
            if (it.any { char -> char !in "Y." }) throw IllegalArgumentException("invalid char: $it")
            it
        }

        for (day in schedule.indices) {
            if (schedule[day] == 'Y') attendDays[day] = attendDays[day] + 1
        }

        i++
    }

    var result = ""
    var isNotFirst = false
    for (day in attendDays.indices) {
        if (attendDays[day] == attendDays.max()) {
            if (isNotFirst) result += ","
            isNotFirst = true
            result += (day + 1).toString()
        }
    }

    println(result)
}