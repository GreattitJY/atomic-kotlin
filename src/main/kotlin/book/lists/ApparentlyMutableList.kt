package book.lists

import book.atomictest.eq

fun apparentlyMutableListExample() {
    var list = listOf('X')
    list += 'Y'
    list eq "[X, Y]"
}