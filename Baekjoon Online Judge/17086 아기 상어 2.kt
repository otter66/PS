import java.util.Queue
import java.util.LinkedList
import kotlin.math.min
import kotlin.math.max

val dx = arrayOf( 0,  1, 1, 1, 0, -1, -1, -1)
val dy = arrayOf(-1, -1, 0, 1, 1,  1,  0, -1)

fun main() {
    val BABY_SHARK = 1
    val EMPTY_PLACE = 0

    val (n, m) = readln().split(" ").map{ it.toInt() }
    val arr: Array<IntArray> = Array(n) {
        readln().split(" ").map{ it.toInt() }.toIntArray()
    }
    val count: Array<IntArray> = Array(n) { IntArray(m) { 100 } }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] != BABY_SHARK) continue

            val visited: Array<BooleanArray> = Array(n) { BooleanArray(m) { false } }
            val q: Queue<Pair<Int, Int>> = LinkedList() // i, j

            q.add(Pair(i, j))
            visited[i][j] = true
            count[i][j] = 0

            while(q.isNotEmpty()) {
                val current = q.poll()

                for (k in 0 until 8) {
                    val nextI = current.first + dy[k]
                    val nextJ = current.second + dx[k]
                    if (nextI !in 0 until n) continue
                    if (nextJ !in 0 until m) continue
                    if (visited[nextI][nextJ]) continue

                    count[nextI][nextJ] = min(count[nextI][nextJ], count[current.first][current.second] + 1)
                    visited[nextI][nextJ] = true
                    q.add(Pair(nextI, nextJ))
                }
            }
        }
    }

    var max = 0
    for (i in 0 until n) {
        max = max(max, count[i].max())
    }
    println(max)
}
