package companies.ibm

class IBM {

    // Problem 1: Count Balanced Numbers
    fun countBalancedNumbers(p: Array<Int>): String {
        val n = p.size
        val result = CharArray(n) { '0' }
        val pos = IntArray(n + 1)

        // Store positions of numbers
        for (i in p.indices) {
            pos[p[i]] = i
        }

        var left = pos[1]
        var right = pos[1]

        result[0] = '1'

        // Check each number from 2 to n
        for (k in 2..n) {
            val index = pos[k]

            if (index < left) left = index
            if (index > right) right = index

            if (right - left + 1 == k) {
                result[k - 1] = '1'
            }
        }

        return String(result)
    }

    // Problem 2: Get Stale Server Count
    fun getStaleServerCount(
        n: Int,
        log_data: Array<Array<Int>>,
        query: Array<Int>,
        X: Int
    ): Array<Int> {

        val result = ArrayList<Int>()

        for (q in query) {
            val activeServers = HashSet<Int>()

            val startTime = q - X

            for (log in log_data) {
                val serverId = log[0]
                val time = log[1]

                if (time in startTime..q) {
                    activeServers.add(serverId)
                }
            }

            result.add(n - activeServers.size)
        }

        return result.toTypedArray()
    }
}
