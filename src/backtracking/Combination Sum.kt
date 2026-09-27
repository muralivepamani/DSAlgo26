package backtracking

class `Combination Sum` {

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val cur = mutableListOf<Int>()

        fun backTracking(start: Int, remaining: Int) {
            if (remaining == 0) {
                res.add(cur)
                return
            }

            for (i in start until candidates.size) {
                if (candidates[i] > remaining) {
                    continue
                }
                cur.add(candidates[i])
                backTracking(i, target - candidates[i])
                cur.removeAt(cur.lastIndex)
            }


        }
        backTracking(0, target)
        return res


    }
}