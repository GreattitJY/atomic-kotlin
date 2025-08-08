package book.lists

import book.atomictest.capture

fun outOfBoundsExample() {
    val ints = listOf(1, 2, 3)
    capture {
        ints[3]
    } contains
            listOf("ArrayIndexOutOfBoundsException")
}