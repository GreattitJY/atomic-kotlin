package weeks.week6

/*
Professor Santos has decided to hide a secret formula for a new type of biofuel.
She has, however, left a sequence of coded instructions for her assistant.

Each instruction is a sequence of five digits which represents a direction to turn and the number of steps to take.

The first two digits represent the direction to turn:

If their sum is odd, then the direction to turn is left.
If their sum is even and not zero, then the direction to turn is right.
If their sum is zero, then the direction to turn is the same as the previous instruction.
The remaining three digits represent the number of steps to take which will always be at least
.

Your job is to decode the instructions so the assistant can use them to find the secret formula.

<Input Specification>
There will be at least two lines of input. Each line except the last line will contain exactly five digits representing an instruction.
The first line will not begin with 00. The last line will contain 99999 and no other line will contain 99999.

<Output Specification>
There must be one line of output for each line of input except the last line of input. These output lines correspond to the input lines (in order).
Each output line gives the decoding of the corresponding instruction: either right or left, followed by a single space, followed by the number of steps to be taken in that direction.


 */

// 5자리 숫자 형식의 문자열인지 확인
private val validInput: (String, Int) -> String = { value, length ->
    if (value.length != length) throw IllegalArgumentException("Invalid length ${value.length}")
    if (value.any { it !in '0'..'9' }) throw IllegalArgumentException("Invalid value: $value")
    value
}

fun ccc21j3() {
    val input = System.`in`.bufferedReader()

    var isFirst = true
    var direction = ""
    while (true) {
        val digits = input.readLine().let { validInput(it, 5) }

        if (digits == "99999") break

        if (isFirst && digits.startsWith("00")) throw IllegalArgumentException("첫번째 라인은 00으로 시작할 수 없습니다.")
        isFirst = false

        if (digits[2].digitToInt() == 0) throw IllegalArgumentException("마지막 세자리 숫자는 최소 100입니다.")

        (digits[0].digitToInt() + digits[1].digitToInt()).let {
            when {
                it == 0 -> null
                it % 2 == 0 -> direction = "right"
                else -> direction = "left"
            }
        }

        println("$direction ${digits[2]}${digits[3]}${digits[4]}")
    }
}