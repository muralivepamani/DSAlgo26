package dynamicprogramming

class `Combination Sum IV` {
    fun combinationSum4(target: Int, nums: IntArray): Int {
        val dp = IntArray(target + 1)
        dp[0] = 1
        for (curTaregt in 1..target) {
            for (num in nums) {
                if (num <= curTaregt)
                    dp[curTaregt] += dp[curTaregt - num]
            }
        }
        return dp[target]
    }
}