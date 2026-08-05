package `prefixsum `

class `Subarray Sum Equals K` {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixMap = HashMap<Int, Int>()
        // Base Case: A prefix sum of 0 exists once before processing any elements
        prefixMap[0] = 1

        var curSum = 0
        var count = 0

        for (num in nums) {
            curSum += num

            if (prefixMap.containsKey(curSum - k)) {
                count += prefixMap[curSum - k]!!
            }

            prefixMap[curSum] = prefixMap.getOrDefault(curSum, 0) + 1
        }

        return count
    }
}