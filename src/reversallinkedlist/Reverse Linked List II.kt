package reversallinkedlist

import fastslowpointers.ListNode

class `Reverse Linked List II` {

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null || left == right) return head

        val dummy = ListNode(0)
        dummy.next = head

        // Step 1: Reach position (left - 1) and position (left)
        var leftPreNode = dummy
        var curNode = head
        for (i in 0 until left - 1) {
            leftPreNode = leftPreNode.next!!
            curNode = curNode?.next
        }

        // Save reference to the node at position `left`
        // (This node becomes the tail of the reversed sublist)
        val subListHead = curNode

        // Step 2: Reverse standard sublist from `left` to `right`
        var prev: ListNode? = null
        var cur = curNode
        for (i in 0 until (right - left + 1)) {
            val nextTemp = cur?.next
            cur?.next = prev
            prev = cur
            cur = nextTemp
        }

        // Step 3: Reconnect the reversed sublist back into the main list
        leftPreNode.next = prev  // Connect node before `left` to new sublist head
        subListHead?.next = cur  // Connect old sublist head (now tail) to remaining nodes

        return dummy.next
    }
}