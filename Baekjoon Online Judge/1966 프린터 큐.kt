import java.util.LinkedList
import java.util.Queue

fun main() {
    val testCaseNumber = readln().toInt()
    repeat(testCaseNumber) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val queue: Queue<QueueItem> =
            LinkedList(readln().split(" ").map {
                QueueItem(it.toInt(), false)
            }.apply { get(m).isTarget = true })
        var count = 1

        while (queue.isNotEmpty()) {
            val first = queue.first()
            val max = queue.maxOf { it.importanceNumber }

            if (first.isTarget && max == first.importanceNumber) break
            if (max == first.importanceNumber) {
                queue.remove()
                count++
            } else {
                queue.add(first)
                queue.remove()
            }
        }

        println(count)
    }
}

class QueueItem(val importanceNumber: Int, var isTarget: Boolean)