package practice.kotlin

/**inline: the function body and eligible lambda arguments can be copied into the call site.
noinline: preserves the lambda as an ordinary function object, allowing it to be stored or passed around.
crossinline: prohibits a non-local return from the lambda, which is useful when the lambda may execute from another generated context.*/

inline fun execute(
    block: () -> Unit,
    noinline callback: () -> Unit,
    crossinline action: () -> Unit

) {
    block()
    val list = mutableListOf<() -> Unit>()
    list.add(callback)
    val runnable = Runnable {
        action()
    }
    runnable.run()

}