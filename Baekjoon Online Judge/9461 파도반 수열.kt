fun main() {
    var t = readLine()!!.toInt()
    val dp = LongArray(101) { 0 }
    dp[0] = 1
    dp[1] = 1
    dp[2] = 1
    for(i in 3 until 100) {
        dp[i] = dp[i - 2] + dp[i - 3]
    }

    while (t > 0) {
        val n = readLine()!!.toInt()
        println(dp[n - 1])
        t--
    }
}