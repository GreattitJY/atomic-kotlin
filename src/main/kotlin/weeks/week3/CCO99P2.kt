package weeks.week3

fun cco99p2() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val n = input.readLine().toIntOrNull() ?: throw Throwable("invalid input n")
    var result = ""

    var i = 1;
    while (i in 1..n) {
        //        입력 검증
        val mkStrings = input.readLine()
        if (mkStrings.isNullOrBlank()) throw Throwable("isNullOrBlank mkStrings")
        val mkList = mkStrings.split(" ").map { it.toIntOrNull() ?: throw Throwable("invalid mkStrings: $mkStrings") }
        if (mkList.size != 2) throw Throwable("invalid size mkList: ${mkList.size}")
        val (m, k) = mkList
        if (m < 0 || m > 1000) throw Throwable("out of range 0..1000 m: $m")
        if (k < 0) throw Throwable("out of range k >= 0")

//        ordinary notation
        val notation = when {
            (k % 100) in 11..13 -> "th"
            (k % 10) == 1 -> "st"
            (k % 10) == 2 -> "nd"
            (k % 10) == 3 -> "rd"
            else -> "th"
        }

//        m이나 k가 0으로 올 경우 개행 문자 반환
        if (m == 0 || k == 0) {
            result += "$k$notation most common word(s):\n\n"
            i++
            continue;
        }

        val wordMap = mutableMapOf<String, Int>()
//        단어 빈도수 저장
        var j = 1
        while (j in 1..m) {
            val word = input.readLine()

            if (word.isNullOrBlank()) throw Throwable("isNullOrBlank word")
            wordMap[word] = wordMap.getOrDefault(word, 0) + 1
            j++
        }

//        k번째로 많이 등장한 단어 찾기
        val wordList = wordMap.values.distinct().sortedDescending()

        result += "$k$notation most common word(s):\n"

        if (k <= wordList.size) {
            val kWords = wordMap.filterValues { it == wordList[k - 1] }.keys
            for (word in kWords) {
                result += "$word\n"
            }
        }
        result += "\n"
        i++
    }

    output.write(result)
    output.flush()
}