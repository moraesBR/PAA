package list01

import algorithms.LinearSearch
import misc.Answer
import misc.invoke
import kotlin.random.Random

fun main(){
    val n = 100
    val nSizes = Array(n){ 10 + 10*it }

    val bestCase = Array(nSizes.size){ Answer() }
    val randomCase = Array(nSizes.size){ Answer() }
    val worstCase = Array(nSizes.size){ Answer() }
    var index = 0
    nSizes.forEach { pos ->
        val vector = Array(pos){ Random.nextLong(pos.toLong()) }
        println("Array = ${vector.asList()}")
        var aux = -9999L

        aux = vector[0] {vector [0] = aux}
        bestCase[index]   = LinearSearch.search(vector,-9999)
        aux = vector[0] {vector [0] = aux}

        val indexRandom = Random.nextInt(pos-1)
        aux = vector[indexRandom] {vector [indexRandom] = aux}
        randomCase[index] = LinearSearch.search(vector,-9999)
        aux = vector[indexRandom] {vector [indexRandom] = aux}

        aux = vector[pos -1] {vector [pos -1] = aux}
        worstCase[index++]  = LinearSearch.search(vector,-9999)
        aux = vector[pos -1] {vector [pos -1] = aux}
    }

    println("The best cases has taken ${bestCase.toList().asSequence().map { answer -> answer.steps }.toList()} steps")
    println("The random cases has took ${randomCase.toList().asSequence().map { answer -> answer.steps }.toList()} steps")
    println("the worst cases has took ${worstCase.toList().asSequence().map { answer -> answer.steps }.toList()} steps")

    val map = nSizes.zip(bestCase.zip(randomCase.zip(worstCase))).toMap()
    println("N;Best;Random;Worst")
    map.asSequence().map{ println("${it.key};${it.value.first.steps};${it.value.second.first.steps};${it.value.second.second.steps}")}.toList()

}