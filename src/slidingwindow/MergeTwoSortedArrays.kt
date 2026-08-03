package slidingwindow

class MergeTwoSortedArrays {

    /**
     *   val a = intArrayOf(5, 7, 9)
     *     val b = intArrayOf(1, 3, 4)
     * MergeTwoSortedArrays().mergeAndSort(a,b)*/

    fun mergeAndSort(a: IntArray, b: IntArray) {
        val res = IntArray(a.size + b.size)
        var i = 0
        var j = 0
        var k = 0
        while (i < a.size && j < b.size) {
            if (a[i] <= b[j]) {
                res[k++] = a[i++]
            } else {
                res[k++] = b[j++]
            }

        }
        while (i < a.size) {
            res[k++] = a[i++]
        }
        while (j < b.size) {
            res[k++] = b[j++]
        }

        println(res.joinToString(", "))
    }
}