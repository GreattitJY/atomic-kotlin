package book.lambdas

import book.atomictest.eq

fun basicLambda() {
    val list = listOf(1, 2, 3, 4)
    val result = list.map({ n -> "[$n]" })
    result eq listOf("[1]", "[2]", "[3]", "[4]")
}