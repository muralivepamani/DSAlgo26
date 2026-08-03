package twopointers

class ThreeSum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        // Sort the array to enable two-pointer traversal and duplicate checking
        nums.sort()

        // Iterate through each potential first element of the triplet
        for (i in 0 until nums.size - 2) {
            // Stop early if the smallest available number is positive
            if (nums[i] > 0) break

            // Skip identical pivot values to avoid duplicate triplets in the output
            if (i > 0 && nums[i] == nums[i - 1]) continue

            // Set two pointers for the remaining sub-array
            var left = i + 1
            var right = nums.size - 1

            // Shrink search window until pointers meet
            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]

                if (sum == 0) {
                    // Save valid triplet to results
                    res.add(listOf(nums[i], nums[left], nums[right]))

                    // Advance pointers to search for next potential pair
                    left++
                    right--

                    // Skip duplicate values on the left pointer
                    while (left < right && nums[left] == nums[left - 1]) left++

                    // Skip duplicate values on the right pointer
                    while (left < right && nums[right] == nums[right + 1]) right--
                } else if (sum < 0) {
                    // Sum is too small, move left pointer right to increase sum
                    left++
                } else {
                    // Sum is too large, move right pointer left to decrease sum
                    right--
                }
            }
        }

        // Return all unique triplets that sum to zero
        return res
    }
}