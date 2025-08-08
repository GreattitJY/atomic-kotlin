package book.basic

fun multiplyByTwo(x: Int):Int {
    println("Inside multipleByTwo")
    return x*2
}

fun multiplyByTwoExample() {
    val r= multiplyByTwo(5)
    println(r)
}