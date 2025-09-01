package weeks.week4

fun ecoo19r2p1() {
    val input = System.`in`.bufferedReader()

    val DATASET = 10
    val output = mutableListOf<Int>()

    var i = 1
    while (i in 1..DATASET) {
        val N = input.readLine().toIntOrNull() ?: throw IllegalArgumentException("invalid int N")
//        도메인 분기처리는 주석을 달아야 한다. 코드로 이유를 설명할 수 없기 때문이다.
        if (i < 7) { // 왜 처음 6개는 100개 이하인지 궁금해하기
            if (N !in 1..100) throw IllegalStateException("out of range 1..100 N: $N")
        } else {
            if (N !in 1..100_000) throw IllegalStateException("out of range 1..1000_000 N: $N")
        }

//        식별되는 각각의 요소를 entity라고 한다.
//        엔티티들이 모여있는 관계들(relation)
        val emails = mutableSetOf<String>()
        var j = 1
        while (j in 1..N) {
            val email = input.readLine()
            if (email.length !in 3..30) throw Throwable("out of range 3..30 lenght: ${email.length}")
            val split = email.split("@")
            if (split.size != 2 || split[0].isEmpty() || split[1].isEmpty()) throw Throwable("invalid email: $email")
            val user = split[0].lowercase().replace(".", "").let {
                if ('+' in it) {
                    it.split("+")[0]
                } else it
            }
            val domain = split[1].lowercase()

            var k = 0
            while (k < user.length) {
                if (user[k] != '+' && user[k] != '.' && user[k] !in 'a'..'z' && user[k] !in 'A'..'Z' && user[k] !in '0'..'9') {
                    throw Throwable("invalid char in user: ${user[k]}")
                }
                k++
            }

            k = 0
            while (k < domain.length) {
                if (domain[k] != '.' && domain[k] !in 'a'..'z' && domain[k] !in 'A'..'Z' && domain[k] !in '0'..'9') {
                    throw Throwable("invalid char in domain: ${domain[k]}")
                }
                k++
            }

            // 코드에서 가독성이란 무엇일까? 코드의 표현을 어디까지 사용할 것이냐? 일반적으로 공식 사이트 수준의 컴플레이션은 허용. 그래도 팀과 조율해야
            emails.add(
                "${
                    user.lowercase().replace(".", "").let {
                        if ('+' in it) it.split("+")[0] else it
                    }
                }@${domain.lowercase()}"
            )
            j++
        }
        output.add(emails.size)
        i++
    }

    for (o in output) {
        println(o)
    }
}