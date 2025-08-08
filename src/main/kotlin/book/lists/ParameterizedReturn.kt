package book.lists

import book.atomictest.eq

fun inferred(p:Char, q:Char) =  listOf(p,q)

fun explicit(p:Char, q: Char):List<Char> = listOf(p,q)

fun parameterizedReturnExample() {
    _root_ide_package_.book.lists.inferred('a', 'b') eq "[a, b]"
    _root_ide_package_.book.lists.explicit('y', 'z') eq "[y, z]"
}