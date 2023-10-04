import java.util.LinkedList
import java.util.Queue

lateinit var arr: Array<CharArray>
lateinit var bright: Array<MutableList<Char>>
var r = -1
var c = -1

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    r = a
    c = b
    arr = Array(r) { readln().toCharArray() }
    var (rowIndex, colIndex) = readln().split(" ").map { it.toInt() - 1 }
    val moves: CharArray = readln().toCharArray()
    bright = Array(r) { MutableList(c) { '#' } }

    moves.forEachIndexed { i, move ->
        when (move) {
            'W' -> check(rowIndex, colIndex)
            'L' -> colIndex--
            'R' -> colIndex++
            'U' -> rowIndex--
            'D' -> rowIndex++
        }
    }

    bright[rowIndex][colIndex] = '.'
    if (0 <= rowIndex - 1) bright[rowIndex - 1][colIndex] = '.'
    if (rowIndex + 1 < r) bright[rowIndex + 1][colIndex] = '.'
    if (0 <= colIndex - 1) bright[rowIndex][colIndex - 1] = '.'
    if (colIndex + 1 < c) bright[rowIndex][colIndex + 1] = '.'

    bright.forEach {
        println(it.joinToString(""))
    }

}

fun check(rowIndex: Int, colIndex: Int) {
    bright[rowIndex][colIndex] = '.'
    val a = arr[rowIndex][colIndex]
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(rowIndex, colIndex))
    bright[q.first().first][q.first().second] = '.'

    while (q.isNotEmpty()) {
        val current = q.remove()

        repeat(dx.size) { i ->
            val nextRowIndex = current.first + dx[i]
            val nextColIndex = current.second + dy[i]
            if (nextRowIndex !in 0 until r) return@repeat
            if (nextColIndex !in 0 until c) return@repeat
            if (arr[nextRowIndex][nextColIndex] != a) return@repeat
            if (bright[nextRowIndex][nextColIndex] == '.') return@repeat

            bright[nextRowIndex][nextColIndex] = '.'
            q.add(Pair(nextRowIndex, nextColIndex))
        }
    }
}

/*
58분 소요.
첫 30분은 문제를 푸는데 소요.
나머지 30분은 시간초과를 해결하는데 소요.
List를 Array로 변경하고, DFS를 BFS로 변경했다.
 */

