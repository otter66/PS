import kotlin.math.min

private const val BROKE = 0
private const val NORMAL = 1

fun main() {

    val (n, k, b) = readln().split(" ").map { it.toInt() }
    val arr: MutableList<Int> = MutableList(n) { NORMAL }
    repeat(b) { arr[readln().toInt() - 1] = BROKE }

    var bestCount = Int.MAX_VALUE
    var kStartIndex = 0
    var kEndIndex = k

    while (kEndIndex <= n) {
        val subList = arr.subList(kStartIndex, kEndIndex)
        val brokeCount = subList.count { it == BROKE }
        bestCount = min(bestCount, brokeCount)
        kStartIndex++
        kEndIndex++
    }

    println(bestCount)
}
