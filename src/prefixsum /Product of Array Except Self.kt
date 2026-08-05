package `prefixsum `

class `Product of Array Except Self` {
    fun productExceptSelf(nums: IntArray): IntArray {
        var leftProduct = 1
        val n = nums.size
        val res = IntArray(n)

        // Pass 1: Collect prefix products
        for (i in 0 until n) {
            res[i] = leftProduct
            leftProduct *= nums[i]
        }

        // Pass 2: Multiply by running suffix products
        var rightProduct = 1
        for (i in n - 1 downTo 0) {
            res[i] *= rightProduct
            rightProduct *= nums[i]
        }

        return res
    }
}