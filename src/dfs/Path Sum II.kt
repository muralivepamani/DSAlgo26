package dfs

import bfs.TreeNode

class `Path Sum II` {

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {

        // Stores all valid root-to-leaf paths.
        // Example: [[5, 4, 11, 2], [5, 8, 4, 5]]
        val res = mutableListOf<List<Int>>()

        // Stores the current path while traversing the tree.
        val path = mutableListOf<Int>()

        // Start DFS from the root.
        DFS(root, targetSum, res, path)

        return res
    }

    private fun DFS(
        root: TreeNode?,
        targetSum: Int,
        res: MutableList<List<Int>>,
        path: MutableList<Int>
    ) {

        // Base case:
        // Stop when there is no node.
        if (root == null) return

        // Add current node to the current path.
        path.add(root.`val`)

        // Check only at a LEAF node.
        // targetSum is the remaining sum after previous nodes.
        if (
            root.left == null &&
            root.right == null &&
            targetSum == root.`val`
        ) {
            // toList() creates a copy of the current path.
            res.add(path.toList())
        }

        // Explore left subtree with reduced target.
        DFS(
            root.left,
            targetSum - root.`val`,
            res,
            path
        )

        // Explore right subtree with reduced target.
        DFS(
            root.right,
            targetSum - root.`val`,
            res,
            path
        )

        // BACKTRACK:
        // Remove current node before returning to the parent.
        path.removeAt(path.lastIndex)
    }
}

/*
Remember the DFS + Backtracking pattern:

        Add node
            ↓
        Check leaf
            ↓
        DFS left
            ↓
        DFS right
            ↓
        Remove node
            ↓
        Backtrack

Example:

        5
       / \
      4   8
     /   / \
    11  13  4

Path while DFS:
[5]
[5, 4]
[5, 4, 11]
[5, 4, 11, 7]

After finishing 7:
[5, 4, 11]  ← backtrack

Then try:
[5, 4, 11, 2]

Important:
- path = current path
- res = all valid paths
- targetSum = remaining sum
- Add before DFS
- Remove after DFS
- Only save path at a leaf
- Use path.toList() because path is mutable

Complexity:
Time  = O(N) for traversal, plus copying valid paths
Space = O(H) recursion/path space, excluding result
*/