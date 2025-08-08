package book.maps

import book.atomictest.eq

class Contact(
    val name: String,
    val phone:String
) {
    override fun toString(): String {
        return "Contact('$name', '$phone')"
    }
}

fun contactMapExample() {
    val miffy = _root_ide_package_.book.maps.Contact("Miffy", "1-234-567890")
    val cleo = _root_ide_package_.book.maps.Contact("Cleo", "098-765-4321")
    val contacts = mapOf(
        miffy.phone to miffy,
        cleo.phone to cleo
    )
    contacts["1-234-567890"] eq miffy
    contacts["1-111-1111"] eq null
}