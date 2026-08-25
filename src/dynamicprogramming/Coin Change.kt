package dynamicprogramming

class `Coin Change` {

    fun minCoins(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) {
            Int.MAX_VALUE
        }
        // Base case: 0 coins are needed to make amount 0
        dp[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                // Check if the coin can be used
                // and the remaining amount is reachable
                if (coin <= i && dp[i - coin] != Int.MAX_VALUE) {
                    dp[i] = minOf(
                        dp[i],
                        1 + dp[i - coin]
                    )
                }
            }
        }
        return if (dp[amount] == Int.MAX_VALUE) -1 else dp[amount]

    }
}