package companies.barclay

class IncremovableSubarrayCount {

    fun incremovableSubarrayCount(nums: IntArray): Long {
        val n = nums.size
        var count = 0

        for (i in 0 until n) {
            for (j in i until n) {
                val list = ArrayList<Int>()
                for (k in 0 until n) {
                    if (k < i || k > j) {
                        list.add(nums[k])
                    }
                }
                if (increasing(list)) {
                    count++
                }
            }
        }
        return count.toLong()
    }

    private fun increasing(list: List<Int>): Boolean {
        for (i in 0 until list.size - 1) {
            if (list[i + 1] <= list[i]) {
                return false
            }
        }
        return true
    }

}