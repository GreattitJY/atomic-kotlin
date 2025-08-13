package book.lambdas

import book.atomictest.trace

fun zeroArguments() {
    run { -> trace("A Lambda") }
    run { trace("Without args") }
    trace eq """
        A Lambda
        Without args
    """
}