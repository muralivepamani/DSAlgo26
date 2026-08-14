package twoheaps

import java.util.PriorityQueue

class MedianFinder {

    // Max heap stores the smaller half
    private val left = PriorityQueue<Int>(compareByDescending { it })

    // Min heap stores the larger half
    private val right = PriorityQueue<Int>()

    fun addNum(num: Int) {

        // Add number to max heap
        left.offer(num)

        // Move largest from left to right
        right.offer(left.poll())

        // Keep left equal or one larger than right
        if (left.size < right.size) {
            left.offer(right.poll())
        }
    }

    fun findMedian(): Double {

        // Odd count means left has the middle element
        if (left.size > right.size) {
            return left.peek().toDouble()
        }

        // Even count means average of two middle elements
        return (left.peek() + right.peek()) / 2.0
    }
}