import java.util.*

val dx = intArrayOf(0, 0, 1, -1, -1, -1, 1, 1)
val dy = intArrayOf(1, -1, 0, 0, -1, 1, -1, 1)

lateinit var arr: List<List<Int>>
lateinit var visited: List<MutableList<Boolean>>

fun main() {
    while (true) {
        val (w, h) = readln().split(" ").map { it.toInt() }
        if (w == 0 && h == 0) return
        arr = List(h) { readln().split(" ").map { it.toInt() } }
        visited = List(h) { MutableList(w) { false } }
        var count = 0

        arr.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, tile ->
                if (tile == 0 || visited[rowIndex][colIndex]) return@forEachIndexed
                checkIsland(rowIndex, colIndex)
                count++
            }
        }

        println(count)
    }

}

fun checkIsland(rowIndex: Int, colIndex: Int) {
    val searchPoint = Pair(rowIndex, colIndex)
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    queue.add(searchPoint)
    visited[searchPoint.first][searchPoint.second] = true

    while (queue.isNotEmpty()) {
        val currentSearchPoint: Pair<Int, Int> = queue.remove()

        dx.forEachIndexed { index, _ ->
            val nextSearchRow = currentSearchPoint.first + dx[index]
            val nextSearchCol = currentSearchPoint.second + dy[index]

            if ((nextSearchRow in arr.indices && nextSearchCol in arr[0].indices).not()) return@forEachIndexed
            if (arr[nextSearchRow][nextSearchCol] == 0) return@forEachIndexed
            if (visited[nextSearchRow][nextSearchCol]) return@forEachIndexed

            queue.add(Pair(nextSearchRow, nextSearchCol))
            visited[nextSearchRow][nextSearchCol] = true
        }
    }
}

/*
45분 소요
checkIsland에서 배열 전체를 돌려고 해 틀렸었다.
그 외에도 dx, dy
세트를 만들지 않고 하려다 시간을 낭비했다.
 */