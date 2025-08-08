package maps

import atomictest.eq

fun readOnlyMapsExample() {
    val m = mapOf(5 to "five", 6 to "six")
    m[5] eq "five"

    m + (4 to "four") // m 그대로
    m eq mapOf(5 to "five", 6 to "six")
    val m2 = m + (4 to "four")
    m2 eq mapOf(5 to "five", 6 to "six", 4 to "four")


}