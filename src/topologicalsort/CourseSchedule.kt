package topologicalsort

class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = Array(numCourses) {
            mutableListOf<Int>()
        }
        val inDegree = IntArray(numCourses)

        for (preReq in prerequisites) {
            graph[preReq[1]].add(preReq[0])
            inDegree[preReq[0]]++
        }
        val queue = ArrayDeque<Int>()
        for (i in 0 until numCourses) {
            if (inDegree[i] == 0) {
                queue.addLast(i)
            }
        }
        var processed = 0
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            processed++

            for (next in graph[cur]) {
                inDegree[next]--
                if (inDegree[next] == 0) {
                    queue.addLast(next)
                }
            }
        }
        return processed == numCourses
    }
}