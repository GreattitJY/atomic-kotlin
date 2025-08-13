package book.lambdas

import book.atomictest.eq


fun mapping() {
    val list = listOf('a', 'b', 'c', 'd')
    val result =
        list.map { "[${it.uppercaseChar()}]" }
    result eq listOf("[A]", "[B]", "[C]", "[D]")

}
