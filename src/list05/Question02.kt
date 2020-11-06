package list05

import algorithms.quicksort
import misc.Pivot
import java.io.File
import kotlin.math.log2
import kotlin.math.pow
import kotlin.random.Random

fun main() {
    val n = 10
    val nSizes = Array(n) { (2.0.pow(3 + it)).toInt() }

    val stream = File("Quicksort.csv").printWriter()
    stream.use { out ->
        out.println("Descending order")
        out.println("N;First;Middle;Last;Random;O(nLog(n))")
        nSizes.forEach { size ->
            val items = Array(size) { pos -> size - pos }
            val first = items.quicksort(0, items.lastIndex, Pivot.FIRST)
            items.reverse()
            val middle = items.quicksort(0, items.lastIndex, Pivot.MIDDLE)
            items.reverse()
            val last = items.quicksort(0, items.lastIndex, Pivot.LAST)
            items.reverse()
            val random = items.quicksort(0, items.lastIndex, Pivot.RANDOM)
            val nlogn = size * (log2(size.toFloat())).toInt()
            out.println("${size};${first};${middle};${last};${random};${nlogn}")
        }

        out.println("\n\nAscending order")
        out.println("N;First;Middle;Last;Random;O(nLog(n))")
        nSizes.forEach { size ->
            val items = Array(size) { pos -> pos + 1 }
            val first = items.quicksort(0, items.lastIndex, Pivot.FIRST)
            items.reverse()
            val middle = items.quicksort(0, items.lastIndex, Pivot.MIDDLE)
            items.reverse()
            val last = items.quicksort(0, items.lastIndex, Pivot.LAST)
            items.reverse()
            val random = items.quicksort(0, items.lastIndex, Pivot.RANDOM)
            val nlogn = size * (log2(size.toFloat())).toInt()
            out.println("${size};${first};${middle};${last};${random};${nlogn}")
        }

        out.println("\n\nRandom order")
        out.println("N;First;Middle;Last;Random;O(nLog(n))")
        nSizes.forEach { size ->
            var items = Array(size) { Random.nextInt(10000) }
            val first = items.quicksort(0,items.lastIndex,Pivot.FIRST)

            items = Array(size) { Random.nextInt(1,10000) }
            val middle = items.quicksort(0,items.lastIndex,Pivot.MIDDLE)

            items = Array(size) { Random.nextInt(1,10000) }
            val last = items.quicksort(0,items.lastIndex,Pivot.LAST)

            items = Array(size) { Random.nextInt(1,10000) }
            val random = items.quicksort(0,items.lastIndex,Pivot.RANDOM)

            val nlogn = size * (log2(size.toFloat())).toInt()

            out.println("${size};${first};${middle};${last};${random};${nlogn}")
        }

        out.println("\n\nHomogeneous order")
        out.println("N;First;Middle;Last;Random;O(nLog(n))")
        nSizes.forEach { size ->
            val items = Array(size) { 1 }
            val first = items.quicksort(0, items.lastIndex, Pivot.FIRST)
            items.reverse()
            val middle = items.quicksort(0, items.lastIndex, Pivot.MIDDLE)
            items.reverse()
            val last = items.quicksort(0, items.lastIndex, Pivot.LAST)
            items.reverse()
            val random = items.quicksort(0, items.lastIndex, Pivot.RANDOM)
            val nlogn = size * (log2(size.toFloat())).toInt()
            out.println("${size};${first};${middle};${last};${random};${nlogn}")
        }
    }

    stream.close()
}