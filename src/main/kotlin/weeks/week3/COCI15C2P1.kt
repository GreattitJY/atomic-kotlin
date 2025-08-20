package weeks.week3

fun coci15c2p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val KEYBOARD = mapOf<Char, String>(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

//    N은 입력받을 단어의 개수 1..1000
    val N = input.readLine().toIntOrNull() ?: throw Throwable("invalid N")
    if (N < 0 || N > 1000) throw Throwable("out of range 1..1000 N: $N")

    val wordSet = mutableSetOf<String>()
//    N 길이만큼 입력받은 단어 유효성 검사 1..1_000_000
    var i = 0
    while (i in 0..<N) {
        val word = input.readLine()
        if (word.isNullOrBlank()) throw Throwable("isNullOrBlank word")
        if (word.length > 1_000_000) throw Throwable("out of range 1..1_000_000 word length: ${word.length}")
        wordSet.add(word)
        i++
    }

//    S(키보드와 매핑되는 문자열) 유효성 검사 길이 1..1000, 각 자릿수는 2..9
    val S = input.readLine()
    if (S.length < 1 || S.length > 1000) throw Throwable("out of range 1..1000 S length: ${S.length}")
    i = 0
    while (i in 0..<S.length) {
        if (!S[i].isDigit()) throw Throwable("invalid S[$i]: ${S[i]}")
        if (S[i] !in '2'..'9') throw Throwable("out of range 2..9 S[$i]: ${S[i]}")
        i++
    }

//    입력 받은 단어와 S를 키보드 매핑해서 만들 수 있는 단어인지 확인
    var count = 0
    for (word in wordSet) {
        var isPossible = true
        var idx = 0
        while (isPossible && idx < word.length && idx < S.length) {
            val char = word[idx]
            val key = S[idx]
            val targetStrings = KEYBOARD.getOrDefault(key, "NONE")
            if (targetStrings != "NONE" && char in targetStrings) {
                idx++
            } else {
                isPossible = false
            }
        }
        if (isPossible) count++
    }

    output.write("$count")
    output.flush()
}