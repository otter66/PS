const val EMPTY_PLACE = 0
const val WALL = 1

fun main() {

    val (n, m) = readln().split(" ").map(String::toInt)
    val rains = readln().split(" ").map(String::toInt)
    val arr: Array<IntArray> = Array(n) { IntArray(m) { EMPTY_PLACE } }
    var count = 0

    for (x in 0 until m) {
        for (y in n - rains[x] until n) {
            arr[y][x] = WALL
        }
    }

    for (y in n - 1 downTo 0) {
        for (x in 1 until m) {
            if (arr[y][x - 1] != WALL || arr[y][x] != EMPTY_PLACE) continue
            val nextWall = findNextWall(x, arr[y])
            if (nextWall == -1) continue
            count += x - nextWall
        }
    }

    println(count)
}

fun findNextWall(x: Int, arr: IntArray): Int {
    var result = -1
    for (i in x + 1 until arr.size) {
        if (arr[i] != WALL) continue
        result = i
        break
    }
    return result
}