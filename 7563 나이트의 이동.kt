import java.util.*
import kotlin.math.min

val dx = intArrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
val dy = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)

fun main() {
    var testCase = readLine()!!.toInt()

    while (testCase > 0) {
        val n = readLine()!!.toInt()
        var input = readLine()!!.split(" ").map { it.toInt() }
        val currentPoint = Pair(input[0], input[1])
        input = readLine()!!.split(" ").map { it.toInt() }
        val destinationPoint = Pair(input[0], input[1])
        val check = Array(n) {BooleanArray(n) {false} } //쓸데없는 방문 방지

        val answer = bfs(check, n, currentPoint, destinationPoint)
        println(answer)

        testCase--
    }
}

fun bfs(check: Array<BooleanArray>, n: Int, currentPoint: Pair, destinationPoint: Pair): Int {
    var cnt = Array(n) {IntArray(n) { Int.MAX_VALUE } }
    val q = LinkedList<Pair>()
    q.add(Pair(currentPoint.x, currentPoint.y))
    check[currentPoint.x][currentPoint.y] = true
    cnt[q.first.x][q.first.y] = 0

    while (!q.isEmpty()) {
        val p = q.remove()

        if(p.x == destinationPoint.x && p.y == destinationPoint.y)
            return cnt[p.x][p.y]

        for(k in dx.indices) {
            val nextX: Int = p.x + dx[k]
            val nextY: Int = p.y + dy[k]

            if(nextX in 0 until n && nextY in 0 until n) {
                if(!check[nextX][nextY]) {
                    q.add(Pair(nextX, nextY))
                    check[nextX][nextY] = true

                    cnt[nextX][nextY] = min(cnt[nextX][nextY], cnt[p.x][p.y] + 1)
                }
            }
        }

    }

    return 0
}

class Pair(var x: Int, var y: Int)