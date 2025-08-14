package book.operationsoncollections

import book.atomictest.eq

fun filterNotNull() {
    val list = listOf(1, 2, null)
    list.filterNotNull() eq "[1, 2]"
}