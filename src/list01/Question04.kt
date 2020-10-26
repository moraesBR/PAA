package list01

import algorithms.SelectionSort
import misc.invoke
import kotlin.random.Random

fun main(){
    val n = 100
    val nSizes = Array(n){ 10 + 10*it }

    val bestCase = Array(nSizes.size){ 0L }
    var index = 0
    println("Best case\ntl1;tl2;tl3")
    nSizes.forEach {
        val vector = Array(it){ pos -> pos.toLong() + 1L}
        bestCase[index++] = SelectionSort.sort(vector)
    }

    val randomCase = Array(nSizes.size){ 0L }
    index=0
    val desentropia = 10
    println("Random case\ntl1;tl2;tl3")
    nSizes.forEach {
        //var vector = Array(it){ Random.nextLong(1000)}
        var vector = Array(it){ pos -> pos.toLong() + 1L}
        vector = vector.asList().asReversed().toTypedArray()
        for (i in vector.indices){
            if( i%(it/desentropia) == 0) {
                val pos = Random.nextInt(vector.size)
                vector[i] = vector[pos] { vector[pos] = vector[i] }
            }
        }
        randomCase[index++] = SelectionSort.sort(vector)
    }

    val worstCase = Array(nSizes.size){ 0L }
    index=0
    println("Worst case\ntl1;tl2;tl3")
    nSizes.forEach {
        var vector = Array(it){ pos -> pos.toLong() + 1L}
        vector = vector.asList().asReversed().toTypedArray()
        worstCase[index++] = SelectionSort.sort(vector)
    }

    val map = nSizes.zip(bestCase.zip(randomCase.zip(worstCase))).toMap()
    println("N;Best;Random;Worst")
    map.asSequence().map{ println("${it.key};${it.value.first};${it.value.second.first};${it.value.second.second}")}.toList()

}