package basic

fun oneOrTheOtherExample() {
    val x = 1
    println(oneOrTheOther(x==1))
    println(oneOrTheOther(x==2))
}

fun oneOrTheOther(exp:Boolean):String =
    if (exp)
        "True!"
    else
        "False"