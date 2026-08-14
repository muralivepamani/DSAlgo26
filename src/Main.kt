import common.printLinkedList
import fastslowpointers.ListNode
import reversallinkedlist.`Reverse Linked List`
import reversallinkedlist.`Reverse Linked List II`
import reversallinkedlist.`Reverse Nodes in k-Group`
import stackqueue.`Daily Temperatures`
import stackqueue.`Largest Rectangle in Histogram`
import stackqueue.`Next Greater Element I`

// Helper function to print linked list nodes in "1 -> 2 -> 3" format


fun main() {

        val solution = `Largest Rectangle in Histogram`()
        val input=intArrayOf(2,1,5,6,2,3)
        println(input.joinToString())
        val result = solution.largestRectangleArea(input)

        // Prints the result array: [1, 1, 4, 2, 1, 1, 0, 0]
        println(result)

}