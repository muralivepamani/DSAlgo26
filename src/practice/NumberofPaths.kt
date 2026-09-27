package practice

fun numOfPathsToDest(n: Int): Int {

    // Create an n x n matrix.
    //
    // arr[i][j] stores the number of valid paths
    // from (0,0) to position (i,j).
    //
    // Initially -1 means:
    // "This position has not been calculated yet."
    val arr = Array(n) {
        IntArray(n) {
            -1
        }
    }

    // Start DFS from the destination.
    return DFS(n - 1, n - 1, arr)
}


fun DFS(
    i: Int,
    j: Int,
    arr: Array<IntArray>
): Int {

    // If we move outside the matrix,
    // there are no valid paths.
    if (i < 0 || j < 0) {
        return 0
    }

    // We cannot cross the diagonal.
    //
    // Example:
    //
    //     (0,0) (0,1) (0,2)
    //     (1,0) (1,1) (1,2)
    //     (2,0) (2,1) (2,2)
    //
    // Positions where i < j are above the diagonal
    // and are not allowed.
    //
    // Example: (0,1), (0,2), (1,2)
    else if (i < j) {
        arr[i][j] = 0
    }

    // If we already calculated this position,
    // return the stored result instead of calculating again.
    //
    // This is the "memoization" part.
    else if (arr[i][j] != -1) {
        return arr[i][j]
    }

    // Base case.
    //
    // There is exactly ONE way to reach (0,0):
    // we are already there.
    else if (i == 0 && j == 0) {
        arr[i][j] = 1
    }

    // Calculate the number of paths.
    //
    // DFS(i - 1, j)
    //     Move UP
    //
    // DFS(i, j - 1)
    //     Move LEFT
    //
    // Total paths = paths from UP + paths from LEFT
    else {
        arr[i][j] =
            DFS(i - 1, j, arr) +
                    DFS(i, j - 1, arr)
    }

    // Return the calculated/stored number of paths.
    return arr[i][j]
}