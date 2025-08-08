package book.maps

import book.atomictest.eq

fun mapsExample() {
    val constants = mapOf(
        "Pi" to 3.141,
        "e" to 2.718,
        "phi" to 1.618
    )

    constants eq "{Pi=3.141, e=2.718, phi=1.618}"

    // 키의 값 조회
    constants["e"] eq 2.718
    constants.keys eq setOf("Pi", "e", "phi")
    constants.values eq "[3.141, 2.718, 1.618]"
    println(constants.values::class)

    var s = ""

//    for (entry in constants) {
//        s += "${entry.key}=${entry.value}, "
//    }
//    s eq "Pi=3.141, e=2.718, phi=1.618,"

    for ((key,value) in constants)
        s += "$key=$value, "
    s eq "Pi=3.141, e=2.718, phi=1.618,"
}