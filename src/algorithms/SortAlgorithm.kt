package algorithms

abstract class SortAlgorithm {
    abstract fun <T> sort(arr: Array<T>): Long where T:Number, T:Comparable<T>
    abstract fun getName(): String
}

object InsertionSort : SortAlgorithm() {
    override fun <T> sort(arr: Array<T>): Long where T : Number, T : Comparable<T> {
        // In for loop (j), arr.size.toLong() elements to check
        var count = arr.size.toLong()
        for (j in arr.indices) {
            val key = arr[j]
            var i = j - 1

            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i]
                i--
                // two assignment and loop test
                count += 3
            }

            arr[i + 1] = key
            // three assignment and final loop test
            count += 4
        }
        println("Sorted Array = ${arr.toList()}")
        return count
    }

    override fun getName(): String {
        return "insertion sort"
    }
}

object RevInsertionSort : SortAlgorithm() {
    override fun <T> sort(arr: Array<T>): Long where T : Number, T : Comparable<T>{
        // In for loop (j), arr.size.toLong() elements to check
        var count = arr.size.toLong()
        for (j in 1 until arr.size){
            val key = arr [j]
            var i = j - 1

            while ( ++count > 0  && i >= 0 && arr [i] < key){
                arr[i + 1] = arr[i]
                i--
                // two assignment
                count += 2
            }
            arr[i+1] = key
            // three assignment
            count += 3
        }
        println("Sorted Array = ${arr.toList()}")
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
    override fun <T> sort(arr: Array<T>): Long where T : Number, T : Comparable<T>{
        var index: Int
        var aux: T
        var tl1 = 0L
        var tl2 = 0L
        var tl3 = 0L
        for (i in 0 until (arr.size - 1)){
            var key = arr [i]
            index = i
            for (j in i+1 until arr.size){
                // if condition
                if(arr[j] < key) {
                    key = arr[j]
                    index = j
                    tl3 += 2
                }
                tl2 += 2
            }
            aux = arr[i]
            arr[i] = key
            arr[index] = aux
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