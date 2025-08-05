package lists

import atomictest.eq

fun main() {
    val numbers = listOf(1, 2, 3)
    val strings = listOf("one", "two", "three")

    val numbers2:List<Int> = listOf(1, 2, 3)
    val strings2:List<String> = listOf("one", "two", "three")

    numbers eq numbers2
    strings eq strings2
}