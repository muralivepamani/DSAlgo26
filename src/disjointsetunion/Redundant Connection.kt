package disjointsetunion


class `Redundant Connection` {

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size

        // Initialize each node as its own parent
        val parent = IntArray(n + 1) { it }

        // Find the root parent with path compression
        fun find(x: Int): Int {
            if (parent[x] != x) {
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]

            // Find the root parent of both nodes
            val rootU = find(u)
            val rootV = find(v)

            // If both nodes already have the same root, this edge creates a cycle
            if (rootU == rootV) return edge

            // Connect the two components
            parent[rootU] = rootV
        }

        return intArrayOf()
    }
}