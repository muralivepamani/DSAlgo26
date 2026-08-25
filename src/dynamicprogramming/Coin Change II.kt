package dynamicprogramming

class `Coin Change II`
class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        // dp[i] = number of combinations to make amount i
        val dp = IntArray(amount + 1)
        // One way to make amount 0: choose no coins
        dp[0] = 1
        for (coin in coins) {
            for (i in coin..amount) {
                dp[i] += dp[i - coin]
            }
        }
        return dp[amount]
    }
}