package book.sets

import book.atomictest.eq

fun setsExample() {
    val intSet = setOf(1,1,2,3,9,9,4)

    intSet eq setOf(1,2,3,9,4)

    setOf(1,2) eq setOf(2,1)

    (9 in intSet) eq true
    (99 in intSet) eq false

    intSet.contains(9) eq true
    intSet.contains(99) eq false

    intSet.containsAll(setOf(1,9,2)) eq true

    // 합집합
    intSet.union(setOf(3,4,5,6)) eq setOf(1,2,3,4,5,6,9)

    // 교집합
    intSet intersect setOf(0,1,2,7,8) eq setOf(1,2)

    // 차집합
    intSet subtract setOf(0,1,9,10) eq setOf(2,3,4)
}