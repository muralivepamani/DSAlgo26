import slidingwindow.MergeSort

fun main() {
    val array= intArrayOf(8, 3, 1, 7, 0, 10, 2)

    val mergeSort= MergeSort()
    mergeSort.sort(array,0,array.lastIndex)
    println(array.joinToString(", "))

}

