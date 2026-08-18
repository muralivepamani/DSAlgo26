package bfs

class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
     }
class `Binary Tree Level Order Traversal` {
    fun levelOrder(root: TreeNode):List<List<Int>>{
        val res=mutableListOf<List<Int>>()
        val dq= ArrayDeque<TreeNode>()
        dq.add(root)
        while (dq.isNotEmpty()){
            val level=mutableListOf<Int>()
            repeat(dq.size){
                val node=dq.removeFirst()
                level.add(node.`val`)
                node.left?.let { dq.add(it) }
                node.right?.let { dq.add(it) }
            }
            res.add(level)
        }

        return res


    }
}