package algorithms

import misc.AnswerInt

abstract class SearchAlgorithm {
    abstract fun <T> search(arr: Array<T>, key: T, ascending: Boolean = true): AnswerInt where T:Number, T:Comparable<T>
    abstract fun getName(): String
}

object LinearSearch : SearchAlgorithm() {
    override fun <T> search(arr: Array<T>, key: T, ascending: Boolean): AnswerInt where T : Number, T : Comparable<T> {
        val ans = AnswerInt(-1)
        for(i in arr.indices){

            if(arr[i] == key) {
                ans.value = i
                ans.steps++
                return ans
            }
            ans.steps += 2
        }
        return ans
    }

    override fun getName(): String {
        return "Linear Search"
    }
}

/*
 * function binary_search(A, n, T) is
 *   L := 0
 *   R := n − 1
 *   while L ≤ R do
 *       m := floor((L + R) / 2)
 *       if A[m] < T then
 *           L := m + 1
 *       else if A[m] > T then
 *           R := m − 1
 *       else:
 *           return m
 *   return unsuccessful
 */
object BinarySearch : SearchAlgorithm() {
    override fun <T> search(arr: Array<T>, key: T, ascending: Boolean): AnswerInt where T : Number, T : Comparable<T> {
        var left = 0
        var right = arr.lastIndex
        var steps = 0L
        val ans = AnswerInt()

        val isRight = if (ascending) { idx:Int -> arr[idx] < key } else { idx:Int -> arr[idx] > key }
        val isLeft = if (ascending) { idx:Int -> arr[idx] > key } else { idx:Int -> arr[idx] < key }

        while ( left <= right ){
            val center = (left + right)/2
            steps += 2
            when {
                // one ifs + one assignment
                isRight(center) -> { left  = center + 1; steps +=2 } // right cicle's cost equals 4 steps
                // two ifs + one assignment
                isLeft(center)  -> { right = center - 1; steps +=3 } // left cicle's cost equals 5 steps
                // two ifs. return doesn't count
                else -> { ans.value = center ; ans.steps = steps; steps+=2; return ans} // finding's cost equals 5
            }
        }
        ans.steps = ++steps
        return ans
    }

    override fun getName(): String {
        return "Binary Search"
    }
}