val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() {
    val (m, n) = readLine()!!.split(" ").map { it.toInt() }
    val arr = Array(n) {IntArray(m) {0} }
    for(i in 0 until n) {
        val input = readLine()!!
        for(j in 0 until m) {
            arr[i][j] = input[j].digitToInt()
        }
    }

    print(bfs(arr, n, m))
}

fun bfs(arr: Array<IntArray>, n: Int, m: Int): Int {
    val count = Array(n) {IntArray(m) {-1}}
    val deque = ArrayDeque<Pair>()

    deque.addFirst(Pair(0, 0))
    count[0][0] = 0

    while (!deque.isEmpty()) {
        val now = deque.removeFirst()

        for(k in dx.indices) {
            val nextX = now.x + dx[k]
            val nextY = now.y + dy[k]

            if(nextX in 0 until n && nextY in 0 until m) {
                if(count[nextX][nextY] == -1) {
                    if(arr[nextX][nextY] == 0) {
                        count[nextX][nextY] = count[now.x][now.y]
                        deque.addFirst(Pair(nextX, nextY))
                    } else {
                        count[nextX][nextY] = count[now.x][now.y] + 1
                        deque.addLast(Pair(nextX, nextY))
                    }
                }
            }
        }
    }

    return count[n-1][m-1]
}

class Pair(var x: Int, var y: Int)