package practice

class `Minimum Cost For Tickets` {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val n = days.size
        val dp = IntArray(n + 1)

        for (i in n - 1 downTo 0) {

            var j = i

            while (j < n && days[j] < days[i] + 1) {
                j++
            }
            val oneDay = costs[0] + dp[j]
            j = i
            while (j < n && days[j] < days[i] + 7) {
                j++
            }
            val sevenDay = costs[1] + dp[j]
            j = i
            while (j < n && days[j] < days[i] + 30) {
                j++
            }
            val thirtyDay = costs[2] + dp[j]
            dp[i] = minOf(oneDay, sevenDay, thirtyDay)
        }
        return dp[0]
    }
}