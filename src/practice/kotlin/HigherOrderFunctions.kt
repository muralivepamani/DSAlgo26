package practice.kotlin

fun calculate(
    a: Int, b: Int,
    operation: (Int, Int) -> Int
): Int {
    return operation(a, b)

}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun mul(a: Int, b: Int): Int {
    return a * b
}