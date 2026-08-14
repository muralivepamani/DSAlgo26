package twoheaps

import java.util.PriorityQueue

class `Sliding Window Median` {


    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {

        // Store median of each window
        val res = DoubleArray(nums.size - k + 1)

        // Process each sliding window
        for (i in 0..nums.size - k) {
            res[i] = findMedian(nums, i, i + k - 1)
        }

        return res
    }

    fun findMedian(nums: IntArray, start: Int, end: Int): Double {

        // Max heap stores smaller half
        val left = PriorityQueue<Int>(compareByDescending { it })

        // Min heap stores larger half
        val right = PriorityQueue<Int>()

        // Add every number from current window
        for (i in start..end) {
            left.add(nums[i])
            right.add(left.poll())

            // Balance both heaps
            if (left.size < right.size) {
                left.add(right.poll())
            }
        }

        // Return middle value for odd window
        if (left.size > right.size) {
            return left.peek().toDouble()
        }

        // Convert before addition to avoid Int overflow
        return (left.peek().toDouble() + right.peek().toDouble()) / 2.0
    }
}


class Solution {

    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {

        // Store median of each window
        val res = DoubleArray(nums.size - k + 1)

        // Process each sliding window
        for (i in 0..nums.size - k) {
            res[i] = findMedian(nums, i, i + k - 1)
        }

        return res
    }

    fun findMedian(nums: IntArray, start: Int, end: Int): Double {

        // Max heap stores smaller half
        val left = PriorityQueue<Int>(compareByDescending { it })

        // Min heap stores larger half
        val right = PriorityQueue<Int>()

        // Add every number from current window
        for (i in start..end) {
            left.add(nums[i])
            right.add(left.poll())

            // Balance both heaps
            if (left.size < right.size) {
                left.add(right.poll())
            }
        }

        // Return middle value for odd window
        if (left.size > right.size) {
            return left.peek().toDouble()
        }

        // Convert before addition to avoid Int overflow
        return (left.peek().toDouble() + right.peek().toDouble()) / 2.0
    }
}