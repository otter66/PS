import java.lang.StringBuilder
import java.util.Queue
import java.util.LinkedList
import kotlin.math.min

const val UNREACHED_GROUND_NUMBER = -1
const val UNVISITABLE_GROUND_NUMBER = 0
const val VISITABLE_GROUND_NUMBER = 1
const val TARGET_POINT = 2

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val grounds: List<List<Int>> = List(n) { readln().split(" ").map(String::toInt) }
    val startPoint: Pair<Int, Int> = getStartPoint(grounds)
    val bestDistances: List<List<Int>> = getBestDistances(grounds, startPoint)

    val sb = StringBuilder()
    bestDistances.forEach { sb.append(it.joinToString(" ")) }
    print(sb.toString())
}

fun getStartPoint(grounds: List<List<Int>>): Pair<Int, Int> {
    var point = Pair(UNVISITABLE_GROUND_NUMBER, UNVISITABLE_GROUND_NUMBER)

    grounds.forEachIndexed { rowIndex, row ->
        val colIndex = row.indexOf(TARGET_POINT)
        if (colIndex != -1) point = Pair(rowIndex, colIndex)
    }

    return point
}

fun getBestDistances(grounds: List<List<Int>>, startPoint: Pair<Int, Int>): List<List<Int>> {
    val distances: List<MutableList<Int>> = List(grounds.size) { MutableList(grounds[0].size) { 0 } }
    val visited: List<MutableList<Boolean>> = List(grounds.size) { MutableList(grounds[0].size) { false } }
    val nextPointQueue: Queue<Pair<Int, Int>> = LinkedList()

    nextPointQueue.add(startPoint)

    while (nextPointQueue.isNotEmpty()) {
        val currentPoint: Pair<Int, Int> = nextPointQueue.remove()
        val rowIndex = currentPoint.first
        val colIndex = currentPoint.second

        if (visited[rowIndex][colIndex]) continue
        visited[rowIndex][colIndex] = true

        distances[currentPoint.first][currentPoint.second] =
            if (rowIndex == startPoint.first && colIndex == startPoint.second) 0
            else getSmallestNearNumber(distances, visited, currentPoint) + 1

        if (checkVisitableIndex(grounds, rowIndex - 1, colIndex) && visited[rowIndex - 1][colIndex].not())
            nextPointQueue.add(Pair(rowIndex - 1, colIndex))
        if (checkVisitableIndex(grounds, rowIndex, colIndex - 1) && visited[rowIndex][colIndex - 1].not())
            nextPointQueue.add(Pair(rowIndex, colIndex - 1))
        if (checkVisitableIndex(grounds, rowIndex + 1, colIndex) && visited[rowIndex + 1][colIndex].not())
            nextPointQueue.add(Pair(rowIndex + 1, colIndex))
        if (checkVisitableIndex(grounds, rowIndex, colIndex + 1) && visited[rowIndex][colIndex + 1].not())
            nextPointQueue.add(Pair(rowIndex, colIndex + 1))
    }

    return markUnreachedGround(grounds, distances)
}

fun getSmallestNearNumber(
    distances: List<List<Int>>,
    visited: List<List<Boolean>>,
    currentPoint: Pair<Int, Int>
): Int {
    val rowIndex = currentPoint.first
    val colIndex = currentPoint.second
    var minNumber = Int.MAX_VALUE

    if (rowIndex - 1 >= 0 && visited[rowIndex - 1][colIndex])
        minNumber = min(minNumber, distances[rowIndex - 1][colIndex])
    if (colIndex - 1 >= 0 && visited[rowIndex][colIndex - 1])
        minNumber = min(minNumber, distances[rowIndex][colIndex - 1])
    if (rowIndex + 1 <= distances.lastIndex && visited[rowIndex + 1][colIndex])
        minNumber = min(minNumber, distances[rowIndex + 1][colIndex])
    if (colIndex + 1 <= distances[0].lastIndex && visited[rowIndex][colIndex + 1])
        minNumber = min(minNumber, distances[rowIndex][colIndex + 1])

    return minNumber
}

private fun checkVisitableIndex(grounds: List<List<Int>>, rowIndex: Int, colIndex: Int): Boolean {
    if (rowIndex !in 0..grounds.lastIndex) return false
    if (colIndex !in 0..grounds[0].lastIndex) return false
    if (grounds[rowIndex][colIndex] == UNVISITABLE_GROUND_NUMBER) return false
    return true
}

fun markUnreachedGround(grounds: List<List<Int>>, distances: List<List<Int>>): List<List<Int>> {
    val markedUnreachedGround: List<MutableList<Int>> = distances.map { it.toMutableList() }

    distances.forEachIndexed { rowIndex, _ ->
        distances[rowIndex].forEachIndexed { colIndex, _ ->
            if (distances[rowIndex][colIndex] == 0 && grounds[rowIndex][colIndex] == VISITABLE_GROUND_NUMBER)
                markedUnreachedGround[rowIndex][colIndex] = UNREACHED_GROUND_NUMBER
        }
    }

    return markedUnreachedGround
}