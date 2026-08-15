package kwaymerge

class `Kth Largest Element in an Array` {

    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = java.util.PriorityQueue<Int>()
        for (num in nums) {
            minHeap.add(num)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }
        return minHeap.peek()

    }

    //Time Complexity: O(n log k)
    //Space Complexity: O(k)
}