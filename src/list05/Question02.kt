package list05
/*
import misc.Pivot
import misc.invoke
import java.io.File
import kotlin.math.log2
import kotlin.math.pow
import kotlin.random.Random*/

/*fun <T> Array<T>.quicksort(first: Int, last: Int, type: Pivot = Pivot.FIRST): Long where T: Number, T: Comparable<T>{
    var steps = 0L
    var lower = first+1
    var upper = last

    val pivot = when(type){
        Pivot.RANDOM -> Random.nextInt(first,last)
        Pivot.MIDDLE -> (first + last)/2
        Pivot.LAST -> last
        else -> first
    }

    if(this[first] != this[pivot]) this[first] = this[pivot] {this[pivot] = this[first]}
    val bound = this[first]

    while (lower <= upper){
        while (lower <= last && bound < this[lower]) { lower++; steps++}
        while (upper >= 0 && bound > this[upper]) { upper--; steps ++}
        if (lower < upper) {
            this[lower] = this[upper] { this[upper--] = this[lower++] }
            steps += 3
        }
        else {
            lower++
            steps++
        }

        steps+=4
    }

    this[first] = this[upper] {this[upper] = this[first]}

    if(first < upper -1) steps += this.quicksort(first,upper-1)
    if(upper +1 < last) steps += this.quicksort(upper+1,last)

    steps+=14
    return steps
}

fun <T> Array<T>.isDescending(): Boolean where T:Number, T:Comparable<T>{
    for (i in 0 until (this.size-1))
        if (this[i] < this[i+1])
            return false
    return true
}

fun <T> Array<T>.isAscending(): Boolean where T:Number, T:Comparable<T>{
    for (i in 0 until (this.size-1))
        if (this[i] > this[i+1])
            return false
    return true
}*/
/*

fun main() {
    val n = 10
    val nSizes = Array(n){(2.0.pow(3+it)).toInt()}

    val stream = File("Quicksort.csv").printWriter()
    stream.use { out ->
        out.println("Descending order")
        out.println("N;First;Middle;Last;Random;O(nLog(n))")
        nSizes.forEach {size ->
            val items = Array(size){pos -> size - pos}
            val first = items.quicksort(0,items.lastIndex,Pivot.FIRST)
            items.reverse()
            val middle = items.quicksort(0,items.lastIndex,Pivot.MIDDLE)
            items.reverse()
            val last = items.quicksort(0,items.lastIndex,Pivot.LAST)
            items.reverse()
            val random = items.quicksort(0,items.lastIndex,Pivot.RANDOM)
            val nlogn = size*(log2(size.toFloat())).toInt()
            out.println("${size};${first};${middle};${last};${random};${nlogn}")
        }

        out.println("\n\nAscending order")
        out.println("N;First;Middle;Last;Random;O(nLog(n))")
        nSizes.forEach {size ->
            var items = Array(size){pos -> pos + 1}
            val first = items.quicksort(0,items.lastIndex,Pivot.FIRST)
            items.reverse()
            val middle = items.quicksort(0,items.lastIndex,Pivot.MIDDLE)
            items.reverse()
            val last = items.quicksort(0,items.lastIndex,Pivot.LAST)
            items.reverse()
            val random = items.quicksort(0,items.lastIndex,Pivot.RANDOM)
            val nlogn = size*(log2(size.toFloat())).toInt()
            out.println("${size};${first};${middle};${last};${random};${nlogn}")
        }

        out.println("\n\nRandom order")
        out.println("N;First;Middle;Last;Random;O(nLog(n))")
        nSizes.forEach {size ->
            var items = Array(size){Random.nextInt(10000)}
            val first = items.quicksort(0,items.lastIndex,Pivot.FIRST)

            items = Array(size){Random.nextInt(10000)}
            val middle = items.quicksort(0,items.lastIndex,Pivot.MIDDLE)

            items = Array(size){Random.nextInt(10000)}
            val last = items.quicksort(0,items.lastIndex,Pivot.LAST)

            items = Array(size){Random.nextInt(10000)}
            val random = items.quicksort(0,items.lastIndex,Pivot.RANDOM)

            val nlogn = size*(log2(size.toFloat())).toInt()

            out.println("${size};${first};${middle};${last};${random};${nlogn}")
        }

        out.println("\n\nHomogeneous order")
        out.println("N;First;Middle;Last;Random;O(nLog(n))")
        nSizes.forEach {size ->
            val items = Array(size){1}
            val first = items.quicksort(0,items.lastIndex,Pivot.FIRST)
            items.reverse()
            val middle = items.quicksort(0,items.lastIndex,Pivot.MIDDLE)
            items.reverse()
            val last = items.quicksort(0,items.lastIndex,Pivot.LAST)
            items.reverse()
            val random = items.quicksort(0,items.lastIndex,Pivot.RANDOM)
            val nlogn = size*(log2(size.toFloat())).toInt()
            out.println("${size};${first};${middle};${last};${random};${nlogn}")
        }
    }

    stream.close()

    */
/*for (i in 1..12) {
        val arr = Array(10) { Random.nextInt(20) }
        println("Array: ${arr.toList()}")

        when (i % 4) {
            0 -> {
                val steps = arr.quicksort(0, arr.lastIndex, Pivot.RANDOM)
                println("Sorted[Random]: ${arr.toList()} ($steps steps) -- checked: ${arr.check()}\n")
            }
            1 -> {
                val steps = arr.quicksort(0, arr.lastIndex, Pivot.FIRST)
                println("Sorted[First]: ${arr.toList()} ($steps steps) -- checked: ${arr.check()}\n")
            }
            2 -> {
                val steps = arr.quicksort(0, arr.lastIndex, Pivot.MIDDLE)
                println("Sorted[Middle]: ${arr.toList()} ($steps steps) -- checked: ${arr.check()}\n")
            }
            3 -> {
                val steps = arr.quicksort(0, arr.lastIndex, Pivot.LAST)
                println("Sorted[Last]: ${arr.toList()} ($steps steps) -- checked: ${arr.check()}\n")
            }
        }
    }*//*

}*/
