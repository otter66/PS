import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

fun dif(counts: IntArray): Int {
    var min: Int = 0
    for (i in counts.indices) {
        if (0 < counts[i]) {
            min = i
            break
        }
    }
    var max: Int = 0
    for (i in counts.lastIndex downTo 0) {
        if (0 < counts[i]) {
            max = i
            break
        }
    }

    return max - min
}

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val counts: IntArray = List(11) { 0 }.toIntArray()
    val subList: Queue<Int> = LinkedList<Int>()
    var best: Int = 1

    for (i in 0 until n) {
        arr.min()
        val addNum = arr[i]
        subList.add(addNum)
        counts[addNum]++
        while (2 < dif(counts) && subList.isNotEmpty()) {
            val removed = subList.remove()
            counts[removed]--
        }
        best = max(subList.size, best)
    }

    println(best)
}
