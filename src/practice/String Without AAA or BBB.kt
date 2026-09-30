package practice

class `String Without AAA or BBB` {
    fun strWithout3a3b(a: Int, b: Int): String {
        var countA = a
        var countB = b
        var a = 'a'
        var b = 'b'
        val res = StringBuilder()
        if (countB > countA) {
            //Swap
            val tempCount = countA
            countA = countB
            countB = tempCount

            val temp = a
            a = b
            b = temp
        }

        while (countA > 0) {
            res.append(a)
            countA--

            if (countA > countB) {
                res.append(a)
                countA--
            }
            if (countB > 0) {
                res.append(b)
                countB--
            }

        }
        return res.toString()

    }
}