package weeks.week2

fun ccc19j1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val mutableList = mutableListOf<Int>()

    for (i in 1..6) {
        mutableList.add(input.readLine().toInt())
    }

    val (applePointShot, appleFieldGoal, appleFreeThrow) = mutableList.slice(0..2)
    val (bananaPointShot, bananaFieldGoal, bananaFreeThrow) = mutableList.slice(3..5)

    val appleScore = caculateScore(applePointShot, appleFieldGoal, appleFreeThrow)
    val bananaScore = caculateScore(bananaPointShot, bananaFieldGoal, bananaFreeThrow)

    val result = if (appleScore == bananaScore)
        'T'
    else if (appleScore > bananaScore)
        'A'
    else
        'B'

    output.write("$result")
    output.flush()
}

fun caculateScore(pointShot: Int, fieldGoal: Int, freeThrow: Int): Int =
    pointShot * 3 + fieldGoal * 2 + freeThrow