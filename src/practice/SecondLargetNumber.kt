package practice

class SecondLargestNumber {
    fun secondLargestNumber(nums: IntArray): Int {
        var largest = Int.MIN_VALUE
        var secondLarget = Int.MIN_VALUE
        for (num in nums) {
            if (num > largest) {
                secondLarget = largest
                secondLarget = num

            } else if (num > secondLarget && num < largest) {
                secondLarget = num

            }
        }
        return secondLarget

    }
}