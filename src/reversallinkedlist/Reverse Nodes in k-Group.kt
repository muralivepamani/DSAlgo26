package reversallinkedlist

import fastslowpointers.ListNode

class `Reverse Nodes in k-Group` {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        // Base edge cases
        if (head == null || k == 1) return head

        // Create dummy node to safely handle head modifications
        val dummy = ListNode(0)
        dummy.next = head
        var groupPrev = dummy

        while (true) {
            // 1. Find the k-th node from groupPrev. If fewer than k nodes exist, stop!
            val kth = findKthNode(groupPrev, k) ?: break

            // `groupNext` is the first node after the current k-group
            val groupNext = kth.next

            // 2. Reverse the k nodes
            // Initialize `prev` to `groupNext` so the sublist automatically links to the remainder of the list
            var prev = groupNext
            var cur = groupPrev.next
            while (cur != groupNext) {
                val temp = cur?.next
                cur?.next = prev
                prev = cur
                cur = temp
            }

            // 3. Reconnect group boundaries:
            // `temp` holds the old start of the group (which is now the tail of the reversed group)
            val temp = groupPrev.next

            // Point the predecessor node (`groupPrev`) to the new reversed group head (`kth`)
            groupPrev.next = kth

            // Advance `groupPrev` to the tail of the newly reversed group for the next iteration
            groupPrev = temp!!
        }

        return dummy.next
    }

    // Helper to advance `k` steps forward. Returns null if fewer than k nodes remain.
    fun findKthNode(head: ListNode?, k: Int): ListNode? {
        var cur = head
        var count = k
        while (count > 0 && cur != null) {
            cur = cur.next // Fixed: Safe call prevents NullPointerException
            count--
        }
        return cur
    }
}