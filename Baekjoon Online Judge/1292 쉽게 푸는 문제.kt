fun main(args: Array<String>) {
    val (startNumber, endNumber) = readln().split(" ").map(String::toInt)
    println(Sequence().sum(startNumber, endNumber))
}

class Sequence() {

    init {
        if (!isSet()) setSequence()
    }

    fun sum(startNumber: Int, endNumber: Int): Int {
        return sequence[endNumber] - sequence[startNumber - 1]
    }

    private fun isSet(): Boolean = MAX_NUMBER < sequence.size

    private fun setSequence() {
        sequence.add(0)
        for (i in 1..MAX_NUMBER) {
            for (j in 1..i) {
                if (i == 1) sequence.add(1)
                else sequence.add(i + sequence[sequence.lastIndex])
                if (MAX_NUMBER < sequence.size) break
            }
            if (MAX_NUMBER < sequence.size) break
        }
    }

    companion object {
        private const val MAX_NUMBER = 1000
        private val sequence: MutableList<Int> = mutableListOf()
    }
}