package weeks.week3

fun ecoo17r1p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val TRIPS = 10
    val Y1 = 12
    val Y2 = 10
    val Y3 = 7
    val Y4 = 5

    var result = ""

    var i = 1
    while (i in 1..TRIPS) {
//        첫번째 입력: 비용 검증
        val cost = input.readLine().toIntOrNull() ?: throw Throwable("invalid cost")
        if (cost !in 50..50_000) throw Throwable("out of range 50..50_000 cost: $cost")

//        두번째 입력: 학생 비율 검증
        val yStrings = input.readLine()
        if (yStrings.isNullOrBlank()) throw Throwable("isNullOrBlank Text")
        val yList = yStrings.split(" ").map { it.toDoubleOrNull() ?: throw Throwable("invalid $it") }
        if (yList.size != 4) throw Throwable("invalid size yList: ${yList.size}")
        val e = Math.ulp(1.0)
        if (Math.abs(yList.sum() - 1.0) > e || yList.any { it < 0 || it > 1 })
            throw Throwable("yList values are out of range 0..1 and sum is not 1")
        val maxY = yList.max()
        if (yList.count { it == maxY } != 1)
            throw Throwable("There will always be exactly one group with the highest percentage of attendees.")

//        세번째 입력: 학생 수 검증
        val students = input.readLine().toIntOrNull() ?: throw Throwable("invalid students")
        if (students < 4 || students > 2000) throw Throwable("out of range 4..2000 students: $students")

//        학생 수 조정
        val maxYIndex = yList.indexOf(maxY)
        val addPeople = students - yList.sumOf { (it * students).toInt() }
        val yStudents = mutableListOf<Int>()
        for (i in yList.indices) {
            if (maxYIndex == i) {
                yStudents.add((yList[i] * students).toInt() + addPeople)
            } else {
                yStudents.add((yList[i] * students).toInt())
            }
        }

//       비용 계산
        var proceeds = 0
        for (i in yStudents.indices) {
            when (i) {
                0 -> proceeds += Y1 * yStudents[i]
                1 -> proceeds += Y2 * yStudents[i]
                2 -> proceeds += Y3 * yStudents[i]
                3 -> proceeds += Y4 * yStudents[i]
            }
        }

        result += if (cost > (proceeds / 2)) "YES\n" else "NO\n"
        i++
    }

    output.write(result)
    output.flush()
}