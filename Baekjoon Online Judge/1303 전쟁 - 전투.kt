import java.util.LinkedList
import java.util.Queue

const val dxdyCount = 4
val dx: IntArray = intArrayOf(0, 0, -1, 1)
val dy: IntArray = intArrayOf(-1, 1, 0, 0)

fun main() {
    val (n: Int, m: Int) = readln().split(" ").map(String::toInt)
    val arr: Array<CharArray> = Array(m) { readln().toCharArray() }
    val visited: Array<BooleanArray> = Array(m) { BooleanArray(n) { false } }
    var whiteCount = 0
    var blueCount = 0

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (visited[i][j]) continue

            var count = 0
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.add(Pair(i, j))

            while (queue.isNotEmpty()) {
                val current: Pair<Int, Int> = queue.poll()
                val currentX: Int = current.second
                val currentY: Int = current.first

                if (visited[currentY][currentX]) continue
                visited[currentY][currentX] = true
                count++

                for (k in 0 until dxdyCount) {
                    if (!isArrRange(n, m, currentX + dx[k], currentY + dy[k])) continue
                    if (arr[currentY + dy[k]][currentX + dx[k]] != arr[i][j]) continue
                    queue.add(Pair(currentY + dy[k], currentX + dx[k]))
                }
            }

            if (arr[i][j] == 'W') whiteCount += (count * count)
            else blueCount += (count * count)

        }
    }

    println("$whiteCount $blueCount")

}

fun isArrRange(n: Int, m: Int, x: Int, y: Int): Boolean =
    x in 0 until n && y in 0 until m