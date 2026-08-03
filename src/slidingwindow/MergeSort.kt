package slidingwindow

class MergeSort {

    fun sort(array: IntArray, left: Int, right: Int) {

        // Base condition:
        // If left and right point to the same element,
        // the array part is already sorted.
        // No need to divide further.
        if (left >= right) return

        // Find middle index.
        // This avoids integer overflow compared to (left + right) / 2
        val mid = left + (right - left) / 2

        // Divide left half
        // Example: [5,7,9,1,3,4]
        // Left part -> [5,7,9]
        sort(array, left, mid)

        // Divide right half
        // Right part -> [1,3,4]
        sort(array, mid + 1, right)

        // Once both halves are sorted,
        // combine them into one sorted array.
        merge(array, left, mid, right)
    }


    fun merge(array: IntArray, left: Int, mid: Int, right: Int) {

        // Temporary array stores sorted values
        // Size is the total number of elements between left and right indexes.
        val temp = IntArray(right - left + 1)

        // i points to left sorted subarray
        var i = left

        // j points to right sorted subarray
        var j = mid + 1

        // k tracks position in temporary array
        var k = 0


        // Compare elements from both sorted halves.
        // Decision:
        // If left element is smaller, put it first.
        // Otherwise put right element first.
        while (i <= mid && j <= right) {

            if (array[i] <= array[j]) {

                // Left side element is smaller or equal,
                // so it maintains sorted order.
                temp[k] = array[i]
                i++

            } else {

                // Right side element is smaller,
                // so it should come before left element.
                temp[k] = array[j]
                j++
            }

            k++
        }


        // If left half still has remaining elements,
        // copy them because they are already sorted.
        while (i <= mid) {

            temp[k] = array[i]
            i++
            k++
        }


        // If right half still has remaining elements,
        // copy them because they are already sorted.
        while (j <= right) {

            temp[k] = array[j]
            j++
            k++
        }


        // Copy sorted temporary array back into original array.
        // This updates the current range [left..right].
        for (index in temp.indices) {
            array[left + index] = temp[index]
        }
    }
}