package weeks.week3

fun ecoo17r3p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val DATASETS = 10
    val DOZENS = 13
    var result = ""

    var i = 1
    while (i in 1..DATASETS) {
        var count = 0;
//        첫번째 입력 검증 - "F(franchise count) D(days count)"
        val n0 = input.readLine()
        if (n0.isNullOrBlank()) throw Throwable("isNullOrBlank Text n0")
        val dataset = n0.split(" ").map { it.toIntOrNull() ?: throw Throwable("invalid n0") }
        if (dataset.size != 2) throw Throwable("invalid dataset size ${dataset.size}")
        val (F, D) = dataset
        if (F < 4 || F > 130 || D < 2 || D > 4745) throw Throwable("out of range F(4..130): $F, D(2..4745): $D")
//        첫번째 입력 검증 끝

        val individualSellMap = mutableMapOf<Int, Int>()
        var d = 1
        while (d in 1..D) {
            val fStrings = input.readLine()
//            두번째 입력 검증 시작
//            F(열) 1.올바른 문자 형식인지 검증 "$number $number", 2.문자열 변환 후 사이즈 검증
            if (fStrings.isNullOrBlank()) throw Throwable("isNullOrBlank fStrings")
            val fList = fStrings.split(" ").map { it.toIntOrNull() ?: throw Throwable("invalid fStrings $it") }
            if (fList.size != F) throw Throwable("invalid size fList: $fList")

//            F(franchise) 각 열 검증 - 범위 검사
            var f = 0
            while (f in 0..<F) {
                if (fList[f] < 1 || fList[f] > 13_000) throw Throwable("out of range 1..13_000 fList[$f]: ${fList[f]}")
                f++
            }
//            두번째 입력 검증 끝

//           프랜차이즈 요구 사항 시작 - signle day와 individaul을 기준으로 DOZENS 배수일 경우 카운트 업
//            F(franchise) 요구 사항 1 - single day (결합된 프랜차이즈의 모든 판매를 더해서 DOZENS으로 나눠서 카운트)
            var singleDaySell = 0
            for (i in 0..<F) {
                singleDaySell += fList[i]
            }
            if (singleDaySell % DOZENS == 0) count += singleDaySell / DOZENS


//            F(franchise) 요구 사항 2 - 개별 프렌차이즈의 요일별 판매를 map에 넣기 (추후 계산하기 위함)
            for (i in 0..<F) {
                individualSellMap[i] = individualSellMap.getOrDefault(i, 0) + fList[i]
            }
            d++
        }

//        F(franchise) 요구 사항 2 - 개별 프랜차이즈의 당일 판매를 DOZENS로 나눠서 카운트
        for (i in 0..<F) {
            val individualSell = individualSellMap.getOrDefault(i, 0)
            if (individualSell % DOZENS == 0) count += individualSell / DOZENS
        }
//       프랜차이즈 요구 사항 끝
        result += "$count\n"
        i++
    }

    output.write(result)
    output.flush()
}