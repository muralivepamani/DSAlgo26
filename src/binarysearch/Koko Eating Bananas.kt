package binarysearch

class `Koko Eating Bananas` {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        // Minimum possible speed is 1 banana/hr
        var left = 1
        // Maximum possible speed: eating the largest pile in 1 hour
        var right = piles.maxOrNull() ?: 1

        while (left < right) {
            val mid = left + (right - left) / 2

            // Calculate total hours needed at speed = mid
            var hoursNeeded = 0L
            for (pile in piles) {
                hoursNeeded += (pile + mid - 1L) / mid
            }

            if (hoursNeeded <= h) {
                // Speed is fast enough; try searching for a smaller valid speed
                right = mid
            } else {
                // Speed is too slow; must increase speed
                left = mid + 1
            }
        }

        return left
    }
}