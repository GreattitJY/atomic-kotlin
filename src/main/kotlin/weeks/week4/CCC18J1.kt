package weeks.week4

/*
Here at the Concerned Citizens of Commerce (CCC),
we have noted that telemarketers like to use seven-digit phone numbers where the last four digits have three properties.
Looking just at the last four digits, these properties are:

- the first of these four digits is an 8 or 9
- the last digit is an 8 or 9
- the second and third digits are the same.

For example, if the last four digits of the telephone number are 8229, 8338, or 9008, these are telemarketer numbers.

Write a program to decide if a telephone number is a telemarketer number or not, based on the last four digits.
If the number is not a telemarketer number, we should answer the phone, and otherwise, we should ignore it.

<Input Specification>
The input will be 4 lines where each line contains exactly one digit in the range from 0 to 9

<Output Specification>
Output either "ignore" if the number matches the pattern for a telemarketer number; otherwise, output "answer".

 */

private fun inputDigitString(v: String, range: IntRange): String {
    if (v.length != 1 && v !in "0123456789") throw IllegalArgumentException("invalid char: $v")
    return v
}


fun ccc18j1() {
    val input = System.`in`.bufferedReader()

    val n1 = input.readLine().let { inputDigitString(it, 0..9) }
    val n2 = input.readLine().let { inputDigitString(it, 0..9) }
    val n3 = input.readLine().let { inputDigitString(it, 0..9) }
    val n4 = input.readLine().let { inputDigitString(it, 0..9) }

    println(if (n1 in "89" && n4 in "89" && n2 == n3) "ignore" else "answer")
}