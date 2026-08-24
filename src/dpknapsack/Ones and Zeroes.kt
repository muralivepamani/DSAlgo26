package dpknapsack

class `Ones and Zeroes` {

    fun findMaxForm(
        strs: Array<String>,
        m: Int,
        n: Int
    ): Int {

        // dp[i][j] = maximum number of strings
        // we can select using at most:
        // i zeros and j ones
        val dp = Array(m + 1) {
            IntArray(n + 1)
        }

        // Process each string
        for (str in strs) {

            // Count zeros in current string
            val zeros = str.count { it == '0' }

            // Count ones in current string
            val ones = str.length - zeros

            // Go backwards so that we use
            // each string only once
            for (i in m downTo zeros) {
                for (j in n downTo ones) {

                    // Don't take current string:
                    // dp[i][j]
                    //
                    // Take current string:
                    // 1 + dp[i - zeros][j - ones]
                    dp[i][j] = maxOf(
                        dp[i][j],
                        1 + dp[i - zeros][j - ones]
                    )
                }
            }
        }

        return dp[m][n]
    }
}