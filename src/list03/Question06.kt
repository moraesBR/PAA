package list03

import algorithms.ClosedFormFib
import algorithms.IterativeFib
import algorithms.RecursiveFib
import misc.AnswerLong

fun main() {
    val n = 15
    val numbers = Array(n){ it + 1}
    val recursiveCase  = Array(n){AnswerLong()}
    val iterativeCase  = Array(n){AnswerLong()}
    val closedFormCase = Array(n){AnswerLong()}

    numbers.forEach { element ->
        recursiveCase[element-1]  = RecursiveFib.sequence(element)
        iterativeCase[element-1]  = IterativeFib.sequence(element)
        closedFormCase[element-1] = ClosedFormFib.sequence(element)
    }
    println("Fibonacci Sequence")
    println("${RecursiveFib.getName()} : ${recursiveCase.asSequence().map { it.value }.toList()}")
    println("${IterativeFib.getName()} : ${iterativeCase.asSequence().map { it.value }.toList()}")
    println("${ClosedFormFib.getName()}: ${closedFormCase.asSequence().map { it.value }.toList()}")

    println("\nFibonacci Sequence Cost (Steps)")
    println("${RecursiveFib.getName()} : ${recursiveCase.asSequence().map { it.steps }.toList()}")
    println("${IterativeFib.getName()} : ${iterativeCase.asSequence().map { it.steps }.toList()}")
    println("${ClosedFormFib.getName()}: ${closedFormCase.asSequence().map { it.steps }.toList()}")

    val map = numbers.zip(recursiveCase.zip(iterativeCase.zip(closedFormCase))).toMap()
    println("N;Recursive;Iterative;Closed form")
    map.asSequence().map{ println("${it.key};${it.value.first.steps};${it.value.second.first.steps};${it.value.second.second.steps}")}.toList()
}