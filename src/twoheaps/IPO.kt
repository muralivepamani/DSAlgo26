package twoheaps

import java.util.PriorityQueue

class IPO {

    fun findMaximizedCapital(
        k: Int,
        w: Int,
        profits: IntArray,
        capital: IntArray
    ): Int {

        // Store projects as capital and profit
        val projects = profits.indices
            .map { Pair(capital[it], profits[it]) }
            .sortedBy { it.first }

        // Max heap stores profits
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })

        var money = w
        var index = 0

        // Choose at most k projects
        repeat(k) {

            // Add all affordable projects
            while (index < projects.size &&
                projects[index].first <= money
            ) {
                maxHeap.offer(projects[index].second)
                index++
            }

            // Stop if no project is affordable
            if (maxHeap.isEmpty()) {
                return money
            }

            // Choose highest profit
            money += maxHeap.poll()
        }

        return money
    }
}