package book.lambdas

import book.atomictest.eq

fun underscore() {
    val list = listOf('a', 'b', 'c')
    list.mapIndexed { idx, _ ->
        "[$idx]"
    } eq listOf("[0]", "[1]", "[2]")
}