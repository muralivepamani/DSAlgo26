# Data Structures & Algorithms (DSA) Patterns Reference Guide

A comprehensive guide to the **18 core algorithmic patterns** used to solve Data Structures and Algorithms problems in technical interviews and competitive programming.

---

## 📌 Quick Pattern Selection Decision Tree

```
                                [Problem Statement]
                                         │
        ┌────────────────────────────────┴────────────────────────────────┐
        │                                                                 │
 [Array / Sequence]                                              [Tree / Graph / Set]
        │                                                                 │
 ┌──────┴──────────────────────────┐                       ┌──────────────┴─────────────┐
 │ Contiguous Subarray/Substring?   │                       │ Level-by-level processing? │
 │ ├── Yes ──> Sliding Window       │                       │ ├── Yes ──> BFS            │
 │ └── No                           │                       │ └── No                     │
 │     ├── Sorted Input?            │                       │     ├── Path / Tree Depth? │
 │     │   ├── Yes ──> Two Pointers │                       │     │   └── Yes ──> DFS    │
 │     │   └── No ──> Prefix Sum    │                       │     ├── Dependency Order?  │
 └─────────────────────────────────┘                       │     │   └── Yes ──> TopoSort │
                                                           │     └── Disjoint Sets?   │
                                                           │         └── Yes ──> DSU  │
                                                           └──────────────────────────┘
```

---

## 🗺️ Master Table of Contents & Cheat Sheet

| # | Pattern Name | Time Complexity | Space Complexity | Primary Data Structure | Common Use Case |
|---|---|---|---|---|---|
| 1 | **Two Pointers** | $O(N)$ | $O(1)$ | Array / Linked List | Sorted arrays, pair elements, in-place swaps |
| 2 | **Sliding Window** | $O(N)$ | $O(1)$ to $O(K)$ | Array / String / Hash Map | Contiguous subarrays, subsegment optimization |
| 3 | **Fast & Slow Pointers** | $O(N)$ | $O(1)$ | Linked List / Array | Cycle detection, finding middle element |
| 4 | **Prefix Sum** | $O(N)$ build, $O(1)$ query | $O(N)$ | Array | Range sum queries, sub-array sum counts |
| 5 | **Modified Binary Search** | $O(\log N)$ | $O(1)$ | Array | Searching in rotated/sorted arrays |
| 6 | **Cyclic Sort** | $O(N)$ | $O(1)$ | Array | Numbers in bounded range $1 \dots N$ |
| 7 | **In-place Reversal of Linked List** | $O(N)$ | $O(1)$ | Linked List | Reversing sub-lists without extra space |
| 8 | **Monotonic Stack / Queue** | $O(N)$ | $O(N)$ | Stack / Deque | Next greater element, histogram problems |
| 9 | **Two Heaps** | $O(\log N)$ insert | $O(N)$ | Min-Heap + Max-Heap | Dynamic median tracking, streaming data |
| 10 | **Top 'K' Elements** | $O(N \log K)$ | $O(K)$ | Priority Queue / Heap | Finding $K$ largest/smallest/frequent items |
| 11 | **K-Way Merge** | $O(N \log K)$ | $O(K)$ | Min-Heap | Merging $K$ sorted lists or arrays |
| 12 | **Breadth-First Search (BFS)** | $O(V + E)$ | $O(V)$ | Queue | Level-order traversal, shortest path (unweighted) |
| 13 | **Depth-First Search (DFS)** | $O(V + E)$ | $O(H)$ | Recursion / Stack | Tree paths, connected components, graph traversal |
| 14 | **Backtracking** | $O(2^N)$ or $O(N!)$ | $O(N)$ | Stack / Recursion | Permutations, combinations, Sudoku, N-Queens |
| 15 | **Topological Sort** | $O(V + E)$ | $O(V)$ | Queue / Hash Map | Course schedule, build systems, task ordering |
| 16 | **Disjoint Set Union (DSU)** | $O(lpha(N)) pprox O(1)$ | $O(N)$ | Array / Tree structure | Connected components, Kruskal's MST |
| 17 | **Dynamic Programming (0/1 Knapsack)**| $O(N \cdot W)$ | $O(N \cdot W)$ or $O(W)$ | Array / Matrix | Subset problems, capacity optimization |
| 18 | **Dynamic Programming (Unbounded)** | $O(N \cdot W)$ | $O(W)$ | Array | Coin change, rod cutting (infinite supply) |

