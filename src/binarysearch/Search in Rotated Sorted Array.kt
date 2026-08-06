package binarysearch

class `Search in Rotated Sorted Array` {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (nums[mid] == target) return mid

            // 1. Check if the LEFT side is sorted
            if (nums[left] <= nums[mid]) {
                // Check if target lies within the sorted left range [nums[left] .. nums[mid]]
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1 // Move search space to left half
                } else {
                    left = mid + 1  // Move search space to right half
                }
            }
            // 2. Otherwise, the RIGHT side must be sorted
            else {
                // Check if target lies within the sorted right range [nums[mid] .. nums[right]]
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1  // Move search space to right half
                } else {
                    right = mid - 1 // Move search space to left half
                }
            }
        }

        return -1
    }
}