package bfs

class `Word Ladder` {
    fun wordLadder(beginWord: String, endWord: String, wordList: List<String>): Int {
        val set = wordList.toHashSet()
        if (endWord !in set) return 0
        val dq = ArrayDeque<String>()
        dq.add(beginWord)
        var steps = 1
        while (dq.isNotEmpty()) {
            repeat(dq.size) {
                val word = dq.removeFirst()
                if (word == endWord) return steps
                for (i in word.indices) {
                    for (c in 'a'..'z') {
                        if (c == word[i]) continue
                        val chars = word.toCharArray()
                        chars[i] = c
                        val nextWord = String(chars = chars)
                        if (nextWord in set) {
                            set.remove(nextWord)
                            dq.add(nextWord)
                        }
                    }
                }
            }
            steps++
        }
        return 0


    }
}