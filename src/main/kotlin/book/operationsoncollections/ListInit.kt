package book.operationsoncollections

import book.atomictest.eq

fun listInit() {
    val mutableList1 = MutableList(5, { 10 * (it + 1) })
    mutableList1 eq "[10, 20, 30, 40, 50]"
    val mutableList2 = MutableList(5) { 10 * (it + 1) }
    mutableList2 eq "[10, 20, 30, 40, 50]"
}