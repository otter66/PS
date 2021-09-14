fun main() {
    val n = readLine()!!.toInt()
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val dp = IntArray(n)

    for (i in 0 until n) {
        dp[i] = numbers[i]
        if (i == 0) continue
        if (dp[i] < dp[i - 1] + numbers[i]) {
            dp[i] = dp[i - 1] + numbers[i]
        }
    }

    var max = -100000001
    for (i in dp.indices) {
        if (max < dp[i]) max = dp[i]
    }

    print(max)
}