package stackqueue

import java.util.ArrayDeque

class `Largest Rectangle in Histogram` {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Int>() // Stores indices of heights in increasing order
        var maxArea = 0
        val n = heights.size

        for (i in 0..n) {
            // Treat the end of array as a dummy bar of height 0 to flush the stack
            val currentHeight = if (i == n) 0 else heights[i]

            while (stack.isNotEmpty() && heights[stack.peek()] > currentHeight) {
                val height = heights[stack.pop()]
                // If stack is empty, width extends all the way to index 0
                val width = if (stack.isEmpty()) i else i - stack.peek() - 1
                maxArea = maxOf(maxArea, height * width)
            }
            stack.push(i)
        }

        return maxArea
    }
}