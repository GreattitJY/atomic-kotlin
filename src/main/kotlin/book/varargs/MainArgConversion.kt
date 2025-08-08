package varargs

fun mainArgConversionExample(args:Array<String> = arrayOf("test", "42", "3.14")) {
    if (args.size < 3) return
        val first = args[0]
        val second = args[1].toInt()
        val third = args[2].toFloat()
        println("$first $second $third")
}