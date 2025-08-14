package book.operationsoncollections

import book.atomictest.eq

fun createPair() = Pair(1, "one")

fun pairOfList() {
    val (i, s) = createPair()
    i eq 1
    s eq "one"
}