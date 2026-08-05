package fastslowpointers

class `Linked List Cycle II` {
    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head

        // Phase 1: Detect if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                // Phase 2: Find cycle start
                var entry = head
                while (entry != slow) {
                    entry = entry?.next
                    slow = slow?.next
                }
                return entry // Both pointers now point to the cycle entry node
            }
        }

        return null // No cycle found
    }
}