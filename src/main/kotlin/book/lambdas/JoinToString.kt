package book.lambdas

import book.atomictest.eq

fun joinToString() {
    val list = listOf(9, 11, 23, 32)
    list.joinToString(" ") { "[$it]" } eq "[9] [11] [23] [32]"
}