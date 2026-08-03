package twopointers

class Container {
    fun maxArea(height: IntArray): Int {

        var right = height.size - 1
        var left = 0
        var maxArea = 0

        while ((left < right)) {

            val currentHeight = minOf(height[left], height[right])
            val width = right - left
            val curArea = currentHeight * width
            maxArea = maxOf(curArea, maxArea)
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }
        return maxArea


    }
}