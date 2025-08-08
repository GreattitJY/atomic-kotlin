package varargs

fun mainArgsExample(args:Array<String> = arrayOf("arg1", "arg2", "arg3")) {
    for (a in args) {
       println(a)
    }
}