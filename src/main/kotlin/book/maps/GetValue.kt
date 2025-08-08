package book.maps

import book.atomictest.capture
import book.atomictest.eq

fun getValueExample() {
    val map = mapOf('a' to "attempt")
    map['b'] eq null
    capture {
        map.getValue('b')
    } eq "NoSuchElementException: " + "Key b is missing in the map."
    map.getOrDefault('a', "??") eq "attempt"
    map.getOrDefault('b', "??") eq "??"
}