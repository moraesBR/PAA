package list01

import kotlin.math.ln

object PrimeNumber {
    fun nPrimes(nth: Int): Int{

        val size = sRange(nth)
        /* Each position corresponds to a number within the search range. As an initial hypothesis, we take indexes 0
         * and 1 as not prime numbers (assign 0) and consider all remaining indexes as prime numbers (assign 1). After
         * that, we will check which one is prime or not.
         */
        val nNumbers = Array(size+1){1}
        nNumbers[0] = 0
        nNumbers[1] = 0

        /* countPrime indicates how many prime numbers we found. */
        var countPrimes = 0
        /* Steps indicates how many steps we need to found the prime numbers that we want. After each instruction,
         * we increment steps.
         */
        var externalLoop = 0
        var innerLoop = 0

        /* The variable i inside for loop starts in two because we know previously that 0 and 1 are not prime numbers.*/
        for (i in 2..size) {
            externalLoop += 2

            if (nNumbers[i] == 1) {

                if(countPrimes++ >= nth) {
                    break
                }

                for (j in i..size) {
                    innerLoop += 3
                    if (i * j < size){
                        nNumbers[i * j] = 0
                    }
                    else {
                        break
                    }
                }
                innerLoop++
            }
            externalLoop++
        }
        val total = externalLoop + innerLoop
        println("${nth};${externalLoop};${innerLoop};$total")
        return externalLoop + innerLoop
    }

    private fun sRange(nth: Int): Int{
        var i = 2
        /*
        while (2.0.pow(i.toDouble()).div(ln(2.0.pow(i.toDouble()))) < nth.toDouble())
            i++
        return 2.0.pow(i.toDouble()).toInt()
        */

        while (i.toDouble().div(ln(i.toDouble())) < nth.toDouble())
            i++

        return i
    }
}

fun main() {
    val arr = mutableMapOf<Int,Int>()

    println("N;external loop; inner loop; external if; inner if;total")
    for (i in 5..6)
        arr[i] = PrimeNumber.nPrimes(i)

    /*println("N;Steps")
    arr.asSequence().map { println("${it.key};${it.value}") }.toList()*/

    /*for (i in 1..80)
        println(i)*/
}