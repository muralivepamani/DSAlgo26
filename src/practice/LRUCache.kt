package practice

class LRUCache(private val capacity: Int) {

    private val cache = HashMap<Int, Node>()

    val head = Node(0, 0)
    val tail = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {

        val node = cache[key] ?: return -1

        // Node was recently used,
        // so move it to the end.
        remove(node)
        addToEnd(node)

        return node.value
    }

    fun put(key: Int, value: Int) {

        // If key already exists,
        // remove the old node.
        if (cache.containsKey(key)) {
            remove(cache[key]!!)
        }

        val node = Node(key, value)

        cache[key] = node

        // New node becomes most recently used.
        addToEnd(node)

        if (cache.size > capacity) {

            // Head.next is the least recently used node.
            val lru = head.next!!

            remove(lru)

            cache.remove(lru.key)
        }
    }

    fun remove(node: Node) {

        // H <-> A <-> B <-> C <-> T
        // Remove B
        //
        // A.next = B.next
        // C.prev = B.prev

        val prev = node.prev!!
        val next = node.next!!

        prev.next = next
        next.prev = prev
    }

    fun addToEnd(node: Node) {

        // H <-> A <-> B <-> T
        // Add C at the end
        //
        // H <-> A <-> B <-> C <-> T

        // B = T.prev
        val prev = tail.prev!!

        // B.next = C
        prev.next = node

        // C.prev = B
        node.prev = prev

        // C.next = T
        node.next = tail

        // T.prev = C
        tail.prev = node
    }
}

class Node(
    val key: Int,
    val value: Int
) {
    var prev: Node? = null
    var next: Node? = null
}