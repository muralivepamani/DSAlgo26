package common

import fastslowpointers.ListNode

fun printLinkedList(head: ListNode?) {
    var curr = head
    val values = mutableListOf<Int>()
    while (curr != null) {
        values.add(curr.`val`)
        curr = curr.next
    }
    println(values.joinToString(" -> "))
}
