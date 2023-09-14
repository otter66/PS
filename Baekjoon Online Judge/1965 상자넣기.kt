import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    val dp = MutableList(n) { 0 }
    dp[0] = 1

    arr.forEachIndexed { currentBoxIndex, currentBoxSize ->
        if (currentBoxIndex == 0) return@forEachIndexed

        var max = 0
        for (i in currentBoxIndex - 1 downTo 0) {
            if (currentBoxSize <= arr[i]) continue
            max = max(dp[i], max)
        }

        dp[currentBoxIndex] = max + 1
    }

    println(dp.max())
}