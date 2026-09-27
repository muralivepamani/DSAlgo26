package practice

class Solution {
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

    inline fun execue(
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

    fun test() {

        val sum = calculate(10, 5) { a, b ->
            a + b
        }
        val mul = calculate(10, 5) { a, b ->
            a * b
        }
        val result = calculate(10, 5, ::add)
        println("sum$sum")
        println("mul$mul")
        println("result$result")
    }

}

sealed interface UiState {
    data object Loading : UiState
    data class Success(val data: List<String>) : UiState
    data class Error(val message: String) : UiState

}

fun handleState(state: UiState) {
    when (state) {
        is UiState.Loading -> {
            //Loading
        }

        is UiState.Success -> {
            print(state.data)

        }

        is UiState.Error -> {
            print(state.message)
        }
    }
}


object Logger
class User private constructor() {
    companion object {
        fun create(): User = User()
    }
}



