import kotlin.math.max

fun main() {
    var t = readLine()!!.toInt()

    while (t > 0) {
        t--
        val n = readLine()!!.toInt()
        val dp = Array(n + 1) { LongArray(3) { 0 } }
        val score = mutableListOf<IntArray>()
        score.add(readLine()!!.split(" ").map { it.toInt() }.toIntArray())
        score.add(readLine()!!.split(" ").map { it.toInt() }.toIntArray())

        for (i in 1..n) {
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2])
            dp[i][1] = max(dp[i - 1][0], dp[i - 1][2]) + score[0][i-1]
            dp[i][2] = max(dp[i - 1][0], dp[i - 1][1]) + score[1][i-1]
        }

        val answer: Long = max(dp[n][0], dp[n][1], dp[n][2])
        println(answer)
    }
}

fun max(i: Long, i1: Long, i2: Long): Long {
    return max(max(i, i1), i2)
}
