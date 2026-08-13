package cyclesort

class `Missing Number` {
    fun missingNumber(nums: IntArray): Int {
        val max = nums.size
        val dummy = IntArray(max + 1) { -1 }
        for (num in nums) {
            dummy[num] = num
        }
        for (i in dummy.indices) {
            if (dummy[i] == -1) {
                return i
            }
        }
        return -1


    }


}