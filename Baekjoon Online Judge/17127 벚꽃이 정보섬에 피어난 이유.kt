import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }

    println(solution(n, arr))
}

fun solution(n: Int, arr: List<Int>): Int {

    var best = -1

    for (i in 1 until n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {
                val sub1 = arr.subList(0, i)
                val sub2 = arr.subList(i, j)
                val sub3 = arr.subList(j, k)
                val sub4 = arr.subList(k, n)
                val sum = multiplication(sub1) + multiplication(sub2) + multiplication(sub3) + multiplication(sub4)
                best = max(best, sum)
            }
        }
    }

    return best
}

fun multiplication(arr: List<Int>): Int {
    var result = 1
    arr.forEach { result *= it }
    return result
}

/*
30분 미만 소요
 */