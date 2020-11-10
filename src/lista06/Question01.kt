package lista06


import algorithms.SortAlgorithm
import algorithms.quicksort
import misc.Pivot
import misc.invoke
import kotlin.random.Random

private fun <T> Array<T>.qsort(cmp: Array<T>, first: Int, last: Int, type: Pivot = Pivot.FIRST): Boolean where T: Number, T: Comparable<T>{
    var flag = false
    if(first < last) {

        val index = when (type) {
            Pivot.RANDOM -> Random.nextInt(first, last)
            Pivot.MIDDLE -> (first + last) / 2
            Pivot.LAST -> last
            else -> first
        }
        this[first] = this[index] {this[index] = this[first]}

        val pivot = this[first]
        var lower = first + 1
        var upper = last

        while (lower <= upper) {
            while (lower <= last && this[lower] >= pivot) lower++
            while (this[upper] < pivot) upper--

            if (lower < upper)
                this[lower] = this[upper] { this[upper--] = this[lower++] }
        }
        this[first] = this[upper] {this[upper] = this[first]}

        flag = this.contentEquals(cmp)

        if (flag) return flag

        if (first < upper - 1) flag = flag || this.qsort(cmp,first, upper - 1, type)
        if (upper < last) flag = flag || this.qsort(cmp,upper + 1, last, type)

    }
    return flag
}

//(A) Seleção.
private fun Array<Int>.sortA(cmp: Array<Int>): Boolean{
    for (i in 0 until (this.lastIndex - 1)){
        println(this.toList())
        var index = i
        for (j in i+1 until this.lastIndex){
            if(this[j] < this [index])
                index = j
        }
        this[i] = this[index] {this[index] = this[i]}
        println(this.toList())
        if(this.contentEquals(cmp)) return true
    }
    return false
}

//(B) Inserção.
private fun Array<Int>.sortB(cmp:Array<Int>): Boolean{

    for (j in this.indices) {
        println(this.toList())

        val key = this[j]
        var i = j - 1
        while (i >= 0 && this[i] > key)
            this[i + 1] = this[i--]

        this[i + 1] = key

        println(this.toList())
        if(this.contentEquals(cmp)) return true
    }

    return false
}

//(C) BubbleSort.
private fun Array<Int>.sortC(cmp: Array<Int>): Boolean{
    for (i in 0 until this.lastIndex - 1) {
        println(this.toList())
        for (j in this.lastIndex downTo (i + 1)) {
            if (this[j] < this[j - 1])
                this[j] = this[j - 1] { this[j - 1] = this[j] }
        }
        println(this.toList())
        if(this.contentEquals(cmp)) return true
    }
    return false
}

//(D) HeapSort.
private fun Array<Int>.sortD(cmp: Array<Int>): Boolean{
    val middle = size / 2 - 1

    for (i in middle downTo 0) {
        heapify(this, size, i)
    }

    if(this.contentEquals(cmp)) return true
    for (i in size - 1 downTo 0) {
        this[0] = this[i].also { this[i] = this[0] }
        heapify(this, i, 0)
    }
    return false
}

private fun heapify(arr: Array<Int>, heapSize: Int, root: Int) {
    var largest = root
    val leftNode = 2 * root + 1
    val rightNode = 2 * root + 2
    if (leftNode < heapSize && arr[leftNode] > arr[largest]) largest = leftNode
    if (rightNode < heapSize && arr[rightNode] > arr[largest]) largest = rightNode

    if (largest != root) {
        arr[root] = arr[largest] { arr[largest] = arr[root] }
        heapify(arr, heapSize, largest)
    }
}

fun main() {

    val arr = arrayOf(8, 7, 6, 5, 4, 3, 2, 1)
    val arr2 = arrayOf(6, 5, 3, 1, 4,2,7,8)

    println("${arr.sortD(arr2)}\n${arr.toList()}")

}