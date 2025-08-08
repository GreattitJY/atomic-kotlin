package book.lists

import  book.atomictest.eq

fun plusAssignPuzzleExample() {
    val list1 = mutableListOf('A')
    // 둘은 같은 문법
    list1 += 'A'
    list1.plusAssign('A')

    val list2 = listOf('B')
//    list2 += 'B'
//    list2 = list2 + 'B'

    // 새로운 변수 생성 후 재대입
    var list3 = listOf('C')
    list3 += 'C'
    val newList = list3 + 'C'
    list3 = newList

    list1 eq "[A, A, A]"
    list2 eq "[B]"
    list3 eq "[C, C, C]"
}