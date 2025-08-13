package book.lambdas

import book.atomictest.eq

fun listIndicesMap() {
    val list = listOf('a', 'b', 'c')
    list.indices.map {
        "[$it]"
    } eq listOf("[0]", "[1]", "[2]")
}