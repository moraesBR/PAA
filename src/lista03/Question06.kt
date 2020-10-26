package lista03

import algorithms.ClosedFormFib
import algorithms.IterativeFib
import algorithms.RecursiveFib
import misc.AnswerLong
import java.util.*

fun main() {
    /*print("Fibonacci Sequences\nPlease, enter a positive number: ")
    try {
        val n = Scanner(System.`in`).nextLong()
        when {
            n >= 0 -> {
                println("${RecursiveFib.getName()}: F($n) = ${RecursiveFib.sequence(n).steps}")
                println("${IterativeFib.getName()}: F($n) = ${IterativeFib.sequence(n).steps}")
                println("${ClosedFormFib.getName()}: F($n) = ${ClosedFormFib.sequence(n).steps}")
            }
            else -> println("Invalid number")
        }
    } catch (e: InputMismatchException) { println("Invalid input") }*/

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