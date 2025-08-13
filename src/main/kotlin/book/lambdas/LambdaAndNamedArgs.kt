package book.lambdas

import book.atomictest.eq

fun lambdaAndNamedArgs() {
    val list = listOf(9, 11, 23, 32)
    list.joinToString(
        separator = " ",
        transform = { "[$it]" }
    ) eq "[9] [11] [23] [32]"
}