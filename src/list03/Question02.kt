package list03

import algorithms.BinarySearch
import misc.AnswerInt
import kotlin.random.Random

fun main() {
    val n = 100
    val nSizes = Array(n){ 10*(it+1) }

    val bestCase = Array(nSizes.size){ AnswerInt() }
    val randomCase = Array(nSizes.size){ AnswerInt() }
    val worstCase = Array(nSizes.size){ AnswerInt() }

    var index = 0

    println("key(position)")
    println("Step #: best random worst")
    nSizes.forEach { size: Int ->
        val vector = Array(size) { 2*it }

        var key = vector[ (0 + vector.lastIndex)/2 ]
        bestCase[index] = BinarySearch.search(vector,key)
        print("Step ${index + 1}: $key(${bestCase[index].value}) ")

        key = vector[ Random.nextInt(size - 2) + 1 ]
        randomCase[index] = BinarySearch.search(vector,key)
        print("$key(${randomCase[index].value}) ")

        key = -1
        worstCase[index] = BinarySearch.search(vector,key)
        println("$key(${worstCase[index].value}) ")

        index++
    }

    val map = nSizes.zip(bestCase.zip(randomCase.zip(worstCase))).toMap()
    println("\nN;Best;Random;Worst")
    map.asSequence()
       .map{
           println("${it.key};${it.value.first.steps};${it.value.second.first.steps};${it.value.second.second.steps}")}
        .toList()
}