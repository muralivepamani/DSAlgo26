package reversallinkedlist

import fastslowpointers.ListNode

class `Reverse Linked List` {
    fun reverseLinkedList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current = head

        while (current != null) {
            val nextTemp = current.next
            current.next = prev
            prev = current
            current = nextTemp
        }
        return prev
    }
}