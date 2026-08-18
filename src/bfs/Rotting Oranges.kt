package bfs

class `Rotting Oranges` {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var minutes = 0
        var fresh = 0
        val dq = ArrayDeque<Pair<Int, Int>>()

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                val cur = grid[i][j]
                if (cur == 2) {
                    dq.add(Pair(i, j))
                } else if (cur == 1) {
                    fresh++
                }
            }
        }
        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)

        )
        while (dq.isNotEmpty() && fresh > 0) {

            repeat(dq.size) {
                val (row, col) = dq.removeFirst()
                for (dir in directions) {
                    val newRow = row + dir[0]
                    val newCol = col + dir[1]
                    if (newRow in grid.indices && newCol in grid[0].indices && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2
                        fresh--
                        dq.add(Pair(newRow, newCol))
                    }
                }
            }
            minutes++
        }

        return if (fresh == 0) minutes else -1

    }
}