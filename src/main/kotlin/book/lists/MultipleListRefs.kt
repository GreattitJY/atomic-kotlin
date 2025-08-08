package book.lists

import book.atomictest.eq

fun multipleListRefsExample() {
    val first = mutableListOf(1)
    val second:List<Int> = first
    second eq listOf(1)

    first += 2
    second eq listOf(1,2)
}