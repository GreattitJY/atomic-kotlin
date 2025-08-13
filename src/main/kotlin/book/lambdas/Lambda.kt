package book.lambdas

import book.atomictest.eq

fun Lambda() {
    val list = listOf(1, 2, 3, 4)
    val result = list.map({ "[$it]" })
    result eq listOf("[1]", "[2]", "[3]", "[4]")
}