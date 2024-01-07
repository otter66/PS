import kotlin.math.max

var n = 0
var k = 0
var kArr: IntArray = IntArray(0)

fun main() {

    input()
    println(findMax(0, 0))
}

fun input() {
    val (n1, k1) = readln().split(" ").map { it.toInt() }
    n = n1
    k = k1
    kArr = readln().split(" ").map { it.toInt() }.toIntArray()
}

fun findMax(depth: Int, number: Int): Int {
    if (9 < depth) return -1
    if (n < number) return -1
    var best = number

    for (i in 0 until kArr.size) {
        val nextNumber: Int = (number * 10) + kArr[i]
        best = max(best, findMax(depth + 1, nextNumber))
    }

    return best
}