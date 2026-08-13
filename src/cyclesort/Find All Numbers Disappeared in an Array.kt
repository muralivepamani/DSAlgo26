package cyclesort

class `Find All Numbers Disappeared in an Array` {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val n = nums.size
        val set = nums.toHashSet()
        val res = ArrayList<Int>()

        for (i in 1..n) {
            if (!set.contains(i)) {
                res.add(i)
            }
        }
        return res

    }

    fun findDisappearedNumbersCycleSort(nums: IntArray): List<Int> {
        var i = 0

        // Step 1: Place each number at its correct index (nums[i] belongs at index nums[i] - 1)
        while (i < nums.size) {
            val correctIdx = nums[i] - 1

            // Swap if the number is not at its correct position AND it's not a duplicate
            if (nums[i] != nums[correctIdx]) {
                val temp = nums[i]
                nums[i] = nums[correctIdx]
                nums[correctIdx] = temp
            } else {
                i++
            }
        }

        // Step 2: Find all indices where nums[i] != i + 1
        val res = ArrayList<Int>()
        for (index in nums.indices) {
            if (nums[index] != index + 1) {
                res.add(index + 1)
            }
        }

        return res
    }
}