package backtracking

class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val cur = mutableListOf<Int>()
        fun dfs() {
            if (cur.size == nums.size) {
                res.add(cur.toList())
                return
            }

            for (num in nums) {
                if (cur.contains(num))
                    continue
                cur.add(num)
                dfs()
                cur.removeAt(cur.lastIndex)
            }


        }
        dfs()
        return res

    }
}