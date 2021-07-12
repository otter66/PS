fun main() {
    val n = readLine()!!.toInt()
    val cardPackCost = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    cardPackCost.add(0, 0)
    val dp = IntArray(n + 1) { 0 }

    for (k in 1 .. n) {
        dp[k] = cardPackCost[k]
        for (i in 1 .. k) {
            for (j in i .. k) {
                if ((i + j == k) && dp[k] < dp[i] + dp[j])
                    dp[k] = dp[i] + dp[j]
            }
        }
    }

    print(dp[n])
}