package list03

import java.util.*

fun moveTower(discs: Int = 3, source: String = "A", target: String = "C", auxiliary:String = "B"){
    if(discs >=1 ){
        moveTower(discs-1,source,auxiliary,target)
        println("Moving disk $discs from $source to $target")
        moveTower(discs-1,auxiliary,target,source)
    }
}

fun main() {
    print("Hanoi Tower\nPlease, enter with a positive number of discs: ")
    try {
        val numberDisc =Scanner(System.`in`).nextInt()
        when {
            numberDisc >= 1 -> moveTower(numberDisc)
            else -> println("Number of discs is invalid")
        }
    } catch (e:InputMismatchException) { println("Invalid input") }
}