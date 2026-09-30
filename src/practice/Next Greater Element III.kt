package practice

class `Next Greater Element III` {


    fun nextGreaterElement(n: Int): Int {

        // Convert number into digits
        val arr = n.toString().toCharArray()

        // Step 1: Find the first digit from right
        // that is smaller than the digit after it.
        var i = arr.size - 2

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--
        }

        // No smaller digit found
        // Example: 321 -> no greater permutation
        if (i < 0) return -1

        // Step 2: Find the smallest digit from the right
        // that is greater than arr[i]
        var j = arr.size - 1

        while (arr[j] <= arr[i]) {
            j--
        }

        // Step 3: Swap them
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp

        // Step 4: Reverse everything after i
        // This gives the smallest possible number
        // greater than the original number.
        var left = i + 1
        var right = arr.size - 1

        while (left < right) {
            val temp2 = arr[left]
            arr[left] = arr[right]
            arr[right] = temp2

            left++
            right--
        }

        // Convert back to number
        val result = arr.concatToString().toLong()

        // Must fit in Int
        return if (result > Int.MAX_VALUE) -1 else result.toInt()
    }
}