package weeks.week2

fun coci16c1p1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val xMegabytes = input.readLine().toInt()
    val nMonth = input.readLine().toInt()
    val spentMegabytes = mutableListOf<Int>()
    var totalMegabytes = 0

    repeat(nMonth) {
        spentMegabytes.add(input.readLine().toInt())
    }

    for (i in 0 until nMonth) {
        totalMegabytes += xMegabytes
        val nMegabytes = spentMegabytes[i]

        if (totalMegabytes < nMegabytes) {
            totalMegabytes = 0
        } else {
            totalMegabytes -= nMegabytes
        }
    }

    totalMegabytes += xMegabytes
    output.write("$totalMegabytes")
    output.flush()
}