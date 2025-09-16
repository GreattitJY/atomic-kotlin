package weeks.week5

/*
You're given a string N, called the needle, and a string H, called the haystack,
both of which contain only lowercase letters a…z.

Write a program to count the number of distinct permutations of N which appear as a substring of H at least once.
Note that N can have anywhere between 1 and |N|! distinct permutations in total
– for example, the string aab has 3 distinct permutations (aab, aba, and baa).

<Input Specification>
The first line contains N (1<= |N| <= 200_000), the needle string.
The second line contains H (1<= |H| <= 200_000), the haystack string.

<Output Specification>
Output consists of one integer, the number of distinct permutations of N which appear as a substring of H.
*/

private val inputLength: (String, IntRange) -> String = { value, range ->
    if (value.length !in range) throw IllegalArgumentException("invalid length: ${value.length}")
    value
}

fun ccc20s3() {
    val input = System.`in`.bufferedReader()

    val N = input.readLine().let { inputLength(it, 1..200_000) }
    val H = input.readLine().let { inputLength(it, 1..200_000) }


    val needleCount = mutableMapOf<Char, Int>()
    for (char in N) {
        needleCount[char] = needleCount.getOrDefault(char, 0) + 1
    }

    val permutations = mutableSetOf<String>()
    val haystackCount = mutableMapOf<Char, Int>()
    for (i in H.indices) {
        val newChar = H[i]
        haystackCount[newChar] = haystackCount.getOrDefault(newChar, 0) + 1

//        인덱스가 needle 크기를 넘어갈 경우 업데이트
        if (i >= N.length) {
            val oldChar = H[i - N.length]

            haystackCount[oldChar] = haystackCount.getOrDefault(oldChar, 0) - 1
            if (haystackCount[oldChar] == 0) haystackCount.remove(oldChar)
        }

//        인덱스가 needle 크기 이상일 경우 매번 순열인지 확인
        if (i >= N.length - 1 && haystackCount == needleCount) {
            permutations.add(H.substring(i - N.length + 1, i + 1))
        }
    }

    println(permutations.size)
}