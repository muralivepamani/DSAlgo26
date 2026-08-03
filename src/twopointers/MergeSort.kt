package twopointers

class MergeSort {
    /** val array= intArrayOf(8, 3, 1, 7, 0, 10, 2)

    val mergeSort= MergeSort()
    mergeSort.sort(array,0,array.lastIndex)
    println(array.joinToString(", "))*/
    fun sort(array: IntArray, left: Int, right: Int) {

        // Stop when subarray has one element or no elements
        if (left >= right) return

        // Calculate middle index to divide array into two halves
        val mid = left + (right - left) / 2

        // Sort left half
        sort(array, left, mid)

        // Sort right half
        sort(array, mid + 1, right)

        // Merge two sorted halves
        merge(array, left, mid, right)
    }

    fun merge(array: IntArray, left: Int, mid: Int, right: Int) {

        // Create temporary array to store merged sorted values
        val temp = IntArray(right - left + 1)

        // Pointer for left sorted half
        var i = left

        // Pointer for right sorted half
        var j = mid + 1

        // Pointer for temporary array
        var k = 0

        // Compare both halves until one side is exhausted
        while (i <= mid && j <= right) {

            // Choose left element if it is smaller or equal
            if (array[i] <= array[j]) {

                temp[k++] = array[i++]

            } else {

                // Choose right element if it is smaller
                temp[k++] = array[j++]
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[k++] = array[i++]
        }

        // Copy remaining elements from right half
        while (j <= right) {
            temp[k++] = array[j++]
        }

        // Replace original range with sorted values
        for (index in temp.indices) {
            array[left + index] = temp[index]
        }
    }
}