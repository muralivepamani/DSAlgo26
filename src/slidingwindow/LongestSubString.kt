package slidingwindow

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *Longest Substring Without Repeating Characters
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.*/
class LongestSubString {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLen = 0
        var left = 0
        val set = HashSet<Char>()
        for (right in s.indices) {

            while (set.contains(s[right])) {
                set.remove(s[left])
                left++
            }
            set.add(s[right])
            maxLen = maxOf(maxLen, right - left + 1)
        }
        return maxLen
    }
}