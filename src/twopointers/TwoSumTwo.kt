package twopointers

class TwoSumTwo {

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            val curSum = numbers[left] + numbers[right]
            if (target == curSum) {
                return intArrayOf(left + 1, right + 1)
            } else if (curSum < target) {
                left++
            } else {
                right--
            }

        }
        return intArrayOf(-1, -1)
    }
}