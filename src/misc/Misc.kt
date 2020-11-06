package misc

inline operator fun <T> T.invoke(dummy: () -> Unit): T {
    dummy()
    return this
}

fun <T> Array<T>.isDescending(): Boolean where T:Number, T:Comparable<T>{
    for (i in 0 until (this.size-1))
        if (this[i] < this[i+1])
            return false
    return true
}

fun <T> Array<T>.isAscending(): Boolean where T:Number, T:Comparable<T>{
    for (i in 0 until (this.size-1))
        if (this[i] > this[i+1])
            return false
    return true
}