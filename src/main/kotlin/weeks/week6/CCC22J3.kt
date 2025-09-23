package weeks.week6

/*
The CCC harp is a stringed instrument with strings labelled A, B, …, T. Like other instruments, it can be out of tune.

A musically inclined computer science student has written a clever computer program to help tune the harp.
The program analyzes the sounds produced by the harp and provides instructions to fix each string that is out of tune.
Each instruction includes a group of strings, whether they should be tightened or loosened, and by how many turns.

Unfortunately, the output of the program is not very user friendly.
It outputs all the tuning instructions on a single line.
For example, the single line AFB+8HC-4 actually contains two tuning instructions: AFB+8 and HC-4.
The first instruction indicates that harp strings A, F, and B should be tightened 8 turns,
and the second instruction indicates that harp strings H and C should be loosened 4 turns.

Your job is to take a single line of tuning instructions and make them easier to read.

<Input Specification>
There will be one line of input which is a sequence of tuning instructions.
Each tuning instruction will be a sequence of uppercase letters, followed by a plus sign (+) or minus sign (-), followed by a positive integer.
There will be at least one instruction and at least one letter per instruction. Also, each uppercase letter will appear at most once.

<Output Specification>
There will be one line of output for each tuning instruction.
Each line of output will consist of three parts,
each separated by a single space: the uppercase letters referring to the strings,
tighten if the instruction contained a plus sign or loosen if the instruction contained a minus sign, and the number of turns.

 */

private val validString: (Char) -> Char = { value ->
    if (value !in 'A'..'T' && value != '+' && value != '-' && value !in '0'..'9') throw IllegalArgumentException("Invalid value: $value")
    value
}

fun ccc22j3() {
    val input = System.`in`.bufferedReader()

    val instructions = input.readLine()

//    입력 유효성 검사 - 알파벳 + 부호 + 숫자
    var i = 0;
    var isSign = false
    while (i < instructions.length) {
        val char = instructions[i].let { validString(it) }

        when (char) {
            in 'A'..'T' -> {
                if (isSign) throw IllegalArgumentException("부호 다음에는 숫자가 나와야 합니다.")
            }

            in "+-" -> {
                if (isSign) throw IllegalArgumentException("부호는 연속으로 나올 수 없습니다.")
                isSign = true
            }

            in '0'..'9' -> isSign = false

        }
        i++
    }
    if (isSign) throw IllegalArgumentException("부호 다음에는 숫자가 나와야 합니다.")

//    튜닝 요구사항 - 문자열 변환
    var result = arrayListOf<String>()
    var tuning = ""
    var isNewTuning = false
    for (char in instructions) {
        when (char) {
            in 'A'..'T' -> {
                if (isNewTuning) {
                    result.add(tuning)
                    tuning = ""
                }
                tuning += char
                isNewTuning = false
            }

            in "+-" -> {
                isNewTuning = true
                tuning += """ ${if (char == '+') "tighten" else "loosen"} """
            }

            else -> tuning += char
        }
    }

//    마지막 튜닝 추가
    result.add(tuning)

    for (r in result) println(r)

}