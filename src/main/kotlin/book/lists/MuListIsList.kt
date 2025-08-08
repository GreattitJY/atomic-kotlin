package book.lists

import book.atomictest.eq

fun getList():List<Int> {
    return mutableListOf(1, 2, 3)
}

fun muListIsListExample() {
    val list = _root_ide_package_.book.lists.getList()
//    list += 3
    list eq listOf(1, 2, 3)

}