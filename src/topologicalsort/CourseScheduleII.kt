package topologicalsort

class CourseScheduleII {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {

        val graph = Array(numCourses) {
            mutableListOf<Int>()
        }
        val inDegree = IntArray(numCourses)
        for (preReq in prerequisites) {
            graph[preReq[1]].add(preReq[0])
            inDegree[preReq[0]]++
        }
        val queue = java.util.ArrayDeque<Int>()
        for (i in 0 until numCourses) {
            if (inDegree[i] == 0) {
                queue.addLast(i)
            }

        }
        val res = IntArray(numCourses)
        var count = 0
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            res[count] = cur
            count++
            for (next in graph[cur]) {
                inDegree[next]--
                if (inDegree[next] == 0) {
                    queue.addLast(next)
                }


            }

        }
        if (count == numCourses) return res else return intArrayOf()

    }
}