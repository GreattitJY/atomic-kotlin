package book.importanceOfLambdas

import book.atomictest.eq

fun filter() {
    val list = listOf(1, 2, 3, 4)
    val even = list.filter { it % 2 == 0 }
    even eq listOf(2, 4)
}