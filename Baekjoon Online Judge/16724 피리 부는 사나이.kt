private const val NOT_VISIT = -1
private const val VISITED = 0
private const val CIRCLED = 1

private var n: Int = -1
private var m: Int = -1
private lateinit var arr: List<List<Char>>
private lateinit var visited: List<MutableList<Int>>
private var count = 0

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    n = a
    m = b
    arr = List(n) { readln().toCharArray().toList() }
    visited = List(n) { MutableList(m) { NOT_VISIT } }

    repeat(n) { i ->
        repeat(m) { j ->
            if (visited[i][j] == NOT_VISIT) dfs(i, j)
        }
    }

    println(count)
}

private fun dfs(rowIndex: Int, colIndex: Int) {
    visited[rowIndex][colIndex] = VISITED

    var nextRowIndex: Int = rowIndex
    var nextColIndex: Int = colIndex
    if (arr[rowIndex][colIndex] == 'D') nextRowIndex++
    else if (arr[rowIndex][colIndex] == 'U') nextRowIndex--
    else if (arr[rowIndex][colIndex] == 'L') nextColIndex--
    else nextColIndex++

    if (visited[nextRowIndex][nextColIndex] == VISITED) count++
    else if (visited[nextRowIndex][nextColIndex] == NOT_VISIT) dfs(nextRowIndex, nextColIndex)

    visited[rowIndex][colIndex] = CIRCLED
}
