package algorithms

import misc.*
import kotlin.random.Random

abstract class SortAlgorithm {
    abstract fun <T> sort(items: Array<T>): Long where T:Number, T:Comparable<T>
    abstract fun getName(): String
}

object InsertionSort : SortAlgorithm() {
    override fun <T> sort(items: Array<T>): Long where T : Number, T : Comparable<T> {
        // In for loop (j), arr.size.toLong() elements to check
        var count = items.size.toLong()
        for (j in items.indices) {
            val key = items[j]
            var i = j - 1

            while (i >= 0 && items[i] > key) {
                items[i + 1] = items[i]
                i--
                // two assignment and loop test
                count += 3
            }

            items[i + 1] = key
            // three assignment and final loop test
            count += 4
        }
        println("Sorted Array = ${items.toList()}")
        return count
    }

    override fun getName(): String {
        return "insertion sort"
    }
}

object RevInsertionSort : SortAlgorithm() {
    override fun <T> sort(items: Array<T>): Long where T : Number, T : Comparable<T>{
        // In for loop (j), arr.size.toLong() elements to check
        var count = items.size.toLong()
        for (j in 1 until items.size){
            val key = items [j]
            var i = j - 1

            while ( ++count > 0  && i >= 0 && items [i] < key){
                items[i + 1] = items[i]
                i--
                // two assignment
                count += 2
            }
            items[i+1] = key
            // three assignment
            count += 3
        }
        println("Sorted Array = ${items.toList()}")
        return count
    }

    override fun getName() : String{
        return "reverse insertion sort"
    }
}

/*
object SelectionSort : SortAlgorithm() {
    override fun <T> sort(arr: Array<T>): Long where T : Number, T : Comparable<T>{
        var index: Int
        var aux: T
        // In for loop (i), arr.size.toLong() elements to check
        var count = arr.size.toLong() + 1
        for (i in 0 until (arr.size - 1)){
            var key = arr [i]
            index = i

            for (j in i+1 until arr.size){
                // if condition
                if(arr[j] < key) {
                    key = arr[j]
                    index = j
                    // two assigment
                    count += 2
                }
                count+=2
            }

            aux = arr[i]
            arr[i] = key
            arr[index] = aux
            // three assignment
            count += 6
        }
        println("Sorted Array = ${arr.toList()}")
        return count
    }

    override fun getName() : String{
        return "Selection sort"
    }
}*/


object SelectionSort : SortAlgorithm() {
    override fun <T> sort(items: Array<T>): Long where T : Number, T : Comparable<T>{
        var index: Int
        var aux: T
        var tl1 = 0L
        var tl2 = 0L
        var tl3 = 0L
        for (i in 0 until (items.size - 1)){
            var key = items [i]
            index = i
            for (j in i+1 until items.size){
                // if condition
                if(items[j] < key) {
                    key = items[j]
                    index = j
                    tl3 += 2
                }
                tl2 += 2
            }
            aux = items[i]
            items[i] = key
            items[index] = aux
            tl1 += 7
        }
        tl1++
        println("${tl1};${tl2};${tl3}")
        return tl1 + tl2 + tl3
    }

    override fun getName() : String{
        return "Selection sort"
    }
}

object QuickSort : SortAlgorithm(){
    override fun <T> sort(items: Array<T>): Long where T : Number, T : Comparable<T> {
        val ans = quicksort(AnswerList(items.toList()))
        for (i in items.indices){
            items[i] = ans.items[i]
        }
        return ans.steps
    }

    private fun <T> quicksort(ans: AnswerList<T>): AnswerList<T> where T : Number, T: Comparable<T>{

        val count = ans.items.count()
        ans.steps += count + 2

        if(count < 2) return ans
        val pivot = ans.items[count/2]

        val equal = AnswerList(ans.items.filter{ it == pivot})
        val less = AnswerList(ans.items.filter{ it < pivot})
        val greater = AnswerList(ans.items.filter{ it > pivot})

        return quicksort(less) + quicksort(equal) + quicksort(greater)
    }

    override fun getName(): String {
        return "Quicksort"
    }
}


object QuickSortRev : SortAlgorithm(){
    override fun <T> sort(items: Array<T>): Long where T : Number, T : Comparable<T> {
        val ans = quicksort(AnswerList(items.toList()))
        for (i in items.indices){
            items[i] = ans.items[i]
        }
        return ans.steps
    }

    private fun <T> quicksort(ans: AnswerList<T>): AnswerList<T> where T : Number, T: Comparable<T>{

        val count = ans.items.count()
        ans.steps += 3*count + 2

        if(count < 2) return ans
        val pivot = ans.items[count/2]

        val equal = AnswerList(ans.items.filter{ it == pivot})
        val less = AnswerList(ans.items.filter{ it < pivot})
        val greater = AnswerList(ans.items.filter{ it > pivot})

        return quicksort(greater) + quicksort(equal) + quicksort(less)
    }

    override fun getName(): String {
        return "Quicksort"
    }
}

fun <T> Array<T>.quicksort(first: Int, last: Int, type: Pivot = Pivot.FIRST): Long where T: Number, T: Comparable<T>{
    var steps = 1L
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
            while (lower <= last && this[lower] >= pivot) { lower++; steps++ }
            while (this[upper] < pivot) { upper--; steps++ }

            if (lower < upper) {
                this[lower] = this[upper] { this[upper--] = this[lower++] }
                //steps += 3
            }
            steps += 4
        }
        this[first] = this[upper] {this[upper] = this[first]}

        if (first < upper - 1) steps += this.quicksort(first, upper - 1, type)
        if (upper < last) steps += this.quicksort(upper + 1, last, type)

        steps += 14
    }
    return steps
}
