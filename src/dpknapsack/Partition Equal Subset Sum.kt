package dpknapsack

class `Partition Equal Subset Sum` {
    fun canPartition(nums: IntArray): Boolean {
        var sum = 0
        for (num in nums) {
            sum += num
        }
        if (sum % 2 != 0) return false
        val target = sum / 2
        val dp = BooleanArray(target + 1)

        for (num in nums) {
            for (i in target downTo num) {
                dp[i] = dp[i] || dp[i - num]
            }
        }
        return dp[target]
    }
}