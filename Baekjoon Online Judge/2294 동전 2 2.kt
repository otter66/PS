import kotlin.math.min

fun main() {
    val MAX = 10_001

    val (n, k) = readln().split(" ").map(String::toInt)
    val coins: IntArray = IntArray(n) { readln().toInt() }
    val dp: IntArray = IntArray(k + 1) { MAX }

    for (i in 0 until n) {
        for (j in coins[i] .. k) {
            dp[j] = min(dp[j], dp[j - coins[i]] + 1)
        }
    }

    if (dp[k] != MAX) print(dp[k])
    else print(-1)
}