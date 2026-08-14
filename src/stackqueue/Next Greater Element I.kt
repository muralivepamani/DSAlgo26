package stackqueue

import java.util.ArrayDeque

class `Next Greater Element I` {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val map = HashMap<Int, Int>()
        val stack = ArrayDeque<Int>()

        // Phase 1: Precompute next greater elements for all numbers in nums2
        for (num in nums2) {
            // While the current number is bigger than what's at top of stack,
            // current number IS the "next greater element" for that top number.
            while (stack.isNotEmpty() && stack.peek() < num) {
                map[stack.pop()] = num
            }
            stack.push(num)
        }

        // Phase 2: Build answer for nums1 using O(1) hash map lookups
        val res = IntArray(nums1.size)
        for (i in nums1.indices) {
            res[i] = map.getOrDefault(nums1[i], -1)
        }

        return res
    }
}