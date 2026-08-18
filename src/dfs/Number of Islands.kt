package dfs

class `Number of Islands` {

    fun numIslands(grid: Array<CharArray>): Int {
        var islands = 0

        for (i in grid.indices) {
            for (j in grid[0].indices) {

                // Found a new island: count it once and explore the entire island.
                if (grid[i][j] == '1') {
                    islands++

                    // DFS using an explicit Stack.
                    usingStack(i, j, grid)

                    // Or use recursive DFS:
                    // usingDFS(i, j, grid)
                }
            }
        }

        return islands
    }

    fun usingStack(i: Int, j: Int, grid: Array<CharArray>) {

        // 4 directions: down, up, right, left.
        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        // Stack = LIFO -> Iterative DFS.
        val stack = ArrayDeque<Pair<Int, Int>>()
        stack.addLast(i to j)

        // Mark as visited immediately to avoid adding the same cell again.
        grid[i][j] = '0'

        while (stack.isNotEmpty()) {

            // Pop the current cell from the Stack.
            val (row, col) = stack.removeLast()

            for (dir in directions) {
                val newRow = row + dir[0]
                val newCol = col + dir[1]

                // Visit only valid, unvisited land cells.
                if (
                    newRow in grid.indices &&
                    newCol in grid[0].indices &&
                    grid[newRow][newCol] == '1'
                ) {
                    // Mark visited before pushing to prevent duplicates.
                    grid[newRow][newCol] = '0'

                    // Push neighbor -> DFS continues from this cell.
                    stack.addLast(newRow to newCol)
                }
            }
        }
    }

    fun usingDFS(row: Int, col: Int, grid: Array<CharArray>) {

        // Base case:
        // Stop if outside grid or current cell is not unvisited land.
        if (
            row !in grid.indices ||
            col !in grid[0].indices ||
            grid[row][col] != '1'
        ) {
            return
        }

        // Mark current cell as visited.
        grid[row][col] = '0'

        // Explore all 4 connected directions.
        usingDFS(row + 1, col, grid)
        usingDFS(row - 1, col, grid)
        usingDFS(row, col + 1, grid)
        usingDFS(row, col - 1, grid)
    }
}

/*
Remember:

Number of Islands
-----------------
Find '1'
    ↓
islands++
    ↓
DFS/BFS entire connected island
    ↓
Mark visited cells as '0'
    ↓
Continue scanning

DFS:
- Recursive DFS -> Function call stack
- Iterative DFS -> Explicit Stack
- Stack -> LIFO -> removeLast()

BFS:
- Queue
- FIFO -> removeFirst()

Complexity:
Time  = O(R * C)
Space = O(R * C) worst case

Key rule:
Count the island BEFORE DFS/BFS,
then explore and mark the whole island.
*/