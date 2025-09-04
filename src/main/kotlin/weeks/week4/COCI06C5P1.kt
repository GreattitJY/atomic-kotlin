package weeks.week4

/*
Jealous of Mirko's position as head of the village,
Borko stormed into his tent and tried to demonstrate Mirko's incompetence for leadership with a trick.

Borko puts three opaque cups onto the table next to each other (opening facing down) and
a small ball under the leftmost cup. He then swaps two cups in one of three possible ways a number of times.
Mirko has to tell which cup the ball ends up under.

Wise Mirko grins with his arms crossed while Borko struggles to move the cups faster and faster.
What Borko does not know is that programmers in the back are recording all his moves and
will use a simple program to determine where the ball is.

<Input Specification>

The first and only line contains a string of at most 50 characters, Borko's moves.
Each of the characters is A, B or C.

<Output Specification>

Output the index of the cup under which the ball is:
 if it is under the left cup,
 if it is under the middle cup or
 if it is under the right cup.

*/
fun coci06c5p1() {
    val input = System.`in`.bufferedReader()

    val n = input.readLine().let {
        if (it.length !in 1..50) throw IllegalArgumentException("invalid length 1..50: ${it.length}")
        else it
    }

    var i = 0
    while (i < n.length) {
        if (n[i] !in "ABC") throw IllegalStateException("invalid char: ${n[i]}")
        i++
    }

    var pos0 = 1
    var pos1 = 0
    var pos2 = 0

    for (c in n) {
        when (c) {
            'A' -> {
                val tmp = pos0
                pos0 = pos1
                pos1 = tmp
            }

            'B' -> {
                val tmp = pos1
                pos1 = pos2
                pos2 = tmp
            }

            'C' -> {
                val tmp = pos0
                pos0 = pos2
                pos2 = tmp
            }
        }
    }

//    결과에 대입하는 when은 else가 반드시 필요하다.
    val result = when {
        pos0 == 1 -> '1'
        pos1 == 1 -> '2'
        pos2 == 1 -> '3'
        else -> throw Throwable("fulfill partion")
    }

    println(result)
}