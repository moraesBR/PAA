package misc

open class Answer (var steps: Long = 0)

class AnswerInt(var value: Int = -1, steps: Long = 0L) : Answer(steps)

operator fun AnswerInt.plus(b: AnswerInt): AnswerInt{
    return AnswerInt(value+b.value,steps + b.steps)
}

operator fun AnswerInt.minus(b: Int): AnswerInt{
    return AnswerInt(value-b,steps + 1L)
}

class AnswerLong(var value: Long = 0L, steps: Long = 0L) : Answer(steps)

operator fun AnswerLong.plus(b: AnswerLong): AnswerLong{
    return AnswerLong(value+b.value,steps + b.steps)
}

operator fun AnswerLong.minus(b: Int): AnswerLong{
    return AnswerLong(value-b,steps + 1L)
}
