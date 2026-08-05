package `prefixsum `

class `Range Sum Query`(nums: IntArray) {

    // prefix[i] stores the sum of nums[0] up to nums[i-1]
    private val prefix = IntArray(nums.size + 1)

    init {
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return prefix[right + 1] - prefix[left]
    }
}