
const val WHITE = 0
const val BLUE = 1

var n: Int = -1;
lateinit var arr: Array<IntArray>
var whiteCount: Int = 0
var blueCount: Int = 0

fun main() {
    n = readln().toInt()
    arr = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    countPaper(0, 0, n - 1, n - 1)
    println(whiteCount)
    println(blueCount)
}

fun countPaper(startX: Int, startY: Int, endX: Int, endY: Int) {
    if ((startX == endX && startY == endY) ||
        isPaperUnit(startX, startY, endX, endY)) {

        countColor(arr[startY][startX])
        return
    }

    val dividedX = (startX + endX) / 2
    val dividedY = (startY + endY) / 2

    countPaper(startX, startY, dividedX, dividedY)		// 좌측 상단
    countPaper(dividedX + 1, startY, endX, dividedY)		// 우측 상단
    countPaper(dividedX + 1, dividedY + 1, endX, endY)	// 우측 하단
    countPaper(startX, dividedY + 1, dividedX, endY)	// 좌측 하단
}

fun isPaperUnit(startX: Int, startY: Int, endX: Int, endY: Int): Boolean {
    for (i in startY .. endY) {
        for (j in startX .. endX) {
            if (arr[startY][startX] != arr[i][j]) return false
        }
    }
    return true
}

fun countColor(color: Int) {
    if (color == WHITE) whiteCount++ else blueCount++
}
