package weeks.week5

/*
In ancient Europe, people believed that their luck was dependent on a number.
By summing up the digits of their birthday, they got a sum.
By repeatedly adding the digits of the sum until a single digit number remains.
This resultant number was called the "single digit representation".
And the digit reflected their luck in their whole life.

In this question, a birthday will be given by a non-negative integer x (<=10_000 digits).
Your program has to compute the single digit representation of the given number. Example:

1 -> 1
10 -> 1 + 0 = 1
19 -> 1 + 9 = 10 -> 1 + 0 = 1
999 -> 9 + 9 + 9 = 27 -> 9

<Input Specification>
The first input is an integer specifying the number of test cases.
Then each input number appears on a line by itself.

<Output Specification>
For each test case, output the single digit representation of it.
 */

/**
 * 입력받은 문자열의 유효성 검사
 * 1. Int인지 확인한다.
 * 2. 자릿수가 10_000 범위 내인지 확인한다.
 */
fun validString(value: String, maxDigit: Int): String {
    if (value.isNullOrBlank()) throw IllegalArgumentException("value is null or blank")
    if (!value.all { it.isDigit() }) throw IllegalArgumentException("invalid char - must be int: $value")
    if (value.length > maxDigit) throw IllegalArgumentException("out of legth maxDigit: ${maxDigit}")
    return value
}

fun ccchk08j2() {
    val input = System.`in`.bufferedReader()

    val n = input.readLine().let { it.toIntOrNull() ?: throw IllegalArgumentException("invalid n: $it") }
    val result = mutableListOf<String>()

    var i = 0;
    while (i < n) {
        var x = input.readLine().let { validString(it, 10_000) }

        while (x.length > 1) {
//            nextX는 각 자릿수의 합을 저장한다. (한 자릿수가 아닐 수 있음)
            var nextX = 0
            for (c in x) {
                nextX += c.digitToInt()
            }
            x = nextX.toString()
        }
        result.add(x)
        i++
    }

    for (r in result) {
        println(r)
    }
}