package kwaymerge

import java.util.PriorityQueue

class `Find K Pairs with Smallest Sums` {

    fun kthSmallestPairs(
        nums1: IntArray,
        nums2: IntArray,
        k: Int
    ): List<List<Int>> {

        val res = mutableListOf<List<Int>>()

        // Min Heap stores:
        // [sum, index1, index2]
        //
        // Example:
        // [3, 0, 0] means:
        // nums1[0] + nums2[0] = 3
        val minHeap = PriorityQueue<IntArray> { a, b ->
            a[0] - b[0]
        }

        // Add the first pair from each row.
        //
        // Example:
        // nums1 = [1, 7, 11]
        // nums2 = [2, 4, 6]
        //
        // Initial heap:
        // [3, 0, 0] -> 1 + 2
        // [9, 1, 0] -> 7 + 2
        // [13, 2, 0] -> 11 + 2
        //
        // We only need min(nums1.size, k) rows.
        for (i in 0 until minOf(nums1.size, k)) {
            minHeap.add(
                intArrayOf(
                    nums1[i] + nums2[0],
                    i,
                    0
                )
            )
        }

        // Extract the k smallest pairs.
        repeat(k) {

            // Get the pair with the smallest sum.
            val cur = minHeap.poll()

            // Get indexes of nums1 and nums2.
            val i = cur[1]
            val j = cur[2]

            // Add the actual pair to the result.
            res.add(
                listOf(
                    nums1[i],
                    nums2[j]
                )
            )

            // Move to the next element in nums2 for the same nums1[i].
            //
            // Example:
            // Current: [3, 0, 0] -> 1 + 2
            // Next:    [5, 0, 1] -> 1 + 4
            //
            // Since nums2 is sorted, the next element is the
            // only new candidate we need from this row.
            if (j + 1 < nums2.size) {
                minHeap.add(
                    intArrayOf(
                        nums1[i] + nums2[j + 1],
                        i,
                        j + 1
                    )
                )
            }
        }

        return res
    }
}

/*
Intuition:
------------
Both nums1 and nums2 are sorted.

They form sorted rows of pair sums:

        2    4    6
     ----------------
1  |   3    5    7
7  |   9   11   13
11 |  13   15   17

Each row is already sorted.

We put the first element of every row into a Min Heap.
After removing the smallest element, we add the next element
from that same row.

This is essentially a K-Way Merge.

/*
Time Complexity:
----------------
Let n = nums1.size()
Let k = number of pairs required.

Initial heap insertion:
O(min(n, k) log(min(n, k)))

We perform k iterations.
Each iteration:
    poll() -> O(log(min(n, k)))
    add()  -> O(log(min(n, k)))

Overall:
O(k log(min(n, k)))

Space Complexity:
-----------------
Heap:
O(min(n, k))

Result:
O(k)

Auxiliary space:
O(min(n, k))

If counting the output list:
O(k + min(n, k))
*/