package fastslowpointers

// 1. Change 'val next' to 'var next' so pointers can be modified
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class LinkedListCycle {
    // 2. Accept a nullable ListNode? to support empty lists
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        // 3. Only fast needs to be checked; if fast doesn't hit null, slow won't either
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) return true
        }

        return false
    }
}