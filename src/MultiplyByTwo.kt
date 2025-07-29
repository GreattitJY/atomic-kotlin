package functions

fun multiplyByTwo(x: Int):Int {
    println("Inside multipleByTwo")
    return x*2
}

fun main() {
    val r= multiplyByTwo(5)
    println(r)
}