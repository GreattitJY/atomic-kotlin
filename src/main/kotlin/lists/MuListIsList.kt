package lists

import atomictest.eq

fun getList():List<Int> {
    return mutableListOf(1, 2, 3)
}

fun muListIsListExample() {
    val list = getList()
//    list += 3
    list eq listOf(1, 2, 3)

}