package backtracking

class `N Queens` {

    fun queens(n: Int): List<List<String>> {

        val res = mutableListOf<List<String>>()

        val board = Array(n) {
            CharArray(n) { '.' }
        }

        val cols = HashSet<Int>()
        val posDiag = HashSet<Int>()
        val negDiag = HashSet<Int>()

        fun dfs(row: Int) {

            // We successfully placed a queen in every row
            if (row == n) {
                res.add(
                    board.map { it.concatToString() }
                )
                return
            }

            // Try every column in this row
            for (col in 0 until n) {

                // Check whether this position is safe
                if (col in cols ||
                    row + col in posDiag ||
                    row - col in negDiag
                ) {
                    continue
                }

                // Place queen
                board[row][col] = 'Q'

                // Mark position as occupied
                cols.add(col)
                posDiag.add(row + col)
                negDiag.add(row - col)

                // Move to next row
                dfs(row + 1)

                // Remove queen
                board[row][col] = '.'

                // Remove occupied markers
                cols.remove(col)
                posDiag.remove(row + col)
                negDiag.remove(row - col)
            }
        }

        dfs(0)

        return res
    }
}