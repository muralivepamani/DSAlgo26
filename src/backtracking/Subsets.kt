package backtracking

class Subsets {

    fun subsets(nums: IntArray): List<List<Int>> {

        // Stores all the subsets we generate
        val res = mutableListOf<List<Int>>()

        // Stores the subset we are currently building
        val cur = mutableListOf<Int>()

        // index tells us where to start looking for the next element
        fun dfs(index: Int) {

            // Every state of 'cur' is a valid subset
            // toList() creates a copy because cur is mutable
            res.add(cur.toList())

            // Try every element from 'index' until the end
            for (i in index until nums.size) {

                // Choose the current element
                cur.add(nums[i])

                // Explore further with the next index
                // i + 1 prevents using the same element again
                dfs(i + 1)

                // Backtrack:
                // Remove the last chosen element
                // so we can try the next possibility
                cur.removeAt(cur.lastIndex)
            }
        }

        // Start DFS from index 0
        dfs(0)

        // Return all generated subsets
        return res
    }
}

/**| Problem              |                Time |  Space* | Why                                      |
| -------------------- | ------------------: | ------: | ---------------------------------------- |
| **78. Subsets**      |         `O(n × 2ⁿ)` |  `O(n)` | `2ⁿ` subsets, each copied up to `n`      |
| **46. Permutations** |         `O(n × n!)` |  `O(n)` | `n!` permutations, each copied up to `n` |
| **51. N-Queens**     | `O(n × n!)` approx. | `O(n²)` | Backtracking + board + sets              |*/
