package lists

import atomictest.eq

fun apparentlyMutableListExample() {
    var list = listOf('X')
    list += 'Y'
    list eq "[X, Y]"
}