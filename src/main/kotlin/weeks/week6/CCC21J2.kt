package weeks.week6

import weeks.week3.inputInt

/*
A charity is having a silent auction where people place bids on a prize without knowing anyone else's bid.
Each bid includes a person's name and the amount of their bid. After the silent auction is over, the winner is the person who has placed the highest bid.
If there is a tie, the person whose bid was placed first wins. Your job is to determine the winner of the silent auction.

<Input Specification>
The first line of input contains a positive integer N, where 1..100, representing the number of bids collected at the silent auction.
Each of the next N pairs of lines contains a person's name on one line, and the amount of their bid, in dollars, on the next line.
Each bid is a positive integer less than 2000. The order of the input is the order in which bids were placed.

<Output Specification>
Output the name of the person who has won the silent auction.

 */

private val inputInt: (String, IntRange) -> Int = { value, range ->
    val result = value.toIntOrNull() ?: throw IllegalArgumentException("Invalid value ${value}")
    if (result !in range) throw IllegalArgumentException("out of range: ${range}")
    result
}

fun ccc21j2() {
    val input = System.`in`.bufferedReader()

    val N = input.readLine().let { inputInt(it, 1..100) }

    var result = ""
    var currentName = ""
    var bidsMoney = Int.MIN_VALUE
    var i = 0
    while (i < N * 2) {
//        order 0:name, 1: dollor
        val order = i % 2
        val bids = input.readLine()

        when (order) {
            0 -> {
                if (bids.isNullOrBlank()) throw IllegalArgumentException("Invalid name: ${bids}")
                currentName = bids
            }

            1 -> {
                val dollor = bids.let { inputInt(it, 1..2000) }
                if (dollor > bidsMoney) {
                    bidsMoney = dollor
                    result = currentName
                }
            }
        }
        i++
    }

    println(result)
}