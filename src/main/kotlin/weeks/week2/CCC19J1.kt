package weeks.week2

fun ccc19j1() {
    val input = System.`in`.bufferedReader()
    val output = System.out.bufferedWriter()

    val a3 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int a3")
    if (a3 !in 0..100) throw Throwable("out of range 0..100 a3: $a3")
    val a2 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int a2")
    if (a2 !in 0..100) throw Throwable("out of range 0..100 a2: $a2")
    val a1 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int a1")
    if (a1 !in 0..100) throw Throwable("out of range 0..100 a1: $a1")

    val b3 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int b3")
    if (b3 !in 0..100) throw Throwable("out of range 0..100 a3: $b3")
    val b2 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int b2")
    if (b2 !in 0..100) throw Throwable("out of range 0..100 a2: $b2")
    val b1 = input.readLine().toIntOrNull() ?: throw Throwable("invalid int b1")
    if (b1 !in 0..100) throw Throwable("out of range 0..100 a1: $b1")

    val scoreA = a1 + (a2 * 2) + (a3 * 3)
    val scoreB = b1 + (b2 * 2) + (b3 * 3)
    val result = when {
        scoreA > scoreB -> "A"
        scoreA < scoreB -> "B"
        else -> "T"
    }
    
    output.write(result)
    output.flush()
}