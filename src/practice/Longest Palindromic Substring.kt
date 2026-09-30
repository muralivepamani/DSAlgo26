package practice

class `Longest Palindromic Substring` {

    fun longestPalindrome(s: String): String {
        if (s.length <= 1) return s
        var lps = ""


        for (i in 1 until s.length) {
            var low = i
            var high = i

            while (s[low] == s[high]) {
                low--
                high++
                if (low == -1 || high == s.length) {
                    break
                }
            }
            var pal = s.substring(low + 1, high)
            if (pal.length > lps.length) {
                lps = pal
            }

            low = i - 1
            high = i
            while (s[low] == s[high]) {
                low--
                high++
                if (low == -1 || high == s.length) {
                    break
                }
            }

            pal = s.substring(low + 1, high)
            if (pal.length > lps.length) {
                lps = pal
            }
        }
        return lps
    }
}