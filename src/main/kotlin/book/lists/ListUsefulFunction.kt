package book.lists

import book.atomictest.eq

fun listUsefulFunctionExample() {
    val doubles = listOf(1.1, 2.2, 3.3, 4.4)
    doubles.sum() eq 11.0

    val strings = listOf("Twas", "Brilling", "And", "Slithy", "Toves")
    strings.sorted() eq listOf("And", "Brilling", "Slithy", "Toves", "Twas")
    strings.reversed() eq listOf("Toves", "Slithy", "And", "Brilling", "Twas")
    strings.first() eq "Twas"
    strings.takeLast(2) eq listOf("Slithy", "Toves")

}