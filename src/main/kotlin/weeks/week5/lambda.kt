package weeks.week5

fun lambda() {
//    val f: (Int, String, Boolean) -> String = { a, b, c ->
//        "Int:$a, String:\"$b\", Booleab:$c"
//    }
//
//    val f2 = fun(a: Int, b: String, c: Boolean): String {
//        if (a > 3) return "fail"
//        return "Int:$a, String:\"$b\", Booleab:$c"
//    }
//
//    val f3: (Int) -> Int = {
//        it + 3
//    }
//
//    a { println(it) }
//    println(f(1, "abc", true))

//    val a = "url"
//    val b = optional({ netFetchApi(a).response.json.data > 2 }) {
//        println("a > 2")
//        hardLogger.logDelayed(././)
//    }
//    b()

    val iter = iterator(0, { if (it < 10) it + 2 else null }) {
        println(it)
    }
    iter()

//    val member = Member({ "aa" }) { 11 }
//
//    suspend {
//        member.name()
//    }
    
    val list = listOf('a', 'b', 'c', 'X', 'Z')
    println(list.takeLast(3) eq "[c, X, Z]")
    println(list.takeLastWhile { it.isUpperCase() } eq "[X, Z]")
    println(list.drop(2) eq "[c, X, Z]")
    println(list.dropWhile { it.isLowerCase() } eq "[X, Z]")

    val member = "jy" age 10 grade 10

    listOf(1, 2, 3).fold(0) { acc: Int, it: Int -> acc + it }
    val sum = listOf(1, 2, 3, 0).fold(0) { acc, i -> acc + i }


    val a = listOf(1, 2, 3, 0).fold(AnyFold(false, { it > 0 })) { acc, it ->
        if (acc.result) acc
        else AnyFold(acc.lambda(it), acc.lambda)
    }.result

    println("a: $a")

    listOf(1, 2, 3, 0).fold({ it: Int -> println(it) }) { acc, it ->
        acc(it)
        acc
    }

}


data class AnyFold(val result: Boolean, val lambda: (Int) -> Boolean)

data class Member(val name: String, val age: Int, val grade: Int = -1)

infix fun Member.grade(grage: Int): Member = Member(this.name, this.age, grage)
infix fun String.age(age: Int): Member = Member(this, age)
infix fun Any.eq(a: String): Boolean = this.toString() == a
infix fun Boolean.eq(b: String): Boolean {
    return this.toString() == b
}

//fun a(lambda: (Int) -> Unit) {
//    lambda(1)
//}


fun optional(condition: () -> Boolean, lambda: () -> Unit): () -> Boolean = {
    if (condition()) lambda()
    condition()
}

fun iterator(init: Int, condition: (Int) -> Int?, lambda: (Int) -> Unit): () -> Unit = {
    var accumulator = init
    do {
        accumulator = condition(accumulator) ?: break
        lambda(accumulator)
    } while (true)
}