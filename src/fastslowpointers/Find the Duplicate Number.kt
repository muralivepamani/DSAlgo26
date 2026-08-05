package fastslowpointers

class `Find the Duplicate Number` {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[0]

        // Phase 1: Find collision point inside the cycle
        do {
            slow = nums[slow]          // Move 1 step
            fast = nums[nums[fast]]    // Move 2 steps
        } while (slow != fast)

        // Phase 2: Find the entry point of the cycle (the duplicate number)
        var entry = nums[0]
        while (entry != slow) {
            entry = nums[entry] // Move 1 step from head
            slow = nums[slow]   // Move 1 step from intersection
        }

        return entry // Cycle entry is the duplicate value
    }
}