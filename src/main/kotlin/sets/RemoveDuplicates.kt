package sets

import atomictest.eq

fun removeDuplicatesExample() {
    val list = listOf(3,3,2,1,2)
    list.toSet() eq setOf(1,2,3)
    list.distinct() eq listOf(3,2,1)
    val setList = setOf(1,2)
    println(list.distinct()::class)
    println(setList::class)
    "abbcc".toSet() eq setOf('a', 'b', 'c')
}