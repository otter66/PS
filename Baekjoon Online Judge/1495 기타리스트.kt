fun main() {
    val (n, s, m) = readln().split(" ").map { it.toInt() }
    val arr: IntArray = readln().split(" ").map { it.toInt() }.toIntArray()
    val visited: Array<BooleanArray> = Array(n + 2) { BooleanArray(m + 2) { false } }
    visited[0][s] = true

    for (i in 1 .. n) {
        for (j in 0 .. m) {
            if (!visited[i - 1][j]) continue
            val current = arr[i - 1]
            if (j + current <= m) visited[i][j + current] = true
            if (0 <= j - current) visited[i][j - current] = true
        }
    }

    for(i in m downTo  0) {
        if (visited[n][i]) {
            print(i)
            return
        }
    }

    print(-1)
    return
}