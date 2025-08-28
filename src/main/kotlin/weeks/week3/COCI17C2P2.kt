package weeks.week3

fun coci17c2p2() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val inputString = input.readLine()

    if (inputString.length != 3) throw Throwable("invalid input legnth: ${inputString.length}")

    val (K, N) = inputString.split(' ').map { it.toIntOrNull() ?: throw Throwable("invalid input K N") }

    if (K < 1 || K > 100_000 || N < 1 || N > 100_000) throw Throwable("out of range 1..100_000: K and N")


    val availableWord = mutableMapOf<Char, MutableList<String>>()

    var i = 1
    while (i in 1..K) {
        val word = input.readLine()

//        word 유효성 검사
        if (word.isNullOrBlank() || word.length > 21) throw Throwable("invalid word length: ${word.length}")
        var idx = 0
        while (idx in 0..<word.length) {
            if (word[idx] < 'a' || word[idx] > 'z') throw Throwable("word must be lowercase")
            idx++
        }

//        word 저장
        val firstChar = word[0]
        if (availableWord.contains(firstChar)) {
            availableWord[firstChar]?.add(word)
        } else {
            availableWord[firstChar] = mutableListOf(word)
        }
        i++
    }


    val alphabetList = mutableListOf<Char>()
//    N - 알파벳 입력받기
    i = 1
    while (i in 1..N) {
        val inputString = input.readLine()

        if (inputString.length != 1) throw Throwable("input must be single ${inputString}")
        val alphabet = inputString[0]
        if (alphabet < 'a' || alphabet > 'z') throw Throwable("out of range a..z: ${alphabet}")

        alphabetList.add(alphabet)
        i++
    }


    val wordCount = mutableMapOf<String, Int>()
    val result = mutableListOf<String>()

//    알파벳 리스트와 활용 가능한 단어 유효성 검사
    i = 0
    while (i in i..<alphabetList.size) {
        val alphabet = alphabetList[i]
        val wordList = availableWord[alphabet]
        if (wordList == null || wordList.size == 0) throw Throwable("활용가능한 단어 목록과 입력된 알파벳 리스트가 일치하지 않습니다.")
        i++
    }

//    단어 카운트
    for (i in 0..<alphabetList.size) {
        val alphabet = alphabetList[i]
        val wordList = availableWord[alphabet]!!

//        알파벳 기준으로 가장 적게 업근된 단어 카운트 찾기
        var minCount = Int.MAX_VALUE
        for (w in 0..<wordList.size) {
            val count = wordCount.getOrDefault(wordList[w], 0)
            if (count < minCount) {
                minCount = count
            }
        }

//        1. 가장 적게 언급된 단어랑 단어 리스트의 카운트가 일치하는 걸 찾는다.
//        2. 가장 적게 언급된 단어들 중 알파벳이 빠른 순으로 선택한다.
        var selectedWord = ""
        for (w in 0..<wordList.size) {
            val word = wordList[w]
            val count = wordCount.getOrDefault(word, 0)

            if (count == minCount) {
                if (selectedWord.isEmpty() || word < selectedWord) {
                    selectedWord = word
                }
            }
        }

//      선택된 단어 결과에 저장하고 해당 단어 카운트 업
        result.add(selectedWord)
        wordCount[selectedWord] = wordCount.getOrDefault(selectedWord, 0) + 1
    }

//    출력
    for (word in result) {
        output.write("${word}\n")
    }
    output.flush()
}