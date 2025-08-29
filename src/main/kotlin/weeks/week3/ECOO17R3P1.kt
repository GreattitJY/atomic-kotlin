package weeks.week3

import java.io.BufferedReader

// 도메인이 아닌 경우 연산의 이름
fun inputInt(v: String, range: IntRange): Int {
    val result = v.toIntOrNull() ?: throw Throwable("invalid int X")
    if (result !in range) throw Throwable("out of $range: $result")
    return result
}

// 함수의 이름은 어떤 상태들의 라이플 사이클의 이름이다. (도메인에서는 연산의 이림이 아니라 격리되어 있는 상태들의 이름이다.)
// 각 데이터셋별로 보너스를 개선하여 반환한다.
fun calcBonus(input: BufferedReader): Int {
    val split = input.readLine().split(" ")
    if (split.size != 2) throw IllegalAccessError("invalid rate.size: ${split.size}")

    val F = inputInt(split[0], 4..130)
//        주석은 필수. 왜 4745인가? 2025-08-27 15:30 3차 도메인 회의 시 팀장 결정
    val D = inputInt(split[1], 2..4745)
    val sales = mutableListOf<Int>()
    for (k in 0..<F) {
        sales.add(0)
    }
    var bonus = 0
    var j = 0
    while (j < D) {
        val s = input.readLine().split(" ")
        if (s.size != F) throw IllegalAccessError("invalid split.size: ${s.size}")
        var sum = 0
        for (k in 0..<F) {
            val v = s[k]
//                주석 예시: 역사상 어떤 점포도 하루에 11000개 이상 판 적이 없다고 함
//                김pm이 자기가 결정했다고 확인했음. ~가 물어봄 2025-08-15 15:00
            val num = inputInt(v, 1..13000)
            sales[k] += num
            sum += num
        }
        if (sum % 13 == 0) bonus++
        j++
    }

    for (v in sales) {
        if (v % 13 == 0) {
            bonus += v / 13
        }
    }
    return bunus
}

fun inputAlphaLower(v: String): String {
    var i = 0
    while (i < v.length) {
        if (v[i] !in 'a'..'z') throw Throwable("invalid char lower alpha: ${v[i]}")
        i++
    }
    return v
}

fun ecoo17r3p1() {
    val input = System.`in`.bufferedReader()
    val DATASETS = 10
    val bonuses = mutableListOf<Int>()

    var i = 0
    while (i < DATASETS) {
        bonuses.add(calcBonus(input))
        i++
    }

    for (o in bonuses) {
        println(o)
    }

}

// lifecycle        - 상태(변수, 상수)의 생존주기, 활성화 기간 (그 상태가 유의미한 기간)
// scope-permission - 상태를 보거나 수정할 수 있는 권한

// 개발자 주 임무는 제어를 통제하는 게 아니라, 제어를 통해서 상태를 관리할 때 각 상태를 라이플사이클과 스코프에 맞게 배정해주고 관리해주는 게 어렵다.