---

## 1. Two Pointers

### Overview & When to Use
Use this pattern when dealing with **sorted arrays or lists** where you need to find a pair, set of elements, or swap items. Pointers move towards each other, or away, or iterate at different speeds.

### Pseudocode Template
```kotlin
fun twoPointersTemplate(arr: IntArray, target: Int): IntArray {
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        val currentSum = arr[left] + arr[right]
        if (currentSum == target) {
            return intArrayOf(left, right)
        } else if (currentSum < target) {
            left++ // Need a larger sum
        } else {
            right-- // Need a smaller sum
        }
    }
    return intArrayOf(-1, -1)
}
```

### Top LeetCode Problems
1. [Two Sum II - Input Array Is Sorted (LC #167)](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
2. [3Sum (LC #15)](https://leetcode.com/problems/3sum/)
3. [Container With Most Water (LC #11)](https://leetcode.com/problems/container-with-most-water/)

---

## 2. Sliding Window

### Overview & When to Use
Use when you need to track or optimize a **contiguous subarray or substring** satisfying a condition (e.g., maximum sum, longest substring with distinct characters).

### Pseudocode Template
```kotlin
fun slidingWindowTemplate(arr: IntArray, k: Int): Int {
    var windowSum = 0
    var maxSum = Int.MIN_VALUE
    var windowStart = 0

    for (windowEnd in arr.indices) {
        windowSum += arr[windowEnd] // Add next element

        // Shrink window if window condition met/exceeded
        if (windowEnd >= k - 1) {
            maxSum = maxOf(maxSum, windowSum)
            windowSum -= arr[windowStart] // Remove element exiting
            windowStart++ // Slide window
        }
    }
    return maxSum
}
```

### Top LeetCode Problems
1. [Maximum Average Subarray I (LC #643)](https://leetcode.com/problems/maximum-average-subarray-i/)
2. [Longest Substring Without Repeating Characters (LC #3)](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
3. [Minimum Size Subarray Sum (LC #209)](https://leetcode.com/problems/minimum-size-subarray-sum/)

---

## 3. Fast & Slow Pointers (Floyd's Cycle Detection)

### Overview & When to Use
Uses two pointers moving at different speeds (usually `slow` moves 1 step, `fast` moves 2 steps). Ideal for **cycle detection in lists/arrays** or finding the middle element.

### Pseudocode Template
```kotlin
class ListNode(var `val`: Int, var next: ListNode? = null)

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head

    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) return true // Cycle detected
    }
    return false
}
```

### Top LeetCode Problems
1. [Linked List Cycle (LC #141)](https://leetcode.com/problems/linked-list-cycle/)
2. [Middle of the Linked List (LC #876)](https://leetcode.com/problems/middle-of-the-linked-list/)
3. [Find the Duplicate Number (LC #287)](https://leetcode.com/problems/find-the-duplicate-number/)

---

## 4. Prefix Sum

### Overview & When to Use
Pre-computes cumulative sums of an array. Allows answering **range sum queries in $O(1)$ time** or finding subarrays with specific total sums.

### Pseudocode Template
```kotlin
fun buildPrefixSum(nums: IntArray): IntArray {
    val prefix = IntArray(nums.size + 1)
    for (i in nums.indices) {
        prefix[i + 1] = prefix[i] + nums[i]
    }
    return prefix
}

// Sum from index L to R inclusive: prefix[R + 1] - prefix[L]
```

### Top LeetCode Problems
1. [Range Sum Query - Immutable (LC #303)](https://leetcode.com/problems/range-sum-query-immutable/)
2. [Subarray Sum Equals K (LC #560)](https://leetcode.com/problems/subarray-sum-equals-k/)
3. [Product of Array Except Self (LC #238)](https://leetcode.com/problems/product-of-array-except-self/)

---

## 5. Modified Binary Search

### Overview & When to Use
Applies binary search concepts to non-standard or altered search spaces, such as **rotated sorted arrays, peak finding, or searching monotonic functions**.

### Pseudocode Template
```kotlin
fun binarySearch(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) return mid
        
        if (nums[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1
}
```

### Top LeetCode Problems
1. [Search in Rotated Sorted Array (LC #33)](https://leetcode.com/problems/search-in-rotated-sorted-array/)
2. [Find Peak Element (LC #162)](https://leetcode.com/problems/find-peak-element/)
3. [Koko Eating Bananas (LC #875)](https://leetcode.com/problems/koko-eating-bananas/)

---

## 6. Cyclic Sort

### Overview & When to Use
Sorts an array in $O(N)$ time and $O(1)$ auxiliary space when the input consists of numbers in a **known bounded range (e.g., $1$ to $N$ or $0$ to $N$)**.

### Pseudocode Template
```kotlin
fun cyclicSort(nums: IntArray) {
    var i = 0
    while (i < nums.size) {
        val correctIdx = nums[i] - 1 // If range is 1..N
        if (nums[i] in 1..nums.size && nums[i] != nums[correctIdx]) {
            // Swap element to its correct index
            val temp = nums[i]
            nums[i] = nums[correctIdx]
            nums[correctIdx] = temp
        } else {
            i++
        }
    }
}
```

### Top LeetCode Problems
1. [Missing Number (LC #268)](https://leetcode.com/problems/missing-number/)
2. [Find All Numbers Disappeared in an Array (LC #448)](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
3. [First Missing Positive (LC #41)](https://leetcode.com/problems/first-missing-positive/)

---

## 7. In-Place Reversal of Linked List

### Overview & When to Use
Reverses a linked list or sub-segment of a linked list in $O(1)$ extra space by mutating pointers.

### Pseudocode Template
```kotlin
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
```

### Top LeetCode Problems
1. [Reverse Linked List (LC #206)](https://leetcode.com/problems/reverse-linked-list/)
2. [Reverse Linked List II (LC #92)](https://leetcode.com/problems/reverse-linked-list-ii/)
3. [Reverse Nodes in k-Group (LC #25)](https://leetcode.com/problems/reverse-nodes-in-k-group/)

---

## 8. Monotonic Stack / Queue

### Overview & When to Use
Maintains elements in a stack in strictly increasing or decreasing order. Ideal for finding the **next greater element, previous smaller element, or boundary histogram areas**.

### Pseudocode Template
```kotlin
import java.util.ArrayDeque

fun nextGreaterElement(nums: IntArray): IntArray {
    val res = IntArray(nums.size) { -1 }
    val stack = ArrayDeque<Int>() // Stores indices

    for (i in nums.indices) {
        while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
            val idx = stack.pop()
            res[idx] = nums[i]
        }
        stack.push(i)
    }
    return res
}
```

### Top LeetCode Problems
1. [Next Greater Element I (LC #496)](https://leetcode.com/problems/next-greater-element-i/)
2. [Daily Temperatures (LC #739)](https://leetcode.com/problems/daily-temperatures/)
3. [Largest Rectangle in Histogram (LC #84)](https://leetcode.com/problems/largest-rectangle-in-histogram/)

---

## 9. Two Heaps

### Overview & When to Use
Maintains a **Max-Heap for the smaller half** and a **Min-Heap for the larger half** of a dataset to dynamically track properties like the median in $O(1)$ time.

### Pseudocode Template
```kotlin
import java.util.PriorityQueue

class MedianFinder() {
    private val maxHeap = PriorityQueue<Int>(compareByDescending { it }) // Lower half
    private val minHeap = PriorityQueue<Int>() // Upper half

    fun addNum(num: Int) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num)
        } else {
            minHeap.add(num)
        }

        // Rebalance heaps so size difference is at most 1
        if (maxHeap.size > minHeap.size + 1) {
            minHeap.add(maxHeap.poll())
        } else if (minHeap.size > maxHeap.size) {
            maxHeap.add(minHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size > minHeap.size) {
            maxHeap.peek().toDouble()
        } else {
            (maxHeap.peek() + minHeap.peek()) / 2.0
        }
    }
}
```

### Top LeetCode Problems
1. [Find Median from Data Stream (LC #295)](https://leetcode.com/problems/find-median-from-data-stream/)
2. [Sliding Window Median (LC #480)](https://leetcode.com/problems/sliding-window-median/)
3. [IPO (LC #502)](https://leetcode.com/problems/ipo/)

---

## 10. Top 'K' Elements

### Overview & When to Use
Uses a Heap (PriorityQueue) to find the $K$ smallest, largest, or most frequent elements in a collection without sorting the full dataset ($O(N \log K)$ vs $O(N \log N)$).

### Pseudocode Template
```kotlin
import java.util.PriorityQueue

fun findKthLargest(nums: IntArray, k: Int): Int {
    val minHeap = PriorityQueue<Int>() // Keeps top K largest
    for (num in nums) {
        minHeap.add(num)
        if (minHeap.size > k) {
            minHeap.poll()
        }
    }
    return minHeap.peek()
}
```

### Top LeetCode Problems
1. [Kth Largest Element in an Array (LC #215)](https://leetcode.com/problems/kth-largest-element-in-an-array/)
2. [Top K Frequent Elements (LC #347)](https://leetcode.com/problems/top-k-frequent-elements/)
3. [K Closest Points to Origin (LC #973)](https://leetcode.com/problems/k-closest-points-to-origin/)

---

## 11. K-Way Merge

### Overview & When to Use
Uses a Min-Heap to merge $K$ sorted inputs (arrays, matrices, or linked lists) into a single sorted output sequence.

### Pseudocode Template
```kotlin
import java.util.PriorityQueue

class Element(val valIdx: Int, val listIdx: Int, val elementIdx: Int)

fun mergeKSortedArrays(arrays: List<IntArray>): List<Int> {
    val minHeap = PriorityQueue<Element>(compareBy { it.valIdx })
    val result = mutableListOf<Int>()

    // Push first element of each list
    for (i in arrays.indices) {
        if (arrays[i].isNotEmpty()) {
            minHeap.add(Element(arrays[i][0], i, 0))
        }
    }

    while (minHeap.isNotEmpty()) {
        val curr = minHeap.poll()
        result.add(curr.valIdx)

        if (curr.elementIdx + 1 < arrays[curr.listIdx].size) {
            val nextVal = arrays[curr.listIdx][curr.elementIdx + 1]
            minHeap.add(Element(nextVal, curr.listIdx, curr.elementIdx + 1))
        }
    }
    return result
}
```

### Top LeetCode Problems
1. [Merge k Sorted Lists (LC #23)](https://leetcode.com/problems/merge-k-sorted-lists/)
2. [Kth Smallest Element in a Sorted Matrix (LC #378)](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)
3. [Find K Pairs with Smallest Sums (LC #373)](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/)

---

## 12. Breadth-First Search (BFS)

### Overview & When to Use
Explores trees or graphs **level by level** using a Queue. Ideal for shortest paths in unweighted graphs or level-order tree processing.

### Pseudocode Template
```kotlin
import java.util.ArrayDeque

class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (root == null) return result

    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val currentLevel = mutableListOf<Int>()

        for (i in 0 until levelSize) {
            val node = queue.poll()
            currentLevel.add(node.`val`)
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        result.add(currentLevel)
    }
    return result
}
```

### Top LeetCode Problems
1. [Binary Tree Level Order Traversal (LC #102)](https://leetcode.com/problems/binary-tree-level-order-traversal/)
2. [Rotting Oranges (LC #994)](https://leetcode.com/problems/rotting-oranges/)
3. [Word Ladder (LC #127)](https://leetcode.com/problems/word-ladder/)

---

## 13. Depth-First Search (DFS)

### Overview & When to Use
Explores tree/graph branches as deeply as possible before backtracking. Best for path finding, tree properties, and connected components.

### Pseudocode Template
```kotlin
fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false

    // Leaf node check
    if (root.left == null && root.right == null) {
        return root.`val` == targetSum
    }

    val remainingSum = targetSum - root.`val`
    return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum)
}
```

### Top LeetCode Problems
1. [Number of Islands (LC #200)](https://leetcode.com/problems/number-of-islands/)
2. [Path Sum II (LC #113)](https://leetcode.com/problems/path-sum-ii/)
3. [Lowest Common Ancestor of a Binary Tree (LC #236)](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

---

## 14. Backtracking

### Overview & When to Use
Systematically explores all choices to build a solution incrementally, **undoing choices (backtracking)** when constraints are violated.

### Pseudocode Template
```kotlin
fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    fun backtrack(currentList: MutableList<Int>) {
        if (currentList.size == nums.size) {
            result.add(ArrayList(currentList))
            return
        }
        for (num in nums) {
            if (currentList.contains(num)) continue
            currentList.add(num) // Choose
            backtrack(currentList) // Explore
            currentList.removeAt(currentList.size - 1) // Unchoose
        }
    }

    backtrack(mutableListOf())
    return result
}
```

### Top LeetCode Problems
1. [Subsets (LC #78)](https://leetcode.com/problems/subsets/)
2. [Permutations (LC #46)](https://leetcode.com/problems/permutations/)
3. [N-Queens (LC #51)](https://leetcode.com/problems/n-queens/)

---

## 15. Topological Sort

### Overview & When to Use
Orders nodes in a **Directed Acyclic Graph (DAG)** such that for every directed edge $U 	o V$, $U$ comes before $V$. Uses Kahn's Algorithm (BFS with In-degrees) or DFS.

### Pseudocode Template
```kotlin
import java.util.ArrayDeque

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val inDegree = IntArray(numCourses)
    val adjList = HashMap<Int, MutableList<Int>>()

    for (req in prerequisites) {
        val dest = req[0]
        val src = req[1]
        adjList.computeIfAbsent(src) { mutableListOf() }.add(dest)
        inDegree[dest]++
    }

    val queue = ArrayDeque<Int>()
    for (i in 0 until numCourses) {
        if (inDegree[i] == 0) queue.add(i)
    }

    var processed = 0
    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        processed++
        adjList[curr]?.forEach { neighbor ->
            inDegree[neighbor]--
            if (inDegree[neighbor] == 0) queue.add(neighbor)
        }
    }
    return processed == numCourses
}
```

### Top LeetCode Problems
1. [Course Schedule (LC #207)](https://leetcode.com/problems/course-schedule/)
2. [Course Schedule II (LC #210)](https://leetcode.com/problems/course-schedule-ii/)
3. [Alien Dictionary (LC #269)](https://leetcode.com/problems/alien-dictionary/)

---

## 16. Disjoint Set Union (DSU) / Union-Find

### Overview & When to Use
Tracks partition of elements into disjoint sets. Supports near $O(1)$ operations to **find set representatives** and **union two sets**. Perfect for graph connectivity and Minimum Spanning Trees.

### Pseudocode Template
```kotlin
class UnionFind(size: Int) {
    private val parent = IntArray(size) { it }
    private val rank = IntArray(size) { 1 }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x]) // Path compression
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY
            } else {
                parent[rootY] = rootX
                rank[rootX]++
            }
            return true
        }
        return false // Already connected
    }
}
```

### Top LeetCode Problems
1. [Number of Connected Components in an Undirected Graph (LC #323)](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
2. [Redundant Connection (LC #684)](https://leetcode.com/problems/redundant-connection/)
3. [Accounts Merge (LC #721)](https://leetcode.com/problems/accounts-merge/)

---

## 17. Dynamic Programming - 0/1 Knapsack

### Overview & When to Use
Given $N$ items with weights and values, decide whether to **include or exclude (0 or 1)** each item to maximize value within a weight capacity $W$.

### Pseudocode Template
```kotlin
fun knapsack01(weights: IntArray, values: IntArray, capacity: Int): Int {
    val n = weights.size
    val dp = IntArray(capacity + 1)

    for (i in 0 until n) {
        for (w in capacity downTo weights[i]) {
            dp[w] = maxOf(dp[w], values[i] + dp[w - weights[i]])
        }
    }
    return dp[capacity]
}
```

### Top LeetCode Problems
1. [Partition Equal Subset Sum (LC #416)](https://leetcode.com/problems/partition-equal-subset-sum/)
2. [Target Sum (LC #494)](https://leetcode.com/problems/target-sum/)
3. [Ones and Zeroes (LC #474)](https://leetcode.com/problems/ones-and-zeroes/)

---

## 18. Dynamic Programming - Unbounded Knapsack

### Overview & When to Use
Similar to 0/1 Knapsack, but each item can be selected an **infinite number of times**.

### Pseudocode Template
```kotlin
fun unboundedKnapsack(weights: IntArray, values: IntArray, capacity: Int): Int {
    val dp = IntArray(capacity + 1)

    for (w in 1..capacity) {
        for (i in weights.indices) {
            if (weights[i] <= w) {
                dp[w] = maxOf(dp[w], values[i] + dp[w - weights[i]])
            }
        }
    }
    return dp[capacity]
}
```

### Top LeetCode Problems
1. [Coin Change (LC #322)](https://leetcode.com/problems/coin-change/)
2. [Coin Change II (LC #518)](https://leetcode.com/problems/coin-change-ii/)
3. [Combination Sum IV (LC #377)](https://leetcode.com/problems/combination-sum-iv/)

---

