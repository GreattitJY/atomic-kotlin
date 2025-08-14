package book.importanceoflambdas

import book.atomictest.eq

fun sortingLambda() {
    val list = listOf(1, 2, 3, 4)
    val isEven = { e: Int -> e % 2 == 0 }
    list.filter(isEven) eq listOf(2, 4)
    list.any(isEven) eq true
}