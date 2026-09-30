package practice

class `Trapping Rain Water` {

    fun trap(height: IntArray): Int {
        val n = height.size
        val left = IntArray(n)
        val right = IntArray(n)
        left[0] = height[0]
        right[n - 1] = height[n - 1]
        for (i in 1 until n) {
            left[i] = maxOf(left[i - 1], height[i])
        }
        for (i in n - 2 downTo 0) {
            right[i] = maxOf(right[i + 1], height[i])
        }
        var water = 0
        for (i in 0 until n) {
            water += minOf(left[i], right[i]) - height[i]
        }
        return water
    }
}