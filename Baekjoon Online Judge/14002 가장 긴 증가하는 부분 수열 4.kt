import java.util.*

fun main() {
    val n: Int = readLine()!!.toInt()
    val sequence: IntArray = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    val sequenceCount = IntArray(sequence.size) { 1 }
    val sequenceIndex = IntArray(sequence.size) { -1 }

    for(i in sequence.indices) {
        for (j in 0 until i) {
            if (sequence[j] < sequence[i] && sequenceCount[i] < sequenceCount[j] + 1) {
                sequenceCount[i] = sequenceCount[j] + 1
                sequenceIndex[i] = j
            }
        }
    }

    var maxCount = -1
    var maxCountIndex = -1
    for(i in sequenceCount.indices) {
        if(sequenceCount[i] > maxCount) {
            maxCount = sequenceCount[i]
            maxCountIndex = i
        }
    }

    val tmp: Stack<Int> = Stack()
    var index = maxCountIndex
    while (index != -1) {
        tmp.push(sequence[index])
        index = sequenceIndex[index]
    }

    println(maxCount)
    while (!tmp.empty()) {
        print("${tmp.pop()} ")
    }
}