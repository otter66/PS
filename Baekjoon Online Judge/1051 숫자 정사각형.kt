import kotlin.math.max

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr: Array<IntArray> = List(n) {
        readln().toCharArray().map { it.digitToInt(10) }.toIntArray()
    }.toTypedArray()
    var best = 1

    for (startRowIndex in 0 until n) {
        for (startColIndex in 0 until m) {
            var size = 1
            while (startRowIndex + size < n && startColIndex + size < m) {
                if (arr[startRowIndex][startColIndex] == arr[startRowIndex + size][startColIndex + size]
                    && arr[startRowIndex][startColIndex] == arr[startRowIndex][startColIndex + size]
                    && arr[startRowIndex][startColIndex] == arr[startRowIndex + size][startColIndex]
                ) best = max(best, (size + 1) * (size + 1))
                size++
            }
        }
    }

    println(best)
}