package cyclesort

class `First Missing Positive` {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        var i = 0

        // Step 1: Place each valid positive number x (where 1 <= x <= n) at index x - 1
        while (i < n) {
            val correctIdx = nums[i] - 1

            // Only swap if:
            // 1. nums[i] is in the valid positive range [1, n]
            // 2. nums[i] is not already at its correct index (handles duplicates)
            if (nums[i] in 1..n && nums[i] != nums[correctIdx]) {
                val temp = nums[i]
                nums[i] = nums[correctIdx]
                nums[correctIdx] = temp
            } else {
                i++
            }
        }

        // Step 2: Find the first index where the number doesn't match index + 1
        for (index in 0 until n) {
            if (nums[index] != index + 1) {
                return index + 1
            }
        }

        // Step 3: If 1..n are all present, the missing positive is n + 1
        return n + 1
    }
}