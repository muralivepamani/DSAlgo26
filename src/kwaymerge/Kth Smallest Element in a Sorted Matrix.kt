package kwaymerge

class `Kth Smallest Element in a Sorted Matrix` {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val maxHeap = java.util.PriorityQueue<Int>(reverseOrder())
        val nums = matrix.flatMap { it.toList() }.toIntArray()
        for (num in nums) {
            maxHeap.add(num)
            if (maxHeap.size > k) {
                maxHeap.poll()
            }
        }
        return maxHeap.peek()

    }
    //Time:O(n log(K)) Space:O(k)+o(n)=O(n)
}