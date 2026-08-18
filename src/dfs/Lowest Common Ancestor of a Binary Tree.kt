package dfs

import bfs.TreeNode

class `Lowest Common Ancestor of a Binary Tree`

fun lowestCommonAncestor(
    root: TreeNode?,
    p: TreeNode?,
    q: TreeNode?
): TreeNode? {

    return DFS(root, p, q)
}

private fun DFS(
    root: TreeNode?,
    p: TreeNode?,
    q: TreeNode?
): TreeNode? {

    // Nothing found in this subtree
    if (root == null) return null

    // Found p or q
    if (root == p || root == q) {
        return root
    }

    // Search both subtrees
    val left = DFS(root.left, p, q)
    val right = DFS(root.right, p, q)

    // p and q are in different subtrees.
    //Therefore, current node is their LCA.
    if (left != null && right != null) {
        return root
    }

    // Only one side contains p or q.
    return left ?: right
}