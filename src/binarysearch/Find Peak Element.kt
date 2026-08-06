package binarysearch

class `Find Peak Element` {
    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        while (left < right) {
            val mid = left + (right - left) / 2

            if (nums[mid] < nums[mid + 1]) {
                // Peak lies in the right half
                left = mid + 1
            } else {
                // Peak lies in the left half (including mid)
                right = mid
            }
        }

        // left and right meet at the peak index
        return left
    }
}