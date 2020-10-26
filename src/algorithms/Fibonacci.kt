package algorithms

import misc.AnswerLong
import misc.minus
import misc.plus
import kotlin.math.pow

abstract class Fibonacci {
    abstract fun sequence(n: Int): AnswerLong
    abstract fun getName(): String
}

object RecursiveFib : Fibonacci() {

    override fun sequence(n: Int): AnswerLong {
        return fib(AnswerLong(n.toLong()))
    }

    private fun fib(n: AnswerLong ): AnswerLong{
        return when (n.value) {
            0L -> AnswerLong(0,1L)
            1L -> AnswerLong(1,1L)
            else -> {
                fib(n - 1) + fib(n - 2)
            }
        }
    }

    override fun getName(): String {
        return "Recursive Fibonacci"
    }

}

object IterativeFib : Fibonacci(){
    override fun sequence(n: Int): AnswerLong {
        var beforelast: Long
        var last = 0L
        var current = 1L
        var steps = 0L

        for (i in 1 until n){
            beforelast = last
            last = current
            current = beforelast + last
            steps += 4
        }
        steps++
        return AnswerLong(current,steps)
    }

    override fun getName(): String {
        return "Iterative Fibonacci"
    }
}

object ClosedFormFib : Fibonacci(){
    override fun sequence(n: Int): AnswerLong {
        return AnswerLong((
                (1.0/5.0.pow(0.5))*
                        (
                                ((1.0+5.0.pow(0.5))/2.0).pow(n.toDouble())
                                        -
                                ((1.0-5.0.pow(0.5))/2.0).pow(n.toDouble())
                        )
                ).toLong(),1L)
    }

    override fun getName(): String {
        return "Closed Form Fibonacci"
    }

}