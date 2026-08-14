package stackqueue

import java.util.Stack

class `Daily Temperatures` {
    fun dailyTemperatures(temps: IntArray): IntArray {
        val n = temps.size
        val res = IntArray(n)
        val stack = Stack<Int>()
        for (i in 0 until n) {

            while (stack.isNotEmpty() && temps[stack.peek()] < temps[i]) {
                val prev = stack.pop()
                res[prev] = i - prev

            }
            stack.push(i)
        }
        return res

    }
}