import java.util.Queue
import java.util.LinkedList

fun main() {
    val MIN = 0
    val MAX = 100_000

    val (n, k) = readln().split(" ").map { it.toInt() }
    val q: Queue<Pair<Int, Int>> = LinkedList() // turnCount, CurrentPoint
    val visited: BooleanArray = BooleanArray(100_001) { false }

    var resultBest = 0
    var resultCount = 1

    q.add(Pair(0, n))

    while (q.isNotEmpty()) {
        val current: Pair<Int, Int> = q.poll()
        val currentCount = current.first
        val currentPoint = current.second
        visited[currentPoint] = true

        if (currentPoint == k) {
            resultBest = currentCount
            break
        }

        val directions = intArrayOf(-1, 1, currentPoint)
        for (i in 0 until 3) {
            val next = currentPoint + directions[i]
            if (next !in MIN..MAX) continue
            if (visited[next]) continue
            q.add(Pair(currentCount + 1, next))
        }
    }

    while (q.isNotEmpty()) {
        val current: Pair<Int, Int> = q.poll()
        val currentCount = current.first
        val currentPoint = current.second
        if (currentPoint == k && currentCount == resultBest) resultCount++
    }

    println(resultBest)
    println(resultCount)
}