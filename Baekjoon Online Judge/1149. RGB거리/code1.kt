import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val cost: Array<IntArray> = Array (n + 1) { IntArray(3) {0} }
    val dp: Array<IntArray> = Array (n + 1) { IntArray(3) {0} }

    for(i in 1 .. n) {
        cost[i] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }
    dp[1][0] = cost[1][0]
    dp[1][1] = cost[1][1]
    dp[1][2] = cost[1][2]

    for(i in 1 .. n) {
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0]
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1]
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2]
    }

    print(min(dp[n][0], min(dp[n][1], dp[n][2])))
}