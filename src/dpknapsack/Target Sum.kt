package dpknapsack

/**
 * Time: O(n × sum)
 * Space: O(sum)
 * */
class `Target Sum` {
    fun ways(nums: IntArray, target: Int): Int {
        var dp = HashMap<Int, Int>()
        dp[0] = 1

        for (num in nums) {
            val nextDp = HashMap<Int, Int>()

            for ((sum, count) in dp.entries) {

                val nextPlus = sum + num
                nextDp[nextPlus] = (nextDp[nextPlus] ?: 0) + count
                val nextMinus = sum - num
                nextDp[nextMinus] = (nextDp[nextMinus] ?: 0) + count
            }
            dp = nextDp
        }
        return dp[target] ?: 0
    }
}