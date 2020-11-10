package list06

import algorithms.HeapSort
import java.io.File
import kotlin.math.log2
import kotlin.math.pow
import kotlin.random.Random

fun main() {
    val n = 10
    val nSizes = Array(n) { (2.0.pow(3 + it)).toInt() }

    val stream = File("Heapsort.csv").printWriter()
    stream.use { out ->
        out.println("Ascending order")
        out.println("N;Ascending;Descending;Random;Homogeneous")
        nSizes.forEach { size ->
            var items = Array(size) { pos -> pos + 1 }
            val ascending = HeapSort.sort(items)

            items = Array(size) { pos -> size - pos }
            val descending = HeapSort.sort(items)

            items = Array(size) { Random.nextInt(1,2*size) }
            val random = HeapSort.sort(items)

            items = Array(size) { size }
            val homogeneous = HeapSort.sort(items)

            out.println("${log2(size.toFloat()).toInt()};${ascending};${descending};${random};${homogeneous}")
        }
    }

    stream.close()
}
