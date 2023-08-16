fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val arr = readln().split(" ").map(String::toInt)

    var left = 0
    var right = arr.max()
    var best: Int = -1

    while (left <= right) {
        val mid = (left + right) / 2
        val sum = arr.sumOf { if (mid < it) (it - mid).toLong() else 0 }

        if (m <= sum) {
            left = mid + 1
            best = mid
        }
        else right = mid - 1
    }

    println(best)
}