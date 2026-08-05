package fastslowpointers

class `Middle of the Linked List` {
    fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        // Move fast twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // When fast reaches the end, slow is at the middle node
        return slow
    }
}