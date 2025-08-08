package boolean

fun main() {
    val b = 1
    println(trueOrFalse2(b<3))
}

fun trueOrFalse(exp:Boolean):String {
    if (exp)
        return "It`s true!"
    return "It`s false"
}

fun trueOrFalse2(exp:Boolean):String= if (exp) "It`s true" else "It`s false"