import fastslowpointers.ListNode
import fastslowpointers.`Middle of the Linked List`

fun main() {
    // 1. Create nodes
    val node0 = ListNode(1)
    val node1 = ListNode(2)
    val node2 = ListNode(3)
    val node3 = ListNode(4)
    val node4 = ListNode(5)

    // 2. Link them sequentially: 1 -> 2 -> 3 -> 4 -> 5
    node0.next = node1
    node1.next = node2
    node2.next = node3
    node3.next = node4

    val head = node0

    // 3. Test middleNode function
    val solution = `Middle of the Linked List`()
    val result = solution.middleNode(head)

    // 4. Print the value of the middle node
    println("Middle Node Value: ${result?.`val`}") // Output: 3
}