package book.lambdas

import book.atomictest.eq

fun twoArgLambda() {
    val list = listOf('a', 'b', 'c')
    list.mapIndexed { index, element -> "[$index: $element]" } eq listOf("[0: a]", "[1: b]", "[2: c]")

}