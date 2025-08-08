package varargs

fun v(s:String, vararg d: Double) {
    println("$s $d")
}

fun variableArgListExample() {
    v("abc", 1.0, 2.0)
    v("def", 1.0, 2.0, 3.0, 4.0)
    v("ghi", 1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
}