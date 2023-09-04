fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toLong() }.toLongArray()
    val m = readln().toLong()

    var start = 0L
    var end = m
    var best = -1L

    if (arr.sum() < m) {
        println(arr.max())
        return
    }
    if (arr.sum() == m) {
        println(arr.max())
        return
    }

    while (start <= end) {
        val mid = (start + end) / 2
        val sum = arr.sumOf { if (it < mid) it else mid }

        if (sum <= m) {
            start = mid + 1
            best = mid
        }
        else end = mid - 1
    }

    println(best)
}

/*
약 35분 소요
 */