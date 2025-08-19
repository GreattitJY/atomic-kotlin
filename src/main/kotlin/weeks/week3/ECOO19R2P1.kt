package weeks.week3

fun ecoo19r2p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val DATASETS = 10

    var result = ""

    var i = 1
    while (i in 1..DATASETS) {
        val emailSet = mutableSetOf<String>()

        val N = input.readLine().toIntOrNull() ?: throw Throwable("invalid int N")

        // 입력 검증 시작
        // 1. 이메일 수 검증: 처음 6개 입력의 1 <= N <=100, 이후 1 <= N <= 100_000
        if (i > 6) {
            if (N < 1 || N > 100_000) throw Throwable("out of range 1..100_000 N: $N")
        } else {
            if (N < 1 || N > 100) throw Throwable("out of range 1..100 N: $N")
        }

        var j = 1
        while (j in 1..N) {
            var inputEmail = ""
            // 2. 주소 길이 검증 : 1 <= |S| <= 30
            val S = input.readLine()
            if (S.isNullOrBlank()) throw Throwable("isNullOrBlank S: $S")
            if (S.length < 1 || S.length > 30) throw Throwable("out of range 1..30 S: $S")

            /**
             * 3. 주소 유효성 검증
             * - 사용자 부분: 싱글 at-sign(@) 앞에 문자, 숫자, 점 그리고 플러스로 구성된 비어있지 않은 문자열
             * - 도메인 부분: 싱글 at-sign(@) 뒤에 문자, 숫자, 점으로 구성된 비어있지 않은 문자열
             */
            if (S.count { it == '@' } != 1) throw Throwable("at-sign(@) must be single")
            val sList = S.split("@")

            var s = 0
            while (s in 0..<sList.size) {
                val part = sList[s]

                if (part.isNullOrBlank()) throw Throwable("isNullOrBlank part: $part")

                if (s == 0) {
                    // 사용자 부분
                    if (!part.all { it in 'a'..'z' || it in 'A'..'Z' || it in '0'..'9' || it == '.' || it == '+' })
                        throw Throwable("user part consisting of letters, numbers, dots and pluses")
                } else {
                    // 도메인 부분
                    if (!part.all { it in 'a'..'z' || it in 'A'..'Z' || it in '0'..'9' || it == '.' })
                        throw Throwable("domain part consisting of letters, numbers, and dots.")
                }
                s++
            }

            // 요구 사항 시작
            /**
             * - at-sign(@) 전에 표시가 된 dots(.)는 무시
             * - at-sign(@) 전에 표시된 plus(+)와 플러스 뒤의 문자 모두 무시
             * - 대소문자 무시
             */
            s = 0
            while (s in 0..<sList.size) {
                val part = sList[s]

                if (s == 0) {
                    // 사용자 부분
                    var p = 0
                    while (p in 0..<part.length) {
                        val c = part[p]

                        if (c == '+') break
                        if (c == '.') {
                            p++
                            continue
                        }

                        inputEmail += c.uppercaseChar()
                        p++
                    }
                } else {
                    // 도메인 부분
                    inputEmail += '@'
                    var p = 0
                    while (p in 0..<part.length) {
                        val c = part[p]
                        inputEmail += c.uppercaseChar()
                        p++
                    }
                }
                s++
            }
            emailSet.add(inputEmail)
            // 요구 사항 끝
            j++
        }
        // 입력 검증 끝
        result += "${emailSet.size}\n"
        i++
    }

    output.write(result)
    output.flush()
